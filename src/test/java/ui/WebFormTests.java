package ui;

import bednarek.pageObjects.HomePage;
import bednarek.pageObjects.WebFormPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import static bednarek.pageObjects.HomePage.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Story("web form page test")
class WebFormTests extends BaseTest{


    @Test
    void openWebFormTest(){
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        String title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title);
    }


    @Test
    void submitFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.submitForm();
        Thread.sleep(2000);
        String title = webFormPage.getTitle();

        assertEquals("Form submitted", title);
    }


    @Test
    void sendTextTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.sendText();
        Thread.sleep(2000);
        String textInput = webFormPage.getTextInput();

        assertEquals("my text",textInput);
    }


    @Test
    void disabledFieldTest() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String textForDisabledInput = "test text";
        WebElement disableField = webFormPage.getDisableInput();

        assertFalse(disableField.isEnabled());
        Exception throwm = assertThrows(ElementNotInteractableException.class, () -> webFormPage.sendToDisableInput(textForDisabledInput));
        assertThat(throwm.getMessage()).contains("element not interactable");
    }


    @Test
    void dropdownSelectTest() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String selectedOption = webFormPage.chooseOptionFromDropDownSelect("2");
        boolean isOptionSelected = webFormPage.isFirstOptionSelected("2");

        assertEquals("Two", selectedOption);
        assertTrue(isOptionSelected);
    }

}
