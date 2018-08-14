package ru.metahash.tests.core.browser.domain;

public class HideElementEntity {
    private String locator;
    private int hideOnIteration;

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
