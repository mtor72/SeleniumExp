import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageTests extends TestBase {
    /*
     * На главной странице кликаем на панели "Планшеты".
     * Проверяем что появляется страница с планшетами.
     */
    @Test
    public void homePage_ClickOnTabletsPane_TabletsPageAppears() {
        //arrange
        var homePage = new HomePage(driver, wait);
        homePage.header.homePageMenu.click();

        //act
        homePage.tabletsPanel.click();

        //assert
        Assertions.assertTrue(homePage.isPageTitleTablets(), "Страница с планшетами не появляется");
    }

    /*
     * На главной странице кликаем на пункте меню "Корзина".
     * Проверяем что появляется страница с корзиной.
     */
    @Test
    public void homePage_ClickOnCartInMenu_CartPageAppears() {
        //arrange
        var homePage = new HomePage(driver, wait);
        homePage.header.homePageMenu.click();

        //act
        homePage.header.cartMenu.click();

        //assert
        var expectedTextCart = "Корзина";
        Assertions.assertEquals(expectedTextCart, homePage.getCartOnCartPageElementText(),
                "Страница с корзиной не появляется");
    }
}
