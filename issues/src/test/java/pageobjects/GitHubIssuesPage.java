package test.java.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubIssuesPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo/issues";

    @FindBy(xpath = "//nav//a[contains(@href, 'issues')]")
    private WebElement tabIssues;

    public GitHubIssuesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementSelected(tabIssues);
    }
}
