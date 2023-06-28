package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPanel {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='menu-item-26']//a")
    public WebElement homePageMenu;

    @FindBy(xpath = "//*[@id='menu-item-46']//a")
    public WebElement catalogMenu;

    @FindBy(xpath = "//*[@id='menu-item-29']//a")
    public WebElement cartMenu;

    @FindBy(xpath = "//*[@id='menu-item-31']//a")
    public WebElement checkoutMenu;

    @FindBy(xpath = "//*[@id='menu-item-363']//a")
    public WebElement bonusMenu;

    public HeaderPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage clickOnHomePage() {
        homePageMenu.click();
        return new HomePage(driver, wait);
    }

//    public BonusPage clickOnBonusProgram() {
//        bonusMenu.click();
//        return new BonusPage(driver, wait);
//    }
}
