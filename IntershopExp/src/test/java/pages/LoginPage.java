package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private String userName = "michtor88";
    private String password = "michtest5";

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[contains(@class, 'woocommerce-form-login__submit')]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='post-22']//h2")
    public WebElement myAccountText;

    @FindBy(xpath = "//*[@id='post-22']//*[@class='content-page']//div//li")
    public WebElement authorizationErrorText;

    @FindBy(xpath = "//*[@class='welcome-user']//a[1]//span")
    public WebElement welcomeUserTop;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName() { userNameBox.sendKeys(userName); }

    public void enterPassword() { passwordBox.sendKeys(password); }

    public boolean isPageMyAccount() { return myAccountText.getText().equalsIgnoreCase("Мой аккаунт"); }

    public boolean isErrorTextWrongNameAppear() {
        return authorizationErrorText.getText().equals("Неизвестное имя пользователя. Попробуйте еще раз или укажите адрес почты.");
    }

    public boolean isWelcomeUserTopMatch() {
        return welcomeUserTop.getText().equals(userName);
    }
}
