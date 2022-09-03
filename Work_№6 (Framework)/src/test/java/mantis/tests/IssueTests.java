package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssueTests extends BaseTest {

    private SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void LoginUrlTest() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/login_page.php", currentUrl);
    }

    @Test
    public void addAndDeleteIssueTest() {
        MantisSite mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        mantisSite.reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();

        String issueId = mantisSite.getViewIssuesPage().getMyIssueId();

        mantisSite.getViewIssuesPage().openDetailsMyIssue();

        softAssert.assertThat(issueId).
                isEqualTo(mantisSite.getIssueDetailsPage().getMyIssueIdFromDetails());
        softAssert.assertThat(mantisSite.getIssueDetailsPage().getMyIssueDescriptionFromDetails()).
                isEqualTo(mantisSite.getReportIssuePage().descriptionText);
        softAssert.assertThat(mantisSite.getIssueDetailsPage().getmyIssueSummaryFromDetails()).
                isEqualTo(issueId + ": " + mantisSite.getReportIssuePage().summaryText);
        softAssert.assertAll();

        mantisSite.getIssueDetailsPage().deleteMyIssue();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/view_all_bug_page.php", currentUrl);
    }
}
