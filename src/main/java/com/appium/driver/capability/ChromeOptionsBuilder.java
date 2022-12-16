package com.appium.driver.capability;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsBuilder implements CapabilityBuilder<ChromeOptions> {
    private final ChromeOptions options;

    private ChromeOptionsBuilder() {
        this.options = new ChromeOptions();
    }

    public static ChromeOptionsBuilder getInstance() {
        return new ChromeOptionsBuilder();
    }

    @Override
    public ChromeOptions build() {
        return options;
    }

    public ChromeOptionsBuilder headless() {
        options.addArguments("headless");
        return this;
    }

    public ChromeOptionsBuilder fullScreen() {
        options.addArguments("start-fullscreen");
        return this;
    }

    public ChromeOptionsBuilder hideScrollbars() {
        options.addArguments("hide-scrollbars");
        return this;
    }

    public ChromeOptionsBuilder disableInfoBars() {
        options.addArguments("disable-infobars");
        return this;
    }

    public ChromeOptionsBuilder windowSize(int width, int height) {
        options.addArguments(String.format("window-size=%d,%d", width, height));
        return this;
    }
}
