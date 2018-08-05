package ru.metahash.tests.core.browser.checker.service;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.metahash.tests.core.browser.checker.domain.TextCheckEntity;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextChecker {

    @Step("Check texts on page")
    public void checkTexts(List<TextCheckEntity> entities) {
        for (TextCheckEntity textCheckEntity : entities) {
            checkEntity(textCheckEntity);
        }
    }

    @Step("Texts for locator `{textCheckEntity}`")
    private void checkEntity(TextCheckEntity textCheckEntity) {
        for (String text : textCheckEntity.getTexts()) {
            $(textCheckEntity.getLocator())
                    .shouldHave(
                            text(text)
                                    .because(String.format(
                                            "Expected text not found in element with locator `%s`",
                                            textCheckEntity.getLocator())
                                    )
                    );
        }

    }
}
