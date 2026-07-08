package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    // Cart page elements
    @FindBy(className = "title")
    private WebElement cartTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Verify that Cart page is displayed
    @Override
    public boolean isAt() {
        return cartTitle.isDisplayed();
    }

    // Get Cart page title text and button
    public String getPageTitle() {
        return cartTitle.getText();
    }

    public void checkOut() {
        checkoutBtn.click();
    }
}