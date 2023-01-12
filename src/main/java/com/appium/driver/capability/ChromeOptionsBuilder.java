package com.appium.driver.capability;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeOptionsBuilder implements CapabilityBuilder<ChromeOptions> {
    private final ChromeOptions options;

    private ChromeOptionsBuilder() {
        this.options = new ChromeOptions();
    }

    public static ChromeOptionsBuilder getInstance() {
        return new ChromeOptionsBuilder();
    }

    /**
     * Gets the ChromeOptions.
     */
    @Override
    public ChromeOptions build() {
        return options;
    }

    /**
     * Runs the ChromeDriver without the UI.
     */
    public ChromeOptionsBuilder headless() {
        options.addArguments("headless");
        return this;
    }

    /**
     * Opens the Chrome browser in full screen mode.
     */
    public ChromeOptionsBuilder fullScreen() {
        options.addArguments("start-fullscreen");
        return this;
    }

    /**
     * Opens the Chrome browser to take up the whole screen.
     */
    public ChromeOptionsBuilder maximize() {
        options.addArguments("start-maximized");
        return this;
    }

    /**
     * Sets the initial size of the browser in pixels.
     * @param width: Number of horizontal pixels.
     * @param height: Number of vertical pixels.
     */
    public ChromeOptionsBuilder windowSize(int width, int height) {
        options.addArguments(String.format("window-size=%d,%d", width, height));
        return this;
    }

    /**
     * Sets the http proxy.
     * @param host: address of the proxy.  You can include the port in the address.
     */
    public ChromeOptionsBuilder withProxy(String host) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(host);
        options.setCapability("proxy", proxy);
        return this;
    }

    /**
     * Sets the http proxy with host and port.
     * @param host: address of the proxy.
     * @param port: proxy port.
     */
    public ChromeOptionsBuilder withProxy(String host, int port) {
        String hostAndPort = host + ":" + port;
        return withProxy(hostAndPort);
    }

    /**
     * Hides the scrollbars.
     */
    public ChromeOptionsBuilder hideScrollbars() {
        options.addArguments("hide-scrollbars");
        return this;
    }

    /**
     * Disables the info bars.
     */
    public ChromeOptionsBuilder disableInfoBars() {
        options.addArguments("disable-infobars");
        return this;
    }

    /**
     * Exclude switches that disables popup-blocking.
     * ie: This allows ChromeDriver to block popup.
     */
    public ChromeOptionsBuilder disablePopup() {
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        return this;
    }

    /**
     * Specifies the file path to the Chrome Driver.  If you are automatically downloading the driver with
     * <b>ChromeDriverFactory.SETUP = true</b>, then you do not need to set this value.
     * @param path: File path to the Chrome Driver.
     */
    public ChromeOptionsBuilder driverBinary(String path) {
        options.setBinary(path);
        return this;
    }
}
