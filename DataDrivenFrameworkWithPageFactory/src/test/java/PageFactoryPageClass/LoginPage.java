package PageFactoryPageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // This line initializes the elements
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        txtUsername.sendKeys(user);
        txtPassword.sendKeys(pass);
        btnLogin.click();
    }
}
