package com.appium.driver.factory;

import com.appium.driver.capability.ChromeOptionsBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory extends DriverFactory<ChromeOptions> {
    public static boolean SETUP = false;
    private static boolean setupOnce = true;

    private ChromeDriverFactory() {
        this.optionsBuilder = ChromeOptionsBuilder.getInstance();
    }

    public static ChromeDriverFactory getInstance() {
        return new ChromeDriverFactory();
    }

    @Override
    public WebDriver create() {
        /* Automatically downloads the relevant Chrome driver if the SETUP is set to true.
         * Only do this once per test execution. */
        if (setupOnce && SETUP) {
            WebDriverManager.chromedriver().setup();
            setupOnce = false;
        }

        return new ChromeDriver(optionsBuilder.build());
    }
}
