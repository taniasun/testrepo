package test.java.pageobjects.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.java.pageobjects.BasePage;

public class ViewIssueForm extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'show_issue')]")
    private WebElement holder;

    public ViewIssueForm(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementDisplayed(holder);
    }
}
