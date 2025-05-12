package ui;

import bednarek.pageObjects.HomePage;
import bednarek.pageObjects.NavigationPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static bednarek.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("navigation test")
public class NavigationTests extends BaseTest{




    @Test
    void openNavigationTest(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        String title = navigationPage.getTitle();
        String navUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + navUrl, currentUrl);
        assertEquals("Navigation example", title);
    }


    @Test
    void checkTextTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String textBlock = navigationPage.getTextBlock();

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", textBlock);
    }

    @Test
    void previousButtonDisabledTest(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        boolean isPreviousDisabled = navigationPage.isPreviousButtonDisabled();

        assertTrue(isPreviousDisabled);
    }

    @Test
    void clickNextButtonTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        navigationPage.goToNextPage();
        String currentUrl = navigationPage.getCurrentUrl();

        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation2.html", currentUrl);
    }

}
