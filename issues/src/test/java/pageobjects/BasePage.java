package test.java.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

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
            // Log.info(e.getMassage());
        }
        return false;
    }

    public <T extends BasePage> T openPageByLink(Class<T> clazz, String url) {
        driver.navigate().to(url);
        return PageFactory.initElements(driver, clazz);
    }
}
