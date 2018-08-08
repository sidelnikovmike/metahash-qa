package ru.metahash.tests.core.browser.screenshot.crop;

import java.awt.image.BufferedImage;

public interface ICropService {

    BufferedImage cropImage(BufferedImage src, long viewPortHeight);

}
