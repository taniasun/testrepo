package test.java.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Issue;
import test.java.core.Log;

public class GitHubIssuesPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo/issues";

    @FindBy(xpath = "//li[contains(@id, 'issue')]")
    private List<WebElement> liIssues;

    @FindBy(xpath = "//a[contains(@href, 'new') and contains(@class, 'btn')]")
    private WebElement btnNewIssue;

    public GitHubIssuesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementDisplayed(btnNewIssue);
    }

    public List<Issue> getIssues() {
        return null;
    }

    public int getIssuesCount() {
        Log.info("Get issues count: " + liIssues.size());
        return liIssues.size();
    }

    public <T extends BasePage> T clickButtonNewIssue(Class<T> clazz) {
        btnNewIssue.click();
        return PageFactory.initElements(getDriver(), clazz);
    }
}
