package com.appium.driver;

import com.appium.driver.capability.ChromeOptionsBuilder;
import com.appium.driver.factory.ChromeDriverFactory;
import com.appium.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverBuilderTest {
    @Test
    public void canStartChromeDriver() throws InterruptedException {
        // Determine the browser characteristics
        ChromeOptionsBuilder optionsBuilder =
            ChromeOptionsBuilder
                .getInstance()
                //.fullScreen()
                .hideScrollbars()
                .windowSize(800, 600)
                .disableInfoBars();

        // Construct the WebDriver factory
        DriverFactory factory;
        //if (executeOn == "chrome") {
            factory = ChromeDriverFactory.getInstance().withCapabilityBuilder(optionsBuilder);
        //}
        /*else if (executeOn == "android") {
            factory = AndroidDriverFactory.getInstance().withCapabilityBuilder(optionsBuilder);
        }*/

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
}

