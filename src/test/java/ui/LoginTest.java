package ui;

import bednarek.pageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
