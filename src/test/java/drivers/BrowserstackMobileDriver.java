package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackCredentials; //

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
           // return new URL("http://hub.browserstack.com/wd/hub");//
            return new URL(BrowserstackCredentials.config.url());// !!
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        caps.setCapability("browserstack.user", BrowserstackCredentials.config.user()); //!!
        caps.setCapability("browserstack.key", BrowserstackCredentials.config.password()); //!!

        // Set URL of the application under test
        //mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        caps.setCapability("app", BrowserstackCredentials.config.app()); //!!

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        return new AndroidDriver(getBrowserstackUrl(), caps);

    }

}