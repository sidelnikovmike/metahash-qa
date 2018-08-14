package ru.metahash.tests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.metahash.tests.configuration.TestsConfiguration;
import ru.metahash.tests.core.browser.configuration.reader.impl.LocalConfigurationReader;
import ru.metahash.tests.core.browser.domain.HideElementEntity;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;
import ru.metahash.tests.core.browser.screenshot.SmartScreenShooter;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.configuration.reader.IConfigurationReader;
import ru.metahash.tests.core.browser.runner.BrowserRunEngine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@DisplayName("Screenshots maker")
public class ScreenShotMakerTest {

    private static final TestsConfiguration CONFIGURATION = TestsConfiguration.getConfig();
    private static IConfigurationReader configurationReader = new LocalConfigurationReader();
    private BrowserRunEngine browserRunEngine = new BrowserRunEngine();

    private static Stream<RunConfiguration> runConfigurationsData() {
        List<RunConfiguration> runConfigurationList = configurationReader.getConfigurations();
        if (runConfigurationList == null) {
            throw new IllegalStateException("No data for dataprovider found. Please look at configuration of tests");
        }
        return runConfigurationList.stream();
    }


    @ParameterizedTest(name = "ScreenshotTest: Configuration: {0}")
    @Description("Test to get all screenshots for comparison")
    @MethodSource("runConfigurationsData")
    void comparisonScreenShotsMaker(RunConfiguration runConfiguration) {
        browserRunEngine.startBrowser(runConfiguration);
        openPage();
        waitForPageOpen();
        makeScreenShot(runConfiguration);
    }


    @Step("Waiting for page open")
    private void waitForPageOpen() {
        sleep(5000);
    }

    @Step("Opening main page")
    private void openPage() {
        open(CONFIGURATION.getBaseSiteUrl());
    }

    /**
     * maybe here we would save screenshots to folder to open them after in one page
     */
    @Step("Make screenshot")
    private void makeScreenShot(RunConfiguration runConfiguration) {
        SmartScreenShooter.saveScreenShot("SCREEN_" + runConfiguration.toString(), runConfiguration, getElementsToHide());
    }

    private List<HideElementEntity> getElementsToHide() {
        return Arrays.asList(
                new HideElementEntity().withLocator("#pushw_popup_container").withHideOnIteration(0),
                new HideElementEntity().withLocator("#navigation").withHideOnIteration(1),
                new HideElementEntity().withLocator("#launcher").withHideOnIteration(1),
                new HideElementEntity().withLocator("div[class*='telegram-button']").withHideOnIteration(1)
        );

    }

    @AfterEach
    public void afterEach() {
        WebDriverUtils.finishDriver();
    }

}
