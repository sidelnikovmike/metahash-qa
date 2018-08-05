package ru.metahash.tests.core.browser.runner;

import org.openqa.selenium.WebDriver;
import ru.metahash.tests.core.browser.domain.RunConfiguration;

public interface IBrowserRunner {

    /**
     * runs browser by specific configuration.
     * ATTENTION: It must set driver instance to {@link com.codeborne.selenide.WebDriverRunner#setWebDriver(WebDriver)}
     *
     * @param runConfiguration {@link ru.metahash.tests.core.browser.domain.RunConfiguration} browser configuration
     */
    void runBrowser(RunConfiguration runConfiguration);

}
