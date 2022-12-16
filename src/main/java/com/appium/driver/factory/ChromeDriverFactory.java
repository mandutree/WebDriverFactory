package com.appium.driver.factory;

import com.appium.driver.capability.ChromeOptionsBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements DriverFactory {
    private static boolean setupOnce = false;
    private ChromeOptionsBuilder chromeOptionsBuilder;

    private ChromeDriverFactory() {
        // Automatically downloads relevant chromedriver, but only do it once per test execution
        if (!setupOnce) {
            WebDriverManager.chromedriver().setup();
            setupOnce = true;
        }

        this.chromeOptionsBuilder = ChromeOptionsBuilder.getInstance();
    }

    public static ChromeDriverFactory getInstance() {
        return new ChromeDriverFactory();
    }

    public ChromeDriverFactory withCapabilityBuilder(ChromeOptionsBuilder optionsBuilder) {
        this.chromeOptionsBuilder = optionsBuilder;
        return this;
    }

    @Override
    public WebDriver create() {
        return new ChromeDriver(chromeOptionsBuilder.build());
    }
}
