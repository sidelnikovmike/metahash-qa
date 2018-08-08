package ru.metahash.tests.core.browser.screenshot.crop.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metahash.tests.core.browser.screenshot.crop.ICropService;

import java.awt.image.BufferedImage;

public class SamsungSCropService implements ICropService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SamsungSCropService.class);

    private static final int TOP_SEARCH_STRING_HEIGHT = 100;
    private static final int BOTTOM_SEARCH_STRING_HEIGHT = 50;

    @Override
    public BufferedImage cropImage(BufferedImage src, long viewPortHeight) {
        LOGGER.info(String.format("Original image height: %s ; viewport height : %s", src.getHeight(), viewPortHeight));
        if (src.getHeight() > viewPortHeight * 2) {
            LOGGER.info(String.format("Image crop started.. top crop(constant): %s, bottom crop(constant): %s ",
                    TOP_SEARCH_STRING_HEIGHT, BOTTOM_SEARCH_STRING_HEIGHT));
            return src.getSubimage(
                    0,
                    TOP_SEARCH_STRING_HEIGHT,
                    src.getWidth(),
                    src.getHeight() - TOP_SEARCH_STRING_HEIGHT - BOTTOM_SEARCH_STRING_HEIGHT
            );
        }
        return src;
    }
}
