package test.java.core;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiService {
    private static final String username = "taniasun";
    private static final String endpoint = "https://api.github.com";

    public static int createIssue(Issue issue) throws UnirestException {
        final String auth = getAuthToken();

        final String json = " { \"title\": \"Found a bug\","
                + " \"body\": \"I'm having a problem with this.\","
                + " \"assignee\": \"" + username + "\"}";

        final HttpResponse<JsonNode> jsonResponse = Unirest.post(endpoint + "/repos/taniasun/testrepo/issues")
                .header("accept", "application/json")
                .header("Authorization ", "Basic " + auth)
                .body(json)
                .asJson();

        jsonResponse.getBody();
        final int status = jsonResponse.getStatus();
        return status;
    }

    public static List<Issue> getIssues() throws UnirestException {
        final String auth = getAuthToken();

        final HttpResponse<String> asString = Unirest.get(endpoint + "/repos/taniasun/testrepo/issues")
                .header("Authorization ", "Basic " + auth)
                .asString();

        asString.getBody();
        asString.getStatus();

        final Issue[] issue = new Gson().fromJson(asString.getBody(), Issue[].class);

        final List<Issue> list = Arrays.asList(issue);

        return list;
    }

    private static String getAuthToken() {
        final Properties prop = new Properties();
        InputStream is;
        try {
            is = new FileInputStream("config.properties");
            prop.load(is);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        final String token = prop.getProperty("personal.token");
        final String auth = String.format("%s:%s", username, token);
        final String string = Base64.getUrlEncoder().encodeToString(auth.getBytes());
        return string;
    }
}
