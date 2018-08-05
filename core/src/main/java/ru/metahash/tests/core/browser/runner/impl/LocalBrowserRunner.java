package ru.metahash.tests.core.browser.runner.impl;

import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.runner.IBrowserRunner;

public class LocalBrowserRunner implements IBrowserRunner {
    @Override
    public void runBrowser(RunConfiguration runConfiguration) {
        System.setProperty("selenide.browser", runConfiguration.getBrowserName());
        //do nothing. Selenide just start browser as is when open page is started. Here could be some custom behaviour.
        //More use for debug on local machine
    }
}
