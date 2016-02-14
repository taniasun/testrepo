package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Configuration;
import test.java.entities.Issue;
import test.java.entities.User;
import test.java.pageobjects.IssuesPage;
import test.java.pageobjects.RepositoryPage;
import test.java.pageobjects.forms.AuthorizationForm;
import test.java.pageobjects.forms.NewIssueForm;
import test.java.pageobjects.forms.ViewIssueForm;

public class TestCreateIssueUi {
    private static WebDriver driver;
    private final Issue issue = Issue.getIssue();
    private final User user = User.getUser();

    @BeforeClass
    public static void setUp() {
        driver = Configuration.getChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    // better to add steps ...

    @Test
    public void testCreateIssueUi() {
        final RepositoryPage mainPage = PageFactory.initElements(driver, RepositoryPage.class);

        IssuesPage issuesPage = mainPage.clickTabIssues();
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();

        final int issuesCountBefore = issuesPage.getIssuesCount();
        final int issuesCountExpected = issuesCountBefore + 1;

        final AuthorizationForm authForm = issuesPage.clickButtonNewIssue(AuthorizationForm.class);
        final NewIssueForm newIssueForm = authForm.login(user, NewIssueForm.class);

        assertThat(newIssueForm.isOpened()).as("New Issue form is opened").isTrue();
        newIssueForm.enterTitle(issue.getTitle());
        newIssueForm.enterBody(issue.getBody());
        final ViewIssueForm viewIssueForm = newIssueForm.clickButtonSubmit();
        assertThat(viewIssueForm.isOpened()).as("View issue form is opened afetr submit").isTrue();

        issuesPage = viewIssueForm.clickTabIssues();
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();

        final int issuesCountAfter = issuesPage.getIssuesCount();
        assertThat(issuesCountAfter).as("Issues count on UI is corect").isEqualTo(issuesCountExpected);
    }
}
