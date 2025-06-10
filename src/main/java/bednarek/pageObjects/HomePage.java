package bednarek.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }



    private void open() {
        driver.get(BASE_URL);
    }


    public String getWebTitle() {
        return driver.getTitle();

    }

    @Step("Open web-form page")
    public WebFormPage openWebFormPage() {
        Actions  actions;
        actions = new Actions(driver);
        WebElement webFormLink = driver.findElement(By.linkText("Web form"));
        actions.moveToElement(webFormLink).perform();
        webFormLink.click();

        //driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }


    @Step("Open nav page")
    public NavigationPage openNavigationPage() {
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver);
    }
}

