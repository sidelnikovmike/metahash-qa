package ru.metahash.tests.core.browser.configuration.reader.impl;

import ru.metahash.tests.core.browser.domain.DeviceOrientation;
import ru.metahash.tests.core.browser.domain.RunConfiguration;
import ru.metahash.tests.core.browser.domain.RunType;
import ru.metahash.tests.core.browser.configuration.reader.IConfigurationReader;
import ru.metahash.tests.core.browser.domain.ScreenCropTypeValue;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: maybe move to tests module
 */
public class LocalConfigurationReader implements IConfigurationReader {
    @Override
    public List<RunConfiguration> getConfigurations() {
        return Arrays.asList(
                new RunConfiguration() //done
                        .withBrowserName("Chrome")
                        .withBrowserVersion("66x64")
                        .withOs("Mac OSX 10.13")
                        .withRunType(RunType.CBT),
                new RunConfiguration() //done
                        .withBrowserName("MicrosoftEdge")
                        .withBrowserVersion("17")
                        .withOs("Windows 10")
                        .withRunType(RunType.CBT),
                new RunConfiguration() //done
                        .withIsMobile(true)
                        .withBrowserName("Safari")
                        .withDeviceName("iPhone 7 Plus Simulator")
                        .withPlatformVersion("10.0")
                        .withPlatformName("iOS")
                        .withDeviceOrientation(DeviceOrientation.PORTRAIT)
                        .withRunType(RunType.CBT)
                        .withScreenCropTypeValue(ScreenCropTypeValue.IPNONE),
                new RunConfiguration() //done
                        .withIsMobile(true)
                        .withBrowserName("Safari")
                        .withDeviceName("iPad Air 2 Simulator")
                        .withPlatformVersion("9.3")
                        .withPlatformName("iOS")
                        .withDeviceOrientation(DeviceOrientation.PORTRAIT)
                        .withRunType(RunType.CBT)
                        .withScreenCropTypeValue(ScreenCropTypeValue.IPAD),
                new RunConfiguration()
                        .withIsMobile(true)
                        .withBrowserName("Chrome")
                        .withDeviceName("Galaxy S7")
                        .withPlatformVersion("7.0")
                        .withPlatformName("Android")
                        .withDeviceOrientation(DeviceOrientation.PORTRAIT)
                        .withRunType(RunType.CBT)
                        .withScreenCropTypeValue(ScreenCropTypeValue.SAMSUNG_S)
        );


    }

}
