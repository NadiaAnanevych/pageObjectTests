package ui;

import bednarek.pageObjects.HomePage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests extends BaseTest{


    @Test
    void openHomePageTest(){
        HomePage homePage = new HomePage(driver);
        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
