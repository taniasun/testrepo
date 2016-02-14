package test.java.pageobjects.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.entities.User;
import test.java.pageobjects.BasePage;

public class AuthorizationForm extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[contains(@id, 'login')]")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[contains(@type, 'submit')]")
    private WebElement btnSignIn;

    public AuthorizationForm(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public <T extends BasePage> T clickButtonSignIn(Class<T> clazz) {
        btnSignIn.click();
        return PageFactory.initElements(getDriver(), clazz);
    }

    public <T extends BasePage> T login(User user, Class<T> clazz) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        return clickButtonSignIn(clazz);
    }
}
