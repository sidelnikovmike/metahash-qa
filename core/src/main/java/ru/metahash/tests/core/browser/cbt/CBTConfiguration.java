package ru.metahash.tests.core.browser.cbt;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

public class CBTConfiguration {

    private static CBTConfiguration config;

    public static CBTConfiguration getConfig() {
        if (config == null) {
            config = new CBTConfiguration();
        }
        return config;
    }

    private CBTConfiguration() {
        PropertyLoader.populate(this);
    }

    @Property("cbt.user.name")
    private String userName;

    @Property("cbt.api.key")
    private String apiKey;

    public String getUserName() {
        return userName;
    }

    public String getApiKey() {
        return apiKey;
    }
}
