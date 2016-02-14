package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Test;

import test.java.core.ApiService;
import test.java.entities.Issue;

import com.mashape.unirest.http.exceptions.UnirestException;

public class TestCreateIssueApi {

    @Test
    public void testCreateIssueApi() throws UnirestException {
        final Issue issue = Issue.getIssue();

        final List<Issue> issuesBefore = ApiService.getIssues();
        final int expectedSize = issuesBefore.size() + 1;

        final int status = ApiService.createIssue(issue);
        assertThat(status).as("Response status is correct").isEqualTo(HttpStatus.SC_CREATED);

        final List<Issue> issuesAfter = ApiService.getIssues();
        assertThat(issuesAfter.size()).as("Issues after is greater that issue before").isEqualTo(expectedSize);
    }
}
