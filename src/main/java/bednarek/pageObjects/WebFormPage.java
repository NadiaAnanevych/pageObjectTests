package bednarek.pageObjects;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";


    @FindBy(tagName = "button")
    private WebElement submitButton;

    @FindBy(name = "my-textarea")
    private WebElement sendTextInput;

    @FindBy(className = "form-select")
    private WebElement selectOptions;

    @FindBy(name = "my-disabled")
    private WebElement disableField;




    public WebFormPage(WebDriver driver) {
        super(driver);
    }


    @Step("get web-form url")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("submit form")
    public void submitForm() {
        Actions actions;
        actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }

    @Step("send text")
    public void sendText() {
        String text = "my text";
        sendTextInput.sendKeys(text);
    }

    @Step("get text input")
    public String getTextInput() {
        return sendTextInput.getDomProperty("value");
    }

    @Step("send text to disabled field")
    public void sendToDisableInput(String textForDisabledInput) {
        disableField.sendKeys(textForDisabledInput);
    }

    @Step("get text from disabled field")
    public WebElement getDisableInput() {
        return disableField;
    }


    @Step("select option from dropdown")
    public String chooseOptionFromDropDownSelect(String valueNumber) {
        Select select = new Select(selectOptions);
        select.selectByValue(valueNumber);
        return select.getFirstSelectedOption().getText();
    }

    @Step("checking whether first option is selected from dropdown")
    public boolean isFirstOptionSelected(String valueNumber) {
        Select select = new Select(selectOptions);
        select.selectByValue(valueNumber);
        return select.getFirstSelectedOption().isSelected();
    }
}
