package ru.metahash.tests.core.browser.screenshot.crop.impl;

import ru.metahash.tests.core.browser.screenshot.crop.ICropService;

import java.awt.image.BufferedImage;

public class DefaultCropService implements ICropService{
    @Override
    public BufferedImage cropImage(BufferedImage src, long viewPortHeight) {
        return src;
    }
}
