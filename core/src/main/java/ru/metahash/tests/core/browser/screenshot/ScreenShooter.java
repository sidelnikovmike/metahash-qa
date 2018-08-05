package ru.metahash.tests.core.browser.screenshot;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

/**
 * Class for simple screen shots
 */
public class ScreenShooter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenShooter.class);

    /**
     * Takes screenshot of the page
     *
     * @param description description for Allure report
     * @return bytes array with screenshot
     */
    @Attachment(value = "{description}", type = "image/jpg")
    public static byte[] saveScreenShot(String description) {
        Object screenShot = getScreenShotFile(OutputType.BYTES);
        if (screenShot != null) {
            return (byte[]) screenShot;
        } else {
            return new byte[0];
        }
    }

    /**
     * Takes html source of the page
     *
     * @param retryIfAlert once retry if needed
     * @return pageSource as String
     */
    @Attachment(value = "{description}", type = "text/html")
    public static String savePageSource(String description, boolean retryIfAlert) {
        try {
            return getWebDriver().getPageSource();
        } catch (UnhandledAlertException e) {
            if (retryIfAlert) {
                try {
                    Alert alert = getWebDriver().switchTo().alert();
                    LOGGER.warn(e + ": " + alert.getText());
                    alert.accept();
                    savePageSource(description, false);
                } catch (Exception unableToCloseAlert) {
                    LOGGER.warn("Failed to close alert: " + unableToCloseAlert);
                }
            } else {
                LOGGER.info("Exception at savePageSourceToFile: ", e);
            }
        } catch (Exception e) {
            LOGGER.error("Exception at savePageSourceToFile: ", e);
            return e.toString();
        }
        return null;
    }

    /**
     * Takes webDriver logs
     *
     * @return logs as String
     */
    @Attachment(value = "{description}", type = "text/html")
    public static String saveLogs(String description) {
        List<String> webDriverLogs = Selenide.getWebDriverLogs(BROWSER, Level.ALL);
        List<String> jsErrorsLogs = Selenide.getJavascriptErrors();
        return "WebDriver logs: \n" +
                String.join(",\n", webDriverLogs) +
                "JS errors: \n" +
                String.join(",\n", jsErrorsLogs);
    }

    private static Object getScreenShotFile(OutputType type) {
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(type);
        } catch (Exception e) {
            LOGGER.info("Exception at getScreenShotFile: ", e);
            return null;
        }
    }


}
