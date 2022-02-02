package setups;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class  BaseTest{

    WebDriver driver;

    @BeforeTest
    @Parameters({"browserName", "browserVersion"})
    public void setup(String browserName, String browserVersion) throws MalformedURLException {
        SetDriverUp setupDriver = new SetDriverUp(browserName, browserVersion);
        driver = setupDriver.getDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void storeDriver(ITestContext ctx){
        ctx.setAttribute("driver", driver);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
    }

}