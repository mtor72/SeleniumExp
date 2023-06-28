package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public HeaderPanel header;
    private String url = "http://intershop.skillbox.ru/";

    @FindBy(xpath = "//*[@class='login-woocommerce']//a")
    public WebElement loginButtonHomePage;

    @FindBy(xpath = "//*[@id='accesspress_storemo-3']//*[@class='promo-widget-wrap']")
    public WebElement tabletsPanel;

    @FindBy(xpath = "//*[@id='accesspress_storemo-4']//*[@class='promo-widget-wrap']")
    public WebElement photoPanel;

    @FindBy(xpath = "//*[contains(@class, 'product_title')]")
    public WebElement itemNameText;

    @FindBy(xpath = "//*[contains(@class, 'shop_table')][contains(@class, 'cart')]//tbody//tr[contains(@class, 'cart_item')]")
    private List<WebElement> cartItem;

    @FindBy(xpath = "//*[contains(@class, 'shop_table')][contains(@class, 'cart')]//tbody//tr[1]//td[@class='product-name']")
    public WebElement itemNameInCartText;

    @FindBy(xpath = "//*[contains(@class, 'shop_table')][contains(@class, 'cart')]//tbody//tr[1]//td[@class='product-price']")
    public WebElement itemPriceInCartText;

    @FindBy(xpath = "//*[contains(@class, 'cart')]//tbody//tr[1]//td[@class='product-remove']//a")
    public WebElement removeItemButton;

    @FindBy(xpath = "//*[@class='woocommerce-message']//a")
    public WebElement restoreItemButton;

    @FindBy(xpath = "//*[@class='login-woocommerce']//a")
    public WebElement logoutButtonHomePage;

    @FindBy(xpath = "//*[@id='accesspress_store_product-2']//*[@class='slick-track']//li[8]//h3")
    public WebElement saleItemTitle;

    @FindBy(xpath = "//*[@id='accesspress_store_product-2']//*[@class='slick-track']//li[8]//ins//span[contains(@class, 'amount')]")
    public WebElement saleItemPrice;

    @FindBy(xpath = "(//*[@class='slick-track']//li[8]//a[contains(@class, 'add_to_cart')])[1]")
    public WebElement saleItemToCartButton;

    @FindBy(xpath = "//*[@class='slick-track']//li[8]//a[contains(@class, 'added_to_cart')]")
    public WebElement saleItemDetailsButton;

    @FindBy(xpath = "//*[@id='accesspress-breadcrumb']//span")
    public WebElement textCartOnCartPage;

    @FindBy(xpath = "(//*[@class='price-cart'])[1]//a")
    public WebElement toCartButton;

    @FindBy(xpath = "//*[@class='post-title']")
    public WebElement textCheckoutOnCheckoutPage;

    @FindBy(xpath = "//*[@class='search-field']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@class='searchsubmit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//*[@class='top-footer-block'])[2]//li[3]//a")
    public WebElement cartLink;

    @FindBy(xpath = "//*[@class='cta-desc_simple']//p[1]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//*[@class='cta-desc_simple']//p[2]")
    public WebElement email;

    @FindBy(xpath = "(//*[@class='top-footer-block'])[2]//li[5]//a")
    public WebElement checkoutLink;

    @FindBy(xpath = "(//*[@class='top-footer-block'])[2]//li[1]//a")
    public WebElement allItemsLink;

    @FindBy(xpath = "//*[@id='title_bread_wrap']//h1")
    public WebElement textAllItemsOnCatalogPage;

    @FindBy(xpath = "//*[@id='custom_html-2']//a[1]")
    public WebElement phoneNumberTop;

    @FindBy(xpath = "//*[@id='custom_html-2']//a[2]")
    public WebElement emailTop;

    @FindBy(xpath = "//*[@id='primary']//*[@class='woocommerce']//p[1]")
    public WebElement cartEmptyText;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        header = new HeaderPanel(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public String getAllItemsElementText() { return textAllItemsOnCatalogPage.getText(); }

    public String getCartOnCartPageElementText() { return textCartOnCartPage.getText(); }

    public String getCheckoutTextOnCheckoutPage() {
        return textCheckoutOnCheckoutPage.getText();
    }

    public String getOnSaleItemTitle() { return saleItemTitle.getText(); }

    public String getOnSaleItemPrice() { return saleItemPrice.getText(); }

    public int getAmountOfItemsInCart() { return cartItem.size(); }

    public String getItemNameInCart() { return itemNameInCartText.getText().toUpperCase(); }

    public String getItemPriceInCart() { return itemPriceInCartText.getText(); }

    public String getItemName() { return itemNameText.getText(); }

    public String getPhoneNumber() { return phoneNumberTop.getText(); }

    public String getEmail() { return emailTop.getText(); }

    public String getPhoneNumberFooter() { return phoneNumber.getAttribute("textContent"); }

    public String getEmailFooter() { return email.getAttribute("textContent"); }

    public boolean isPageTitleTablets() { return driver.getTitle().contains("Планшеты"); }

    public void addFirstRightItemToCart() {
        saleItemToCartButton.click();
        saleItemDetailsButton.click();
    }

    public void waitSaleItemTitleAppears() {
        wait.until(ExpectedConditions.visibilityOf(saleItemTitle));
    }

    public void searchItemName(String itemName) {
        searchBox.sendKeys(itemName);
        searchButton.click();
    }

    public void removeItemsInCart() {
        if(!driver.getTitle().contains("Корзина")) {
            header.cartMenu.click();
        }
        int amountOfItemsInCart = cartItem.size();
        if(amountOfItemsInCart == 2) {
            removeItemButton.click();
            wait.until(ExpectedConditions.visibilityOf(restoreItemButton));
        }
//        removeItemButton.click();
        removeItemButton.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(cartEmptyText));
    }
}
