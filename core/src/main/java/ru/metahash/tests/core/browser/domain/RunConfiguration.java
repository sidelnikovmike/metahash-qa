package ru.metahash.tests.core.browser.domain;

import java.util.HashMap;
import java.util.Map;

public class RunConfiguration {

    private String browserName;
    private String os;
    private String browserVersion;
    private RunType runType;

    private boolean isMobile;
    private String deviceName;
    private String platformVersion;
    private String platformName;
    private DeviceOrientation deviceOrientation;

    private Map<String, String> externalConfigs;

    private ScreenCropTypeValue screenCropTypeValue;

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setVersion(String version) {
        this.browserVersion = version;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public DeviceOrientation getDeviceOrientation() {
        return deviceOrientation;
    }

    public void setDeviceOrientation(DeviceOrientation deviceOrientation) {
        this.deviceOrientation = deviceOrientation;
    }

    public Map<String, String> getExternalConfigs() {
        return externalConfigs;
    }

    public void setExternalConfigs(Map<String, String> externalConfigs) {
        this.externalConfigs = externalConfigs;
    }

    public ScreenCropTypeValue getScreenCropTypeValue() {
        return screenCropTypeValue;
    }

    public void setScreenCropTypeValue(ScreenCropTypeValue screenCropTypeValue) {
        this.screenCropTypeValue = screenCropTypeValue;
    }

    public RunConfiguration withBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public RunConfiguration withBrowserVersion(String version) {
        this.browserVersion = version;
        return this;
    }

    public RunConfiguration withOs(String os) {
        this.os = os;
        return this;
    }

    public RunConfiguration withRunType(RunType runType) {
        this.runType = runType;
        return this;
    }

    public RunConfiguration withIsMobile(final boolean isMobile) {
        this.isMobile = isMobile;
        return this;
    }

    public RunConfiguration withDeviceName(final String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public RunConfiguration withPlatformVersion(final String platformVersion) {
        this.platformVersion = platformVersion;
        return this;
    }

    public RunConfiguration withPlatformName(final String platformName) {
        this.platformName = platformName;
        return this;
    }

    public RunConfiguration withDeviceOrientation(final DeviceOrientation deviceOrientation) {
        this.deviceOrientation = deviceOrientation;
        return this;
    }


    public RunConfiguration withExternalConfig(String configName, String configValue){
        if(externalConfigs == null){
            externalConfigs = new HashMap<>();
        }
        externalConfigs.put(configName, configValue);
        return this;
    }

    public RunConfiguration withScreenCropTypeValue(final ScreenCropTypeValue screenCropTypeValue) {
        this.screenCropTypeValue = screenCropTypeValue;
        return this;
    }


    @Override
    public String toString() {
        if(isMobile){
            return this.browserName + " " + this.deviceName + " " + this.platformName + " " + this.platformVersion + " " + this.deviceOrientation;
        }
        return this.browserName + " " + this.browserVersion + " " + this.os;
    }


}
