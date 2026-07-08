package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage{

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
    public CheckoutInfoPage(WebDriver driver) {
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

    // Enter checkout information
    public void enterCheckoutInfo(String firstName,String lastName,String postalCode) {

        // Validate required checkout fields
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is required!");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name is required!");
        }

        if (postalCode == null || postalCode.isEmpty()) {
            throw new IllegalArgumentException("Postal code is required!");
        }

        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    // Continue to checkout overview
    public void continueCheckout() {
        continueBtn.click();
    }
}