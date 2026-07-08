package testsBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtils extends DataProviders {

    // WebDriver instance for all classes
    public WebDriver driver;

    // Configuration values from config.properties
    private String browser;
    private String targetURL;
    private int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenTargetUrl() {

        // Read values from configurations with Implicit wait
        readConfig("src/test/resources/config.properties");
        setupDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));

        driver.get(targetURL);
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }

    // readConfig path to the config.properties
    private  void readConfig(String pathToFile) {

        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);

            Properties properties = new Properties();
            properties.load(fileInputStream);

            targetURL = properties.getProperty("url");

            browser = properties.getProperty("browser");

            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }

        catch (IOException e) {
            System.out.println(e);
        }
    }

    // Create WebDriver based on config.properties
    private void setupDriver() {

        switch (browser) {
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            case "safari":
                driver = setupSafariDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }

    // Create and return Firefox,Safari and Chrome WebDrivers
    private WebDriver setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setupSafariDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}