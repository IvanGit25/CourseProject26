package productsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.*;
import testsBase.TestUtils;

public class CheckoutProductsTest extends TestUtils {

    @Test(dataProvider = "checkoutData")
    public void checkoutProductsTest(String firstName,String lastName,String postalCode) {

        // Initialize Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        // Login
        loginPage.login("standard_user" , "secret_sauce");

        // Verify Products Page
        Assert.assertTrue(productsPage.isAt());
        Assert.assertEquals(productsPage.getPageTitle(),"Products");

        // Add products
        productsPage.addProductToCart("backpack");
        productsPage.addProductToCart("bike-light");
        productsPage.addProductToCart("fleece-jacket");

        // Verify Cart badge
        Assert.assertEquals(productsPage.getItemsInTheCart(), 3);

        // Open Shopping cart
        productsPage.openShoppingCart();

        // Verify Cart page
        Assert.assertTrue(cartPage.isAt());
        Assert.assertEquals(cartPage.getPageTitle(), "Your Cart");

        // Checkout
        cartPage.checkOut();

        // Verify Checkout Page
        Assert.assertTrue(checkoutInfoPage.isAt());
        Assert.assertEquals(checkoutInfoPage.getPageTitle(), "Checkout: Your Information");

        // Enter customer information
        checkoutInfoPage.enterCheckoutInfo(firstName, lastName, postalCode);
        checkoutInfoPage.continueCheckout();

        // Verify Checkout Overview Page
        Assert.assertTrue(checkoutOverviewPage.isAt());
        Assert.assertEquals(checkoutOverviewPage.getPageTitle(), "Checkout: Overview");

        // Finish order
        checkoutOverviewPage.finishOrder();

        // Verify Checkout Complete Page
        Assert.assertTrue(checkoutCompletePage.isAt());
        Assert.assertEquals(checkoutCompletePage.getPageTitle(),
                "Checkout: Complete!");
        Assert.assertEquals(checkoutCompletePage.getCompleteMessage(),
                "Thank you for your order!");
    }
}