package ru.metahash.tests.core.browser.runner.impl;

import com.codeborne.selenide.WebDriverRunner;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.runner.IBrowserRunner;

public class CBTBrowserRunner implements IBrowserRunner {

    @Override
    public void runBrowser(RunConfiguration runConfiguration) {
        WebDriverRunner.setWebDriver(
                WebDriverUtils.initCBTDriver(runConfiguration)
        );
    }

    private String getTestName(RunConfiguration runConfiguration) {
        return runConfiguration.toString();
    }

}
