package com.appium.driver.factory;

import com.appium.driver.capability.FirefoxOptionsBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory extends DriverFactory<FirefoxOptions> {
    public static boolean SETUP = false;
    private static boolean setupOnce = true;

    private FirefoxDriverFactory() {
        /* Automatically downloads the relevant Firefox driver if the SETUP is set to true.
         * Only do this once per test execution. */
        if (setupOnce && SETUP) {
            WebDriverManager.firefoxdriver().setup();
            setupOnce = false;
        }

        this.optionsBuilder = FirefoxOptionsBuilder.getInstance();
    }

    public static FirefoxDriverFactory getInstance() {
        return new FirefoxDriverFactory();
    }

    @Override
    public WebDriver create() {
        return new FirefoxDriver(this.optionsBuilder.build());
    }
}
