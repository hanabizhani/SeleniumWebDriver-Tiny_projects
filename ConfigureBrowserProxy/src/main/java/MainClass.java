import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");

        String host = "shadowsocks6.freeproxy.center";
        String port = "8989";
        String socks5User = "SOCKS_USER";
        String socks5Pass = "SOCKS_Pass";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--proxy-server=socks5://" + host + ":" + port);
        chromeOptions.addArguments("--proxy-auth=" + socks5User + ":" + socks5Pass);
        WebDriver driver =  new ChromeDriver(chromeOptions);
        try {
            driver.get("https://google.com/");
            Thread.sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
