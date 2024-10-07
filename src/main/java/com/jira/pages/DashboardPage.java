package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testframework.core.BaseWebPage;

public class DashboardPage extends BaseWebPage {
    public DashboardPage(WebDriver driver) {
        super(driver, "");
    }

    @Override
    public String getBasePageUrl() {
        return "https://your-jira-instance-url.com";
    }

    public void clickCreateButton() {
        driver.findElement(By.id("createGlobalItem")).click();
    }
}
