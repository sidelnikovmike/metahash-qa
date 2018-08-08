package ru.metahash.tests.core.browser.domain;

import ru.metahash.tests.core.browser.screenshot.crop.ICropService;
import ru.metahash.tests.core.browser.screenshot.crop.impl.DefaultCropService;
import ru.metahash.tests.core.browser.screenshot.crop.impl.IPadCropService;
import ru.metahash.tests.core.browser.screenshot.crop.impl.IphoneCropService;
import ru.metahash.tests.core.browser.screenshot.crop.impl.SamsungSCropService;

public enum  ScreenCropTypeValue {
    DEFAULT("default", new DefaultCropService()),
    IPAD("iPad", new IPadCropService()),
    IPNONE("iPhone", new IphoneCropService()),
    SAMSUNG_S("samsung_s", new SamsungSCropService());

    private String typeText;
    private ICropService cropService;

    ScreenCropTypeValue(String typeText, ICropService cropService) {
        this.typeText = typeText;
        this.cropService = cropService;
    }

    public String getTypeText() {
        return typeText;
    }

    public ICropService getCropService() {
        return cropService;
    }
}
