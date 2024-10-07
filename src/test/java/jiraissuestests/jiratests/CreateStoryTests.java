package jiraissuestests.jiratests;

import com.jira.pages.CreateStoryPage;
import com.jira.pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testframework.core.BaseWebPage;
import testframework.core.BaseWebTest;

public class CreateStoryTests extends BaseWebTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CreateStoryPage createStoryPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage();
        createStoryPage = new CreateStoryPage(driver);
    }

    @Test
    public void testCreateStory() {
        // Navigate to JIRA login page and log in
        driver.get("https://your-jira-instance-url.com");
        loginPage.login("your-username", "your-password");

        // Create a new story
        dashboardPage.clickCreateButton();
        createStoryPage.enterSummary("New Story for Testing");
        createStoryPage.selectPriority("High");
        createStoryPage.clickCreateButton();

        // Validate story creation by checking the issue key
        String createdIssueKey = dashboardPage.getCreatedIssueKey();
        Assert.assertNotNull("The story was not created successfully.", createdIssueKey);
        System.out.println("Story created successfully with issue key: " + createdIssueKey);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
