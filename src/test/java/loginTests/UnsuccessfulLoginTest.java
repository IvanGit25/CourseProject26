package loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import testsBase.TestUtils;

public class UnsuccessfulLoginTest extends TestUtils {

    @Test(dataProvider = "wrongUsers")
    public void unsuccessfulLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
}
