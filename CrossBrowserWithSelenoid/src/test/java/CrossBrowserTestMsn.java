import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setups.BaseTest;


public class CrossBrowserTestMsn extends BaseTest {
    private WebDriver driver;
    String appURL = "https://www.msn.com";


    @BeforeClass(alwaysRun = true)
    public void getCtx(ITestContext ctx) {
        /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();*/

        driver = (WebDriver) ctx.getAttribute("driver");
    }
    @Test
    public void verifyMsnPageTittle() {
        driver.navigate().to(appURL);
        String getTitle = driver.getTitle();
        System.out.println(getTitle);
        Assert.assertEquals(getTitle, "MSN International Edition - World news, Africa news, Asia News, Europe News");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
