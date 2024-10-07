package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testframework.core.BaseWebPage;

public class CreateStoryPage extends BaseWebPage {

    private final By summaryField = By.id("summary");
    private final By priorityDropdown = By.id("priority-field");
    private final By createButton = By.id("create-issue-submit");

    public CreateStoryPage(WebDriver driver) {
        super(driver, "/secure/CreateIssue!default.jspa");
    }

    @Override
    public String getBasePageUrl() {
        return "https://id.atlassian.com/login";
    }

    public void enterSummary(String summary) {
        driver.findElement(summaryField).sendKeys(summary);
    }

    public void selectPriority(String priority) {
        driver.findElement(priorityDropdown).sendKeys(priority);
    }

    public void clickCreateButton() {
        driver.findElement(createButton).click();
    }

}
