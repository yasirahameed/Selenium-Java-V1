package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Define locators using @FindBy annotation
    @FindBy(name = "uid")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    // Constructor to initialize the elements
    public LoginPage(WebDriver driver) {     
        PageFactory.initElements(driver, this);
    }

    // Method to login
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
