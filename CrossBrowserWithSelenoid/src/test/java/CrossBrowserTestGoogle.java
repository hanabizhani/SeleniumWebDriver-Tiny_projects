import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setups.BaseTest;

public class CrossBrowserTestGoogle extends BaseTest {

    private WebDriver driver;
    String appURL = "http://google.com";

    @BeforeClass(alwaysRun = true)
    public void getCtx(ITestContext ctx) {
        /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();*/

        driver = (WebDriver) ctx.getAttribute("driver");
    }

    @Test
    public void verifyGooglePageTittle() {
        driver.navigate().to(appURL);
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, "Google");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
