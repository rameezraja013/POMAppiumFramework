package drems.util;

import drems.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase
{
    public static int WAIT_TIME=10;

    public TestUtil(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public TestUtil waitForElement(By locator)
    {
        WebDriverWait wait = new WebDriverWait(mdriver,WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }
    public TestUtil waitAndClick(By locator)
    {
        waitForElement(locator);
        mdriver.findElement(locator).click();
        return this;
    }
}
