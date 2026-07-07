package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    // Products page title
    @FindBy(className = "title")
    private WebElement productsTitle;

    // Shopping cart badge
    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    // Shopping cart icon
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    // Constructor
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Verify that Products page is displayed
    @Override
    public boolean isAt() {
        return productsTitle.isDisplayed();
    }

    // Get Products page title text
    public String getPageTitle() {
        return productsTitle.getText();
    }

    // Add product to shopping cart by product name
    public void addProductToCart(String productName) {
        driver.findElement(By.id("add-to-cart-sauce-labs-" + productName)).click();
    }

    // Get number of items in shopping cart
    public int getItemsInTheCart() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    // Open shopping cart
    public void openShoppingCart() {
        shoppingCartLink.click();
    }
}
