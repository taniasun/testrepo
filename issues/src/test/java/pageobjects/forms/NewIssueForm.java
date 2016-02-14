package test.java.pageobjects.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.pageobjects.BasePage;
import test.java.pageobjects.GitHubIssuesPage;

public class NewIssueForm extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'new-issue')]")
    private WebElement holder;

    @FindBy(xpath = "//input[contains(@id, 'title')]")
    private WebElement txtTitle;

    @FindBy(xpath = "//textarea[contains(@id, 'body')]")
    private WebElement txtBody;

    @FindBy(xpath = "//div[@class='form-actions']//button[@type='submit']")
    private WebElement btnSubmit;

    protected NewIssueForm(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementDisplayed(holder);
    }

    public void enterTitle(String title) {
        txtTitle.clear();
        txtTitle.sendKeys(title);
    }

    public void enterBody(String body) {
        txtBody.clear();
        txtBody.sendKeys(body);
    }

    public GitHubIssuesPage clickButtonSubmit() {
        btnSubmit.click();
        waitForElelemtDisappear(btnSubmit);
        return PageFactory.initElements(getDriver(), GitHubIssuesPage.class);
    }

}
