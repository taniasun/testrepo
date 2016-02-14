package test.java.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Issue;
import test.java.core.Log;
import test.java.pageobjects.forms.NewIssueForm;

public class GitHubIssuesPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo/issues";

    @FindBy(xpath = "//nav//a[contains(@href, 'issues')]")
    private WebElement tabIssues;

    @FindBy(xpath = "//li[contains(@id, 'issue')]")
    private List<WebElement> liIssues;

    @FindBy(xpath = "//a[contains(@href, 'new') and contains(@class, 'btn')]")
    private WebElement btnNewIssue;

    public GitHubIssuesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementSelected(tabIssues);
    }

    public List<Issue> getIssues() {
        return null;
    }

    public int getIssuesCount() {
        Log.info("Get issues count: " + liIssues.size());
        return liIssues.size();
    }

    public NewIssueForm clickButtonNewIssue() {
        btnNewIssue.click();
        return PageFactory.initElements(getDriver(), NewIssueForm.class);
    }
}
