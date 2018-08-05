package ru.metahash.tests.core.browser.runner.impl;

import com.codeborne.selenide.WebDriverRunner;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.runner.IBrowserRunner;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;

public class SelenoidBrowserRunner implements IBrowserRunner {

    @Override
    public void runBrowser(RunConfiguration runConfiguration) {
        WebDriverRunner.setWebDriver(
                WebDriverUtils.initRemoteDriver(
                        runConfiguration
                )
        );
    }
}
