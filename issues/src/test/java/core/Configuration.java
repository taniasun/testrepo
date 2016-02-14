package test.java.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.java.pageobjects.GitHubRepositoryPage;

public class Configuration {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(GitHubRepositoryPage.URL);
        return driver;
    }
}
