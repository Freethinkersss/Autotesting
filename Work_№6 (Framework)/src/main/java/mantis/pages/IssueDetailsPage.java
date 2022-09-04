package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueDetailsPage {
    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(css = "td.bug-id")
    private WebElement lastIssueIdFromDetails;

    @FindBy(css = "tr:nth-child(11) > td")
    private WebElement lastIssueDescriptionFromDetails;

    @FindBy(css = "tr:nth-child(10) > td")
    private WebElement lastIssueSummaryFromDetails;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteLastIssueFromDetails;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement confirmationOfDeleteLastIssue;

    public IssueDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getLastIssueIdFromDetails() {
        return lastIssueIdFromDetails.getText();
    }

    public String getLastIssueDescriptionFromDetails() {
        return lastIssueDescriptionFromDetails.getText();
    }

    public String getLastIssueSummaryFromDetails() {
        return lastIssueSummaryFromDetails.getText();
    }

    public void deleteLastIssueFromDetails() {
        deleteLastIssueFromDetails.click();
    }

    public void deleteLastIssue() {
        deleteLastIssueFromDetails.click();
        confirmationOfDeleteLastIssue.click();
    }
}
