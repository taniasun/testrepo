package test.java.core;

public class Issue {

    private String id;
    private String title;
    private String body;

    public Issue setId(String id) {
        this.id = id;
        return this;
    }

    public Issue setTitle(String title) {
        this.title = title;
        return this;
    }

    public Issue setBody(String body) {
        this.body = body;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public static Issue getIssue() {
        return new Issue().setTitle("test title").setBody("body");
    }

}
