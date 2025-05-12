package bednarek.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    @FindBy(className = "display-6")
    private WebElement title;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Step("Get current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    @Step("Get title")
    public String getTitle() {
        return title.getText();
    }
}
