package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Elements by ID
    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(css = "[data-test='error']")
     WebElement errorMessage;

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    // Constructor for Login
    public LoginPage(WebDriver driver) {
        super(driver);

        // Mandatory: Implements all elements of driver in constructor
        // PageFactory.initElements(driver, this); - moved to Base Page not to be forgotten again :)
    }

    // Override method for Expected result: LoginBtn to be visible
    @Override
    public boolean isAt() {
        return loginBtn.isDisplayed();
    }

    // Perform login using provided credentials
    public void login(String username, String password) {
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        //return new LoginPage(driver);
    }
}
