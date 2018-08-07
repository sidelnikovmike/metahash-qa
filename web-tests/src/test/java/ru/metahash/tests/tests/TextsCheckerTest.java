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
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

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
    public void beforeEach() {
        WebDriverUtils.initDriver();
    }


    @ParameterizedTest(name = "TextsTest: Language: {0}")
    @Description("Test to check texts on page")
    @MethodSource("testData")
    void checkTextsOnPage(String language, List<TextCheckEntity> textCheckEntities) {
        MainPageSteps mainPageSteps = new MainPageSteps().forPage(MainPage.openPage());
        removeUnusedElements();
        mainPageSteps.selectLanguage(language);
        prepareForCheck();
        new TextChecker().checkTexts(textCheckEntities);
    }



    @Step("Prepare for check")
    private void prepareForCheck() {
        BrowserUtils.scrollToBottomOfThePage(3000);
    }

    @Step("Remove unused elements")
    private void removeUnusedElements() {
        Selenide.executeJavaScript("$('#pushw_popup_container').hide();");
    }


    @Step("Opening main page")
    private void openPage() {
        open(CONFIGURATION.getBaseSiteUrl());
    }


    @AfterEach
    public void afterEach() {
        WebDriverUtils.finishDriver();
    }
}
