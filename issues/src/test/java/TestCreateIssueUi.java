package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Configuration;
import test.java.core.Issue;
import test.java.pageobjects.GitHubIssuesPage;
import test.java.pageobjects.GitHubRepositoryPage;
import test.java.pageobjects.forms.NewIssueForm;

public class TestCreateIssueUi {
    private static WebDriver driver;
    private final Issue issue = Issue.getIssue();

    @BeforeClass
    public static void setUp() {
        driver = Configuration.getChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreateIssueUi() {
        final GitHubRepositoryPage mainPage = PageFactory.initElements(driver, GitHubRepositoryPage.class);

        GitHubIssuesPage issuesPage = mainPage.clickTabIssues();
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();

        final int issuesCountBefore = issuesPage.getIssuesCount();
        final int issuesCountExpected = issuesCountBefore + 1;

        final NewIssueForm newIssueForm = issuesPage.clickButtonNewIssue();
        assertThat(newIssueForm.isOpened()).as("New Issue form is opened").isTrue();
        newIssueForm.enterTitle(issue.getTitle());
        newIssueForm.enterBody(issue.getBody());
        issuesPage = newIssueForm.clickButtonSubmit();
        assertThat(issuesPage.isOpened()).as("Issues page is opened afetr submit").isTrue();

        // final List<Issue> issuesFromUi = issuesPage.getIssues();
        final int issuesCountAfter = issuesPage.getIssuesCount();
        assertThat(issuesCountAfter).as("Issues count on UI is corect").isEqualTo(issuesCountExpected);
    }
}
