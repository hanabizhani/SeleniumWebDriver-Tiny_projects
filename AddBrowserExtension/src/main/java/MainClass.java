import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainClass {

    static int c = 3;
    public static void main(String[] args) {
        try {
            (String a) -> false;
            1 -> false
        }catch(Exception e){
            System.out.println("ddd");
        }


    }

    /*public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");

        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("MyCreatedProfile");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        WebDriver driver =  new FirefoxDriver(firefoxOptions);
        try {
            //driver.get("https://google.com/");
            *//*driver.get("https://www.nab.com.au/personal/customer-support/covid19-help/customer-assistance-directory?topic=HomeLoanTopic&own_cid=19079-1");
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("myRadioButton-0"))).click();*//*

            driver.get("http://demo.guru99.com/test/web-table-element.php#");
            List<WebElement> list = driver.findElements(By.xpath("//a[contains(text(),'Lt')]"));
            System.out.println(list.size() > 0);
            //driver.findElement(By.id("myRadioButton-0")).click();
            //Thread.sleep(60000);
            list.get(0).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }*/
}
