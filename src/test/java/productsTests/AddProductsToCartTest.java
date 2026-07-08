package productsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesPOM.LoginPage;
import pagesPOM.ProductsPage;
import testsBase.TestUtils;

public class AddProductsToCartTest extends TestUtils {

    // Add products from CSV file to shopping cart
    @Test(dataProvider = "itemsToBeAdded")
    public void addProductsToCart(String product1,String product2,String product3) {

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

        SoftAssert softAssert = new SoftAssert();

        // Add first product
        productsPage.addProductToCart(product1);
        softAssert.assertEquals(productsPage.getItemsInTheCart(),1,
                "Shopping cart should have 1 item");

        // Add second product
        productsPage.addProductToCart(product2);
        softAssert.assertEquals(productsPage.getItemsInTheCart(),2,
                "Shopping cart should have 2 items");

        // Add third product
        productsPage.addProductToCart(product3);
        softAssert.assertEquals(productsPage.getItemsInTheCart(),3,
                "Shopping cart should have 3 items");

        // Run all assertions
        softAssert.assertAll();
    }
}