package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://www.roadtrafficsigns.com/";

    @FindBy(xpath = "//*[@id='department_grid_25059']/div[1]//div[@class='product_heading']")
    public WebElement customTrafficSignsTextLink;

    @FindBy(xpath = "//*[@id='department_grid_25059']/div[1]//div[@class='dept_imagebox']")
    public WebElement customTrafficSignsImageBox;

    @FindBy(xpath = "//*[@class='ss_dept_main_heading ']//h1")
    public WebElement customTrafficSignsPageHeading;

//    @FindBy(xpath = "")
//    public WebElement ;
//
//    @FindBy(xpath = "")
//    public WebElement ;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public boolean isPageTitleCustomTrafficSigns() { return driver.getTitle().contains("Custom Traffic Signs"); }

    public String getCustomTrafficSignsPageHeadingText() {
        return customTrafficSignsPageHeading.getText();
    }

}
