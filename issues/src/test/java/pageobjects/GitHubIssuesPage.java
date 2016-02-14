package test.java.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.java.core.Issue;

public class GitHubIssuesPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo/issues";

    @FindBy(xpath = "//nav//a[contains(@href, 'issues')]")
    private WebElement tabIssues;

    @FindBy(xpath = "//li[contains(@id, 'issue')]")
    private List<WebElement> liIssues;

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
        return liIssues.size();
    }
}
