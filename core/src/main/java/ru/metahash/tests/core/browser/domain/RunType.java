package ru.metahash.tests.core.browser.domain;

import com.google.gson.annotations.SerializedName;

public enum RunType {
    @SerializedName("on_device")
    ON_DEVICE,
    @SerializedName("cbt")
    CBT,
    @SerializedName("local")
    LOCAL,
    @SerializedName("selenoid")
    SELENOID
}
