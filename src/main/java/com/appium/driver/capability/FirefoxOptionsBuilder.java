package com.appium.driver.capability;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOptionsBuilder implements CapabilityBuilder<FirefoxOptions> {
    private final FirefoxOptions firefoxOptions;

    private FirefoxOptionsBuilder() {
        firefoxOptions = new FirefoxOptions();
    }

    public static FirefoxOptionsBuilder getInstance() {
        return new FirefoxOptionsBuilder();
    }

    /**
     * Gets the FirefoxOptions.
     */
    @Override
    public FirefoxOptions build() {
        return firefoxOptions;
    }
}
