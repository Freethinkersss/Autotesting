package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public String summaryText = "SummaryText 333";
    public String descriptionText = "DescriptionText 333";

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(css = "[value='Submit Issue']")
    private WebElement issueCreationButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void reportIssue() {
        summaryField.sendKeys(summaryText);
        descriptionField.sendKeys(descriptionText);
        issueCreationButton.click();
    }
}
