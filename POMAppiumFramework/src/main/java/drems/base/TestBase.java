package drems.base;

import drems.util.TestUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{

    public AppiumDriver<MobileElement> mdriver;
    public Properties props;
    public WebDriver wdriver;
    String directory = System.getProperty("user.dir");
    public String instituteIDText="tenant1";
    public String usernameText="tauseefsuperadmin";
    public String passwordText="open@123";


    public TestBase(AppiumDriver<MobileElement> driver) {
        this.mdriver = driver;
    }

    public TestBase()
    {
        try
        {
            props = new Properties();
            FileInputStream ip = new FileInputStream(directory+"/src/main/java/drems/config/config.properties");
            props.load(ip);
            System.out.println("Rameez Print: "+props.getProperty("platformName"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @BeforeMethod
    public void mobileSetup()
    {
        try {
            AppiumDriverLocalService appiumService;
            String appiumServiceUrl;

            appiumService = AppiumDriverLocalService.buildDefaultService();
            appiumService.start();
            appiumService.isRunning();
            appiumServiceUrl = appiumService.getUrl().toString();
            System.out.println("Appium Service Address Rameez : - " + appiumServiceUrl);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", props.getProperty("platformName"));
            caps.setCapability("platformVersion", props.getProperty("platformVersion"));
            caps.setCapability("appPackage", "your app package name");
            caps.setCapability("appActivity", "your app activity");
            //URL url = new URL("http://127.0.0.1:4723/wd/hub");
            //http://0.0.0.0:4723/wd/hub
            URL url = new URL(appiumServiceUrl);
            mdriver = new AndroidDriver<MobileElement>(url, caps);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
        mdriver.manage().timeouts().implicitlyWait(TestUtil.WAIT_TIME, TimeUnit.SECONDS);
    }
    public void webSetup()
    {
        try
        {
            String browserName=props.getProperty("browserName");
            if(browserName.equals("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver",directory+"/src/test/driver/chromedriver.exe");
                wdriver = new ChromeDriver();
            }
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
        wdriver.manage().window().maximize();
        wdriver.manage().timeouts().implicitlyWait(TestUtil.WAIT_TIME, TimeUnit.SECONDS);
    }

}
