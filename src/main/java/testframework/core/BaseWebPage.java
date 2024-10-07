package testframework.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframework.Driver;
import testframework.DriverManager;
import testframework.PropertiesManager;
import testframework.enums.FrameworkSettings;

public abstract class BaseWebPage {

    protected WebDriver driver;
    private final String pageUrl;

    // Url
    public abstract String getBasePageUrl();

    public BaseWebPage(WebDriver driver, String pageSpecificUrl) {
        this.driver = driver;
        this.pageUrl = pageSpecificUrl;
    }

    protected WebDriver driver() {
        return driver;
    }

    protected WebDriverWait driverWait() {
        return new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public String getPageUrl() {
        return getBasePageUrl() + pageUrl;
    }

    // Actions
    public void navigate() {
        driver.get(getPageUrl());
    }

    public void assertNavigated() {
        if (!driver.getCurrentUrl().equals(getPageUrl())) {
            throw new AssertionError("Page was not navigated.");
        }
    }
}