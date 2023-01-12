package com.appium.driver.factory;

import com.appium.driver.capability.CapabilityBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public abstract class DriverFactory<T extends Capabilities> {
    protected CapabilityBuilder<T> optionsBuilder;

    public DriverFactory<T> withCapabilityBuilder(CapabilityBuilder<T> optionsBuilder) {
        this.optionsBuilder = optionsBuilder;
        return this;
    }

    public abstract WebDriver create();
}
