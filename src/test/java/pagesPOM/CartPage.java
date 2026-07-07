package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    // Cart page title
    @FindBy(className = "title")
    private WebElement cartTitle;

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Verify that Cart page is displayed
    @Override
    public boolean isAt() {
        return cartTitle.isDisplayed();
    }

    // Get Cart page title text
    public String getPageTitle() {
        return cartTitle.getText();
    }
}
