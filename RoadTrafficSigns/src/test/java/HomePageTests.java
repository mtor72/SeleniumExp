import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageTests extends TestBase {
    /* Navigate to Home Page
     *
     */
    @Test
    public void homePage_ClickOnCustomTrafficSignsImageBox_CustomTrafficSignsPageAppears() {
        // arrange
        var homePage = new HomePage(driver, wait);

        // act
        homePage.customTrafficSignsImageBox.click();

        // assert
        Assertions.assertTrue(homePage.isPageTitleCustomTrafficSigns(), "Custom Traffic Signs page doesn't appear");
        var expectedPageHeading = "Custom Traffic Signs";
        Assertions.assertEquals(expectedPageHeading, homePage.getCustomTrafficSignsPageHeadingText(),
                "Custom Traffic Signs heading doesn't appear");
    }

}
