package ru.metahash.tests.core.browser.domain;

public enum DeviceOrientation {
    PORTRAIT("portrait"),
    LANDSCAPE("landscape");
    private String orientationType;

    DeviceOrientation(String orientationType) {
        this.orientationType = orientationType;
    }

    public String getOrientationType() {
        return orientationType;
    }
}
