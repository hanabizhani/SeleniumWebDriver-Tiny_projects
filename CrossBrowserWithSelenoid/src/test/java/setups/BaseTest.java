package setups;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class  BaseTest{

    WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        SetDriverUp setupDriver = new SetDriverUp();
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