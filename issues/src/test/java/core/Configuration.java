package test.java.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.java.pageobjects.GitHubRepositoryPage;

public class Configuration {

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
        driver.navigate().to(GitHubRepositoryPage.URL);
        return driver;
    }
}
