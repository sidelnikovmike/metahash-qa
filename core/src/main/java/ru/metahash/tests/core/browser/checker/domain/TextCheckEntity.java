package ru.metahash.tests.core.browser.checker.domain;

import java.util.Arrays;
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

    public TextCheckEntity withLocator(String locator){
        this.locator = locator;
        return this;
    }

    public TextCheckEntity withTexts(String... texts){
        this.texts = Arrays.asList(texts);
        return this;
    }

    @Override
    public String toString() {
        return locator;
    }
}
