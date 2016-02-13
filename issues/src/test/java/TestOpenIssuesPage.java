package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Configuration;
import test.java.pageobjects.GitHubIssuesPage;
import test.java.pageobjects.GitHubRepositoryPage;

public class TestOpenIssuesPage {
    private static WebDriver driver = Configuration.getChromeDriver();
    private static GitHubRepositoryPage mainPage;

    @BeforeClass
    public static void setUp() {
        mainPage = PageFactory.initElements(driver, GitHubRepositoryPage.class);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenIssueTabByLink() {
        final GitHubIssuesPage issuesPage = mainPage.openPageByLink(GitHubIssuesPage.class, GitHubIssuesPage.URL);
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();
    }

    @Test
    public void testOpenIssueTabByClickOnTab() {
        assertThat(mainPage.isOpened()).as("Repository page is opened").isTrue();

        final GitHubIssuesPage issuesPage = mainPage.clickTabIssues();
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();
    }
}
