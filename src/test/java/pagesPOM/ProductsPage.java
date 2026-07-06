package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    // Products page title
    @FindBy(className = "title")
    private WebElement productsTitle;

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
}
