package ru.metahash.tests.configuration;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

public class TestsConfiguration {

    private static TestsConfiguration instance;

    public static TestsConfiguration getConfig() {
        if (instance == null) {
            instance = new TestsConfiguration();
        }
        return instance;
    }

    private TestsConfiguration() {
        PropertyLoader.populate(this);
    }

    @Property("base.site.url")
    private String baseSiteUrl = "https://metahash.org";

    public String getBaseSiteUrl() {
        return baseSiteUrl;
    }
}
