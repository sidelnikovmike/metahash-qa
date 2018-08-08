package ru.metahash.tests.core.browser.junit;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static ru.metahash.tests.core.browser.screenshot.ScreenShooter.saveLogs;
import static ru.metahash.tests.core.browser.screenshot.ScreenShooter.savePageSource;
import static ru.metahash.tests.core.browser.screenshot.ScreenShooter.saveScreenShot;

public class ScreenShotOnFailExcension implements AfterEachCallback {


    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        try {
            if (extensionContext.getExecutionException().isPresent()) {
                if (WebDriverUtils.isAlive(WebDriverRunner.getWebDriver())) {
                    saveScreenShot("Screenshot on fail");
                    savePageSource("Page source on fail", true);
                    saveLogs("WebDriver logs on fail");
                }
            }
        } finally {
            closeWebDriver();
        }
    }

}
