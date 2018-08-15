package ru.metahash.tests.core.browser.domain;

public class HideElementEntity {
    public static final int ALL_ITERATION_VALUE = -1;
    private String locator;
    private int hideOnIteration = ALL_ITERATION_VALUE;

    public String getLocator() {
        return locator;
    }

    public int getHideOnIteration() {
        return hideOnIteration;
    }

    public HideElementEntity withLocator(String locator) {
        this.locator = locator;
        return this;
    }

    public HideElementEntity withHideOnIteration(int hideOnIteration) {
        this.hideOnIteration = hideOnIteration;
        return this;
    }


}
