package com.appium.driver.capability;

import org.openqa.selenium.Capabilities;

public interface CapabilityBuilder<T extends Capabilities> {
    T build();
}
