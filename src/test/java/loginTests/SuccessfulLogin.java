package loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import testsBase.TestUtils;

public class SuccessfulLogin extends TestUtils {

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isAt());

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
