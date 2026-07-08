package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage extends BasePage{

    // Elements
    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy(id="checkout_complete_container")
    private WebElement completeContainer;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement completeHeader;

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    // Methods with Explicit wait
    @Override
    public boolean isAt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(completeContainer));

        return completeContainer.isDisplayed();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getCompleteMessage() {
        return completeHeader.getText();
    }
}