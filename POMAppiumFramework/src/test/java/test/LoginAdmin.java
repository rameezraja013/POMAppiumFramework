package test;

import drems.base.TestBase;
import drems.page.admin.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAdmin extends TestBase
{
    @Test
    public void loginAdmin() throws InterruptedException {
        LoginPage lp = new LoginPage(mdriver);
        lp.loginAdmin();
    }

}
