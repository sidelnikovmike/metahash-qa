package ru.metahash.tests.core.browser.screenshot;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metahash.tests.core.browser.domain.HideElementEntity;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.utils.BrowserUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static ru.metahash.tests.core.browser.domain.HideElementEntity.ALL_ITERATION_VALUE;
import static ru.metahash.tests.core.browser.utils.BrowserUtils.*;

/**
 * class to make `smart` screenshots - with scrolling
 */
public class SmartScreenShooter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmartScreenShooter.class);
    private static final int DEFAULT_WAIT_TIMEOUT = 5000;

    @Attachment(value = "{description}", type = "image/png")
    public static byte[] saveScreenShot(String description, RunConfiguration runConfiguration, List<HideElementEntity> elementsToHide) {
        int pageHeight = getPageHeight();
        long viewportHeight = getViewPortHeight();
        LOGGER.info(String.format("Viewport height: %s ; page height: %s", viewportHeight, pageHeight));
        hideElement(0, elementsToHide);
        List<byte[]> images = new ArrayList<>();
        images.add(getScreenshot());
        int scrollCount = (int) Math.floor(pageHeight / viewportHeight);
        LOGGER.info(String.format("Scroll count: %s", scrollCount));
        if (scrollCount > 1) {
            long currentYPosition = 0;
            for (int i = 1; i < scrollCount; i++) {
                LOGGER.info(String.format("Scrolling: %s of %s", i, scrollCount));
                scrollDown(viewportHeight);
                waitForScrollFinished();
                if (BrowserUtils.getPageYOffset() == currentYPosition) {
                    LOGGER.info("Scroll finished : y offset not changed from last iteration.");
                    break;
                } else {
                    currentYPosition = BrowserUtils.getPageYOffset();
                }
                hideElement(i, elementsToHide);
                images.add(getScreenshot());
            }
        }
        return imageToByteArray(prepareImage(images, viewportHeight, runConfiguration));
    }

    private static void hideElement(int iteration, List<HideElementEntity> elementsToHide) {
        for (HideElementEntity hideElementEntity : elementsToHide) {
            if (hideElementEntity.getHideOnIteration() == iteration || hideElementEntity.getHideOnIteration() == ALL_ITERATION_VALUE) {
                BrowserUtils.hideElement(hideElementEntity.getLocator());
            }
        }
    }


    public static byte[] getScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) new Augmenter().augment(WebDriverRunner.getWebDriver());
        try {
            return takesScreenshot.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            throw new RuntimeException("Can not parse screenshot data", e);
        }
    }

    @Attachment(value = "{description}", type = "image/png")
    private static byte[] saveSimpleScreenShot(String description, byte[] image) {
        return image;
    }

    private static BufferedImage prepareImage(List<byte[]> images, long viewPortHeight, RunConfiguration runConfiguration) {
//        create a new buffer and draw two image into the new image
        BufferedImage newImage = new BufferedImage(getWidth(images), getHeight(images), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2 = newImage.createGraphics();
        int heightOffset = 0;
        BufferedImage bufImage;
        LOGGER.info("Started preparing final image...");
        for (byte[] image : images) {
            bufImage = byteArrayToImage(image);
            if (runConfiguration.getScreenCropTypeValue() != null) {
                bufImage = runConfiguration
                        .getScreenCropTypeValue()
                        .getCropService()
                        .cropImage(bufImage, viewPortHeight);
            }
            g2.drawImage(bufImage, null, 0, heightOffset);
            LOGGER.info(String.format("Buf image height: %s ; viewport height : %s", bufImage.getHeight(), viewPortHeight));
            heightOffset += bufImage.getHeight();
        }
        LOGGER.info("Final image preparing finished...");
        g2.dispose();
        return newImage;
    }

    private static int getWidth(List<byte[]> images) {
        return byteArrayToImage(images.get(0)).getWidth();
    }

    private static int getHeight(List<byte[]> images) {
        return byteArrayToImage(images.get(0)).getHeight() * images.size();
    }

    private static byte[] imageToByteArray(BufferedImage finalImage) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(finalImage, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Array to image convert failed");
        }
    }

    private static BufferedImage byteArrayToImage(byte[] array) {
        ByteArrayInputStream imageArrayStream = null;
        try {
            imageArrayStream = new ByteArrayInputStream(array);
            return ImageIO.read(imageArrayStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Image to array convert failed");
        } finally {
            IOUtils.closeQuietly(imageArrayStream);
        }
    }

    private static void waitForScrollFinished() {
        sleep(DEFAULT_WAIT_TIMEOUT);
    }


}
