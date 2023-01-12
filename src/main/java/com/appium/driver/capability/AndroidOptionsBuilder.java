package com.appium.driver.capability;

import org.openqa.selenium.MutableCapabilities;

public class AndroidOptionsBuilder implements CapabilityBuilder<MutableCapabilities> {
    private final MutableCapabilities options;

    private AndroidOptionsBuilder() {
        options = new MutableCapabilities();
    }

    public static AndroidOptionsBuilder getInstance() {
        return new AndroidOptionsBuilder();
    }

    @Override
    public MutableCapabilities build() {
        return options;
    }
}
