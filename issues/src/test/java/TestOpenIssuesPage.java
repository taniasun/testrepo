package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Configuration;
import test.java.pageobjects.IssuesPage;
import test.java.pageobjects.RepositoryPage;

public class TestOpenIssuesPage {
    private static WebDriver driver;
    private static RepositoryPage mainPage;

    @BeforeClass
    public static void setUp() {
        driver = Configuration.getChromeDriver();
        mainPage = PageFactory.initElements(driver, RepositoryPage.class);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenIssueTabByLink() {
        final IssuesPage issuesPage = mainPage.openPageByLink(IssuesPage.class, IssuesPage.URL);
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();
    }

    @Test
    public void testOpenIssueTabByClickOnTab() {
        assertThat(mainPage.isOpened()).as("Repository page is opened").isTrue();

        final IssuesPage issuesPage = mainPage.clickTabIssues();
        assertThat(issuesPage.isOpened()).as("Issues page is opened").isTrue();
    }
}
