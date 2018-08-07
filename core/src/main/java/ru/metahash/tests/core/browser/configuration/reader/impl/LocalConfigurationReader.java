package ru.metahash.tests.core.browser.configuration.reader.impl;

import ru.metahash.tests.core.browser.domain.DeviceOrientation;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.domain.RunType;
import ru.metahash.tests.core.browser.configuration.reader.IConfigurationReader;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: maybe move to tests module
 */
public class LocalConfigurationReader implements IConfigurationReader {
    @Override
    public List<RunConfiguration> getConfigurations() {
        return Arrays.asList(
                new RunConfiguration()
                        .withBrowserName("chrome")
                        .withBrowserVersion("67.0")
                        .withOs("Mac OSX 10.13")
                        .withRunType(RunType.CBT)
//                new RunConfiguration()
//                        .withBrowserName("MicrosoftEdge")
//                        .withBrowserVersion("17")
//                        .withOs("Windows 10")
//                        .withRunType(RunType.CBT),
//                new RunConfiguration()
//                        .withIsMobile(true)
//                        .withBrowserName("Safari")
//                        .withDeviceName("iPhone 7 Plus Simulator")
//                        .withPlatformVersion("10.0")
//                        .withPlatformName("iOS")
//                        .withDeviceOrientation(DeviceOrientation.PORTRAIT)
//                        .withRunType(RunType.CBT)
//                new RunConfiguration()
//                        .withIsMobile(true)
//                        .withBrowserName("Safari")
//                        .withDeviceName("iPad Air 2 Simulator")
//                        .withPlatformVersion("9.3")
//                        .withPlatformName("iOS")
//                        .withDeviceOrientation(DeviceOrientation.LANDSCAPE)
//                        .withRunType(RunType.CBT),
//                new RunConfiguration()
//                        .withIsMobile(true)
//                        .withBrowserName("Chrome")
//                        .withDeviceName("Nexus 9")
//                        .withPlatformVersion("6.0")
//                        .withPlatformName("Android")
//                        .withDeviceOrientation(DeviceOrientation.PORTRAIT)
//                        .withRunType(RunType.CBT)
        );
    }

}
