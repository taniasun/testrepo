package test.java.pageobjects;

import org.openqa.selenium.WebDriver;

public class RepositoryPage extends BasePage {

    public static final String URL = "https://github.com/taniasun/testrepo";

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return super.isTabCodeSelected();
    }
}
