package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    // Base Constructor for driver! After to be extended to LoginPage constructor!
    public BasePage(WebDriver driver){
        this.driver = driver;

        // Mandatory: Implements all elements of driver in constructor
        PageFactory.initElements(driver, this);
    }

    // Abstract method for isAt(...isDisplayed) to be implemented/overridden!
    public abstract boolean isAt();
}