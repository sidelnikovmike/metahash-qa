package ru.metahash.tests.core.browser.runner;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metahash.tests.core.browser.cbt.CBTConfiguration;
import ru.metahash.tests.core.browser.configuration.WebConfig;
import ru.metahash.tests.core.browser.domain.RunConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WebDriverUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverUtils.class);
    private static final CBTConfiguration CBT_CONFIGURATION = CBTConfiguration.getConfig();
    private static final WebConfig WEB_CONFIG = WebConfig.getConfig();

    private static final String RESOLUTION_FULL_HD = "1920x1080x24";
    private static final Dimension DIMENSION_FULL_HD = new Dimension(1920, 1080);


    /**
     * init CrossBrowserTesting browser
     *
     * @param runConfiguration configuration for test
     * @return WebDriver instance
     */
    @Step("Init driver for test {runConfiguration}")
    public static RemoteWebDriver initCBTDriver(RunConfiguration runConfiguration) {
        return initCBTDriver(
                runConfiguration,
                CBT_CONFIGURATION.getUserName(), CBT_CONFIGURATION.getApiKey());
    }

    private static String getTestName(RunConfiguration runConfiguration) {
        return runConfiguration.toString();
    }

    /**
     * init CrossBrowserTesting browser
     *
     * @param runConfiguration configuration to run browser
     * @param cbtUserName      username for cbt
     * @param cbtApiKey        api key for cbt
     * @return WebDriver instance
     */
    @Step("Init driver for test {runConfiguration}")
    public static RemoteWebDriver initCBTDriver(RunConfiguration runConfiguration, String cbtUserName, String cbtApiKey) {
        DesiredCapabilities capability = getCapabilities(runConfiguration);
        try {
            return new RemoteWebDriver(
                    new URL("http://" + cbtUserName + ":" + cbtApiKey + "@hub.crossbrowsertesting.com:80/wd/hub"),
                    capability
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error while configuring url for remote web driver");
        }
    }

    public static void finishDriver() {
        WebDriverRunner.closeWebDriver();
    }


    /**
     * init Remote Selenoid driver
     *
     * @param runConfiguration configuration to run browser
     * @return WebDriver instance or exception will be thrown
     */
    @Step("Init driver for configuration {runConfiguration}")
    public static RemoteWebDriver initRemoteDriver(RunConfiguration runConfiguration) {
        LOGGER.info(" Begin init RemoteWebDriver for browser: " + runConfiguration.getBrowserName() + ":" + runConfiguration.getBrowserVersion() +
                "\n on remote URL: " + WEB_CONFIG.getRemoteHubUrl() +
                "\n at <" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + ">"
        );
        DesiredCapabilities capabilities = getCapabilities(runConfiguration);
        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL(WEB_CONFIG.getRemoteHubUrl()), capabilities);
            driver.setFileDetector(new LocalFileDetector());
            driver.manage().window().setSize(DIMENSION_FULL_HD);
            return driver;
        } catch (MalformedURLException e) {
            LOGGER.error("Error while configuring url for remote web driver", e);
            throw new IllegalStateException("Error while configuring url for remote web driver");
        }
    }

    private static DesiredCapabilities getCapabilities(RunConfiguration runConfiguration) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name", "Some test name");
        capabilities.setBrowserName(runConfiguration.getBrowserName());
        capabilities.setCapability("record_video", "true");
        capabilities.setCapability("screenResolution", RESOLUTION_FULL_HD);
        capabilities.setCapability("enableVNC", true);

        if (!runConfiguration.isMobile()) {
            capabilities.setVersion(runConfiguration.getBrowserVersion());
            capabilities.setCapability("screenResolution", "1366x768");
        } else {
            capabilities.setCapability("deviceName", runConfiguration.getDeviceName());
            capabilities.setCapability("platformVersion", runConfiguration.getPlatformVersion());
            capabilities.setCapability("platformName", runConfiguration.getPlatformName());
            capabilities.setCapability("deviceOrientation", runConfiguration.getDeviceOrientation().getOrientationType());
        }
        return capabilities;
    }

    /**
     * init driver with default params
     */
    public static void initDriver() {
        initDriver(new RunConfiguration().withBrowserName(WEB_CONFIG.getBrowserName()).withBrowserVersion(WEB_CONFIG.getBrowserVersion()));
    }

    /**
     * init driver
     *
     * @param runConfiguration configuration to run browser
     */
    public static void initDriver(RunConfiguration runConfiguration) {
        LOGGER.info("Init webDriver params:" +
                "\n -Dis.local = " + WEB_CONFIG.isLocal());
        if (!WEB_CONFIG.isLocal()) {
            WebDriverRunner.setWebDriver(initRemoteDriver(runConfiguration));
        } else {
            System.setProperty("selenide.browser", runConfiguration.getBrowserName());
        }
    }
}
