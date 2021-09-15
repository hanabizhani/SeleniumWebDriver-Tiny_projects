import com.google.common.collect.ImmutableMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;

public class MainClass {

    public static void main(String[] args) throws InterruptedException, JSONException {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability( "goog:loggingPrefs", loggingPreferences );

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.tradingview.com/chart/?symbol=CRYPTOCAP%3ABTC");
        Thread.sleep(5000);
        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
        driver.close();
        driver.quit();

        logEntries.forEach(entry->{
            try{
            JSONObject messageJSON = null;

                messageJSON = new JSONObject(entry.getMessage());

            String method = messageJSON.getJSONObject("message").getString("method");
            if(method.equalsIgnoreCase("Network.webSocketFrameSent")){
                System.out.println("Message Sent: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
            }else if(method.equalsIgnoreCase("Network.webSocketFrameReceived")){
                System.out.println("Message Received: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });



    }
}
