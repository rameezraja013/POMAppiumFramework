package drems.page.admin;

import drems.base.TestBase;
import drems.util.TestUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends TestBase
{
    public By instituteID = By.xpath("//android.widget.EditText[@text='Enter your instituional id or app name ...']");
    public By iHaveUsedThisAppBtn = By.xpath("//android.widget.TextView[@text=\"I've used this app\"]");
    public By userName = By.xpath("//android.widget.EditText[@text='Enter your username or email']");
    public By password = By.xpath("//android.widget.EditText[@text='Enter your password']");
    public By whileUsingTheApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    public By loginButton = By.xpath("//*[@resource-id='LogInButton']");
    TestUtil testUtil = new TestUtil(mdriver);

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public LoginPage loginAdmin() throws InterruptedException {

        testUtil.waitAndClick(whileUsingTheApp);
        mdriver.findElement(instituteID).sendKeys(instituteIDText);
        mdriver.findElement(userName).sendKeys(usernameText);
        mdriver.findElement(password).sendKeys(passwordText);
        testUtil.waitAndClick(loginButton);
        Thread.sleep(5000);
        return this;
    }
}
