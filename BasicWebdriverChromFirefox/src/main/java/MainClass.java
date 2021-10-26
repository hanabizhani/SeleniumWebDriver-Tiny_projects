import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");

        //Comment-unComment anyone you wanna test
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.get("https://www.google.com/");
        /*WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("YouTube");
        searchbox.submit();*/


        driver.get("http://localhost:8080/WebappModule_Web2_exploded/");

        String xpath = String.format("//div[@class='SelectBox']/ul/li[contains(text(),'{0}')]", "IRAN");
        driver.findElement(By.xpath(xpath));
        Select select = new Select(driver.findElement(By.xpath("//div[@class='SelectBox']")));
        select.selectByVisibleText("IRAN");

        Thread.sleep(5000);//For user to watch what happend
        driver.quit();
    }
}
