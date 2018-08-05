package ru.metahash.tests.core.browser.checker.domain;

import java.util.List;

public class TextCheckEntity {
    private String locator;
    private List<String> texts;

    public String getLocator() {
        return locator;
    }

    public List<String> getTexts() {
        return texts;
    }

    @Override
    public String toString() {
        return locator;
    }
}
