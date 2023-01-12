# WebDriverFactory
The original purpose of this project is to show how we can simply the construction of WebDrivers.  We can hide the
complexity of "how to" setup the driver with a descriptive method name.  This project attempt to show the beginnings of
how the code can be structured to simply it's usage.

As of this writing, this project contains working examples of constructing Chrome driver.  It also contains skeleton
code for Firefox and Android drivers.  To view an example of how the ChromeDriverFactory might work.  See
DriverBuilderTest.java

## Downloading ChromeDriver
Setting the parameter:

    ChromeDriverFactory.SETUP = true;

prior to constructing your first ChromeDriver

    ChromeDriverFactory.getInstance().create();

will allow the ChromeDriverFactory to connect to the internet to download the chrome
driver that matches your current version of Chrome.

## Setting Options
Options builder simplifies the configuration by providing descriptive method names, preventing you from having to
remember the parameter name and their function.

    ChromeOptionsBuilder optionsBuilder = ChromeOptionsBuilder.getInstance()
            .headless().withProxy("localhost", 8888).disablePopup();
    WebDriver driver = ChromeDriverFactory.getInstance()
            .withCapabilityBuilder(optionsBuilder).create();