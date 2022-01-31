package setups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SetDriverUp {

    private RemoteWebDriver driver;

    public SetDriverUp() throws MalformedURLException {
        /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "97.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
