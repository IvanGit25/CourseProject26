package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    // Elements
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    // Constructor
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    @Override
    public boolean isAt() {
        return finishBtn.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void finishOrder() {
        finishBtn.click();
    }
}