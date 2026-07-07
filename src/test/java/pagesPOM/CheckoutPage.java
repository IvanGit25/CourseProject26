package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    // Checkout page title and ID elements
    @FindBy(className = "title")
    private WebElement checkoutTitle;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Verify that Checkout page is displayed
    @Override
    public boolean isAt() {
        return checkoutTitle.isDisplayed();
    }

    // Get Checkout page title text
    public String getPageTitle() {
        return checkoutTitle.getText();
    }
}
