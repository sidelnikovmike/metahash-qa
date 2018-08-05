package ru.metahash.tests.tests;

import com.codeborne.selenide.Selenide;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.metahash.tests.configuration.TestsConfiguration;
import ru.metahash.tests.core.browser.checker.domain.TextCheckEntity;
import ru.metahash.tests.core.browser.checker.service.TextChecker;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;
import ru.metahash.tests.core.browser.utils.BrowserUtils;
import ru.metahash.tests.core.utils.FilesUtils;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextsCheckerTest {
    private static final TestsConfiguration CONFIGURATION = TestsConfiguration.getConfig();

    private static Stream<Arguments> testData() {

        return Stream.of(
                Arguments.of(
                        "ru",
                        getLanguageEntities("ru")
                ),
                Arguments.of(
                        "en",
                        getLanguageEntities("en")
                )
        );
    }

    private static List<TextCheckEntity> getLanguageEntities(String language) {
        List<TextCheckEntity> entities = getTextCheckEntities(language);
        if (entities == null) {
            throw new IllegalStateException("No data for dataprovider found for language " + language +
                    ". Please look at configuration of text tests");
        }
        return entities;
    }

    private static List<TextCheckEntity> getTextCheckEntities(String language) {
        return new GsonBuilder().create()
                .fromJson(
                        FilesUtils.getResourcesFileSource("/texts/" + language + "_texts.json"),
                        new TypeToken<List<TextCheckEntity>>() {
                        }.getType());
    }

    @BeforeEach
    public void beforeEach(){
        WebDriverUtils.initDriver();
    }



    @ParameterizedTest(name = "TextsTest: Language: {0}")
    @Description("Test to check texts on page")
    @MethodSource("testData")
    void checkTextsOnPage(String language, List<TextCheckEntity> textCheckEntities) {
        openPage();
        waitForPageOpen();
        removeUnusedElements();
        selectLanguage(language);
        prepareForCheck();
        new TextChecker().checkTexts(textCheckEntities);
    }

    @Step("Select language")
    private void selectLanguage(String language) {
        $("div[class*='lang-switch']").click();
        $("div[class*='lang-switch-container']").shouldBe(visible.because("Language select popup not displayed"));
        $$("div[class*='switch_item']")
                .shouldHave(sizeGreaterThanOrEqual(1).because("Elements with language select not found in popup"))
                .filter(attribute("data-value", language))
                .shouldHave(size(1).because(String.format("Not found element for language `%s`", language)))
                .first()
                .click();
    }

    @Step("Prepare for check")
    private void prepareForCheck() {
        BrowserUtils.scrollToBottomOfThePage(3000);
    }

    @Step("Remove unused elements")
    private void removeUnusedElements() {
        Selenide.executeJavaScript("$('#pushw_popup_container').hide();");
    }

    @Step("Waiting for page open")
    private void waitForPageOpen() {
        sleep(5000);
    }

    @Step("Opening main page")
    private void openPage() {
        open(CONFIGURATION.getBaseSiteUrl());
    }


    @AfterEach
    public void afterEach(){
        WebDriverUtils.finishDriver();
    }
}
