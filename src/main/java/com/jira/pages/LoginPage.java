package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testframework.core.BaseWebPage;

public class LoginPage extends BaseWebPage {

    @Override
    public String getBasePageUrl() {
        return "https://id.atlassian.com/login";
    }

    private final By usernameField = By.xpath("//*[@id=\"username\"]");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-submit");

    public LoginPage(WebDriver driver) {
        super("/login");
    }

    public void login(String username, String password) {
        driver().findElement(usernameField).sendKeys(username);
        driver().findElement(passwordField).sendKeys(password);
        driver().findElement(loginButton).click();
    }
}
