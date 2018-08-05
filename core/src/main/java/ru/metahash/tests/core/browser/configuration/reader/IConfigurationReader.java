package ru.metahash.tests.core.browser.configuration.reader;

import ru.metahash.tests.core.browser.domain.RunConfiguration;

import java.util.List;

public interface IConfigurationReader {

    /**
     * getting configurations for tests to run
     *
     * @return list of {@link ru.metahash.tests.core.browser.domain.RunConfiguration} objects or null if no configuration found
     */
    List<RunConfiguration> getConfigurations();


}
