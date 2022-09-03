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
    private WebElement myIssueIdFromDetails;

    @FindBy(css = "tr:nth-child(11) > td")
    private WebElement myIssueDescriptionFromDetails;

    @FindBy(css = "tr:nth-child(10) > td")
    private WebElement myIssueSummaryFromDetails;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteMyIssueFromDetails;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement confirmationOfDeleteMyIssue;

    public IssueDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getMyIssueIdFromDetails() {
        return myIssueIdFromDetails.getText();
    }

    public String getMyIssueDescriptionFromDetails() {
        return myIssueDescriptionFromDetails.getText();
    }

    public String getmyIssueSummaryFromDetails() {
        return myIssueSummaryFromDetails.getText();
    }

    public void deleteMyIssueFromDetails() {
        deleteMyIssueFromDetails.click();
    }

    public void deleteMyIssue() {
        deleteMyIssueFromDetails.click();
        confirmationOfDeleteMyIssue.click();
    }
}
