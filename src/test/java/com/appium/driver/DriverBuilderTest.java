package com.appium.driver;

import com.appium.driver.capability.ChromeOptionsBuilder;
import com.appium.driver.capability.FirefoxOptionsBuilder;
import com.appium.driver.factory.ChromeDriverFactory;
import com.appium.driver.factory.DriverFactory;
import com.appium.driver.factory.FirefoxDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverBuilderTest {
    @Test
    public void canStartChromeDriver() throws InterruptedException {
        // This will Download the relevant Chrome Driver
        ChromeDriverFactory.SETUP = true;

        // Determine the browser characteristics
        ChromeOptionsBuilder optionsBuilder =
            ChromeOptionsBuilder
                .getInstance()
                .fullScreen()
                .hideScrollbars()
                .disableInfoBars();

        // Construct the WebDriver factory
        DriverFactory factory = ChromeDriverFactory.getInstance().withCapabilityBuilder(optionsBuilder);

        // Create an instance of the WebDriver
        WebDriver withUI = factory.create();

        // Create a second headless instance of the WebDriver
        optionsBuilder.headless();
        WebDriver withoutUI = factory.create();

        // Do something with the first WebDriver
        withUI.get("https://google.com");
        Thread.sleep(1000);

        // Do something with the second WebDriver
        withoutUI.get("https://google.com");
        Thread.sleep(1000);

        // Cleanup
        withoutUI.quit();
        withUI.quit();
    }

    @Test
    public void canStartFirefoxDriver() throws InterruptedException {
        // This will Download the relevant Firefox Driver
        FirefoxDriverFactory.SETUP = true;

        FirefoxOptionsBuilder optionsBuilder =
            FirefoxOptionsBuilder.getInstance();

        DriverFactory factory = FirefoxDriverFactory.getInstance()
            .withCapabilityBuilder(optionsBuilder);

        // Create an instance of the WebDriver
        WebDriver withUI = factory.create();

        // Do something with the first WebDriver
        withUI.get("https://google.com");
        Thread.sleep(1000);

        // Cleanup
        withUI.quit();
    }
}

