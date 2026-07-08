package loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductsPage;
import testsBase.TestUtils;

public class SuccessfulLoginTest extends TestUtils {

    @Test
    public void successfulLoginTest() {

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Verify that Login Page is displayed
        Assert.assertTrue(loginPage.isAt());

        // Login with valid credentials
        loginPage.login("standard_user", "secret_sauce");

        // Create Products Page object
        ProductsPage productsPage = new ProductsPage(driver);

        // Verify that Products Page is displayed
        Assert.assertTrue(productsPage.isAt());

        // Verify Products Page title
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }
}