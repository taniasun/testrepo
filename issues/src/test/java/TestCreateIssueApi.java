package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.java.core.ApiService;
import test.java.core.Configuration;
import test.java.core.Issue;
import test.java.pageobjects.GitHubIssuesPage;
import test.java.pageobjects.GitHubRepositoryPage;

import com.mashape.unirest.http.exceptions.UnirestException;

public class TestCreateIssueApi {

    @Test
    public void testCreateIssueApi() throws UnirestException {
        final Issue issue = Issue.getIssue();

        final List<Issue> issuesBefore = ApiService.getIssues();
        final int status = ApiService.createIssue(issue);
        assertThat(status).as("Response status is correct").isEqualTo(HttpStatus.SC_CREATED);

        final List<Issue> issuesAfter = ApiService.getIssues();
        final int expectedSize = issuesBefore.size() + 1;
        assertThat(issuesAfter.size()).as("Issues after is greater that issue before").isEqualTo(expectedSize);

        // openPage - move to separate test?
        final WebDriver driver = Configuration.getChromeDriver();
        final GitHubRepositoryPage mainPage = PageFactory.initElements(driver, GitHubRepositoryPage.class);
        final GitHubIssuesPage issuesPage = mainPage.clickTabIssues();
        // final List<Issue> issuesFromUi = issuesPage.getIssues();
        assertThat(issuesPage.getIssuesCount()).as("Issues count on UI is corect").isEqualTo(expectedSize);
    }
}
