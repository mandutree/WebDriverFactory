package com.appium.driver.factory;

import com.appium.driver.capability.AndroidOptionsBuilder;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class AndroidDriverFactory extends DriverFactory<MutableCapabilities>{
    private URL url;
    private AndroidOptionsBuilder optionsBuilder;

    private AndroidDriverFactory() {
        optionsBuilder = AndroidOptionsBuilder.getInstance();
    }

    public static AndroidDriverFactory getInstance() {
        return new AndroidDriverFactory();
    }

    @Override
    public WebDriver create() {
        if (url == null) {
            throw new RuntimeException("You must specify the appium server url");
        }

        return new AndroidDriver(url, optionsBuilder.build());
    }

    /**
     * Specify the URL of the remote or local Appium Server.
     * @param remoteUrl: URL of the remote Appium Server.
     */
    public AndroidDriverFactory appiumServer(URL remoteUrl) {
        this.url = remoteUrl;
        return this;
    }
}
