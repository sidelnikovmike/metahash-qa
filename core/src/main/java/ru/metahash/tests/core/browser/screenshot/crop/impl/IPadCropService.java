package ru.metahash.tests.core.browser.screenshot.crop.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metahash.tests.core.browser.screenshot.crop.ICropService;

import java.awt.image.BufferedImage;

public class IPadCropService implements ICropService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPadCropService.class);

    @Override
    public BufferedImage cropImage(BufferedImage src, long viewPortHeight) {
        LOGGER.info(String.format("Original image height: %s ; viewport height : %s", src.getHeight(), viewPortHeight));
        if (src.getHeight() > viewPortHeight * 2) {
            long diff = src.getHeight() - viewPortHeight * 2;
            LOGGER.info("Image crop started.. Diff: " + diff);
            return src.getSubimage(0, (int) diff, src.getWidth(), (int) (src.getHeight() - diff));
        }
        return src;
    }
}
