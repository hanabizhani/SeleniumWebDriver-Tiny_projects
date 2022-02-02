package setups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public SetDriverUp(String browserName, String browserVersion) throws MalformedURLException {

       /* if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else{
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            driver = new FirefoxDriver();
        }*/


        System.out.println("------------" + browserName + browserVersion);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
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
