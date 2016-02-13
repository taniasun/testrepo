package test.java.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubRepositoryPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo";

    @FindBy(xpath = "//nav//a[contains(@aria-label, 'Issues')]")
    private WebElement tabIssues;

    @FindBy(xpath = "//nav//a[contains(@aria-label, 'Code')]")
    private WebElement tabCode;

    public GitHubRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementSelected(tabCode);
    }

    public GitHubIssuesPage clickTabIssues() {
        tabIssues.click();
        return PageFactory.initElements(getDriver(), GitHubIssuesPage.class);
    }
}
