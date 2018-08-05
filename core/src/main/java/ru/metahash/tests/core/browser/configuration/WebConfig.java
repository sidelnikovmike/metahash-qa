package ru.metahash.tests.core.browser.configuration;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

public class WebConfig {

    private static WebConfig config;


    public static WebConfig getConfig() {
        if (config == null) {
            config = new WebConfig();
        }
        return config;
    }

    private WebConfig() {
        PropertyLoader.populate(this);
    }

    @Property("browser.name")
    private String browserName = "chrome";

    @Property("browser.version")
    private String browserVersion = "";

    @Property("is.local")
    private boolean isLocal = true;

    @Property("remote.hub.url")
    private String remoteHubUrl = "http://selenoid:Dnk2vS7VQ8R83vwS@139.59.157.16:4444/wd/hub";

    public String getRemoteHubUrl() {
        return remoteHubUrl;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public boolean isLocal() {
        return isLocal;
    }
}
