package test.java.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.core.Log;

public abstract class BasePage {

    @FindBy(xpath = "//nav//a[contains(@aria-label, 'Issues')]")
    private WebElement tabIssues;

    @FindBy(xpath = "//nav//a[contains(@aria-label, 'Code')]")
    private WebElement tabCode;

    private final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected boolean isElementSelected(WebElement element) {
        try {
            final String attribute = element.getAttribute("aria-selected");
            return attribute.contains("true");
        } catch (final Exception e) {
            e.printStackTrace();
            Log.info(e.getMessage());
        }
        return false;
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (final Exception e) {
            Log.info(e.getMessage());
        }
        return false;
    }

    public <T extends BasePage> T openPageByLink(Class<T> clazz, String url) {
        driver.navigate().to(url);
        return PageFactory.initElements(driver, clazz);
    }

    public void waitForElelemtDisappear(WebElement element) {
        waitForElementDisappear(element, 5000);
    }

    public void waitForElementDisappear(WebElement element, int ms) {
        for (int i = 0; i < ms; ++i) {
            if (!isElementDisplayed(element)) {
                // wait 1ms ..
                Log.info(String.format("Element is disappeared after %s ms", i));
                return;
            }
        }
        Log.info(String.format("Element is not disappeared after %s ms", ms));
    }

    public IssuesPage clickTabIssues() {
        tabIssues.click();
        return PageFactory.initElements(getDriver(), IssuesPage.class);
    }

    public boolean isTabCodeSelected() {
        return isElementSelected(tabCode);
    }
}
