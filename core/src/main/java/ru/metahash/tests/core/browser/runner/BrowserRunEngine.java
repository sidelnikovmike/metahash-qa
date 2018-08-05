package ru.metahash.tests.core.browser.runner;

import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.domain.RunType;
import ru.metahash.tests.core.browser.runner.impl.CBTBrowserRunner;
import ru.metahash.tests.core.browser.runner.impl.LocalBrowserRunner;
import ru.metahash.tests.core.browser.runner.impl.SelenoidBrowserRunner;

import java.util.HashMap;
import java.util.Map;

public class BrowserRunEngine {

    public void startBrowser(RunConfiguration runConfiguration) {
        IBrowserRunner browserRunner = getBrowserRunner(runConfiguration.getRunType());
        if (browserRunner == null) {
            throw new IllegalStateException("No runner found for run type " + runConfiguration.getRunType());
        }
        else {
            browserRunner.runBrowser(runConfiguration);
        }
    }

    private IBrowserRunner getBrowserRunner(RunType runType) {
        return getRunnersMap().get(runType);
    }

    private Map<RunType, IBrowserRunner> getRunnersMap() {
        Map<RunType, IBrowserRunner> runnersMap = new HashMap<>();
        runnersMap.put(RunType.CBT, new CBTBrowserRunner());
//        runnersMap.put(RunType.ON_DEVICE, new DeviceBrowserRunner());
        runnersMap.put(RunType.LOCAL, new LocalBrowserRunner());
        runnersMap.put(RunType.SELENOID, new SelenoidBrowserRunner());
        return runnersMap;
    }
}
