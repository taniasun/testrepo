package test.java.pageobjects;

import org.openqa.selenium.WebDriver;

public class GitHubRepositoryPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo";

    public GitHubRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return super.isTabCodeSelected();
    }
}
