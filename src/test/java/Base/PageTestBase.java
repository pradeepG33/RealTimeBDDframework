package Base;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageTestBase {
    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver WebDriverManager() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url = prop.getProperty("Mobil");
        String browser_properties = prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        // result = testCondition ? value1 : value2

        String browser = browser_maven!=null ? browser_maven : browser_properties;


//boolean enableGeolocation = Boolean.parseBoolean(prop.getProperty("enableGeolocation", "false"));
        if(driver == null)
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
              //  if(enableGeolocation){

                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 = Block
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    options.setExperimentalOption("prefs", prefs);
                ChromeDriver driver = new ChromeDriver(options);

                ((ChromeDriver)driver).executeCdpCommand("Browser.grantPermissions",
                Map.of(
                        "origin", "https://www.mobil.com",
                        "permissions", Arrays.asList("geolocation")
                      //  "setting", "denied"
                )
                );


               // }

                driver.manage().window().maximize();

            }
            if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }

        return driver;

    }

    @After
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();  // Closes all windows and ends the session
            driver = null;  // Helps avoid stale driver issues in next test
            System.out.println("Browser closed successfully.");
        }
    }
}
