import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        var options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() { driver.quit(); }

    @BeforeEach
    public void logIn() {
        var homePage = new HomePage(driver, wait);
        var loginPage = new LoginPage(driver);

        homePage.open();
        homePage.loginButtonHomePage.click();
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.loginButton.click();
    }

    @AfterEach
    public void logOut() {
        var homePage = new HomePage(driver, wait);
        homePage.logoutButtonHomePage.click();
    }
}
