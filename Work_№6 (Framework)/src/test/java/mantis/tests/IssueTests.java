package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssueTests extends BaseTestForIssue {

    private SoftAssertions softAssert = new SoftAssertions();
    @Test
    public void addAndDeleteIssueTest() {
        MantisSite mantisSite = new MantisSite(driver);
        ReportIssuePage reportIssuePage = new ReportIssuePage(driver); //
/*        mantisSite.login("admin", "admin20");*/
        mantisSite.getMainPage().goToReportIssuesPage();
        reportIssuePage.reportIssue(); //
        mantisSite.getMainPage().goToViewIssuesPage();

        String issueId = mantisSite.getViewIssuesPage().getLastIssueId();

        mantisSite.getViewIssuesPage().openDetailsLastIssue();

        softAssert.assertThat(issueId).
                isEqualTo(mantisSite.getIssueDetailsPage().getLastIssueIdFromDetails());
        softAssert.assertThat(mantisSite.getIssueDetailsPage().getLastIssueDescriptionFromDetails()).
                isEqualTo(reportIssuePage.descriptionText);
        softAssert.assertThat(mantisSite.getIssueDetailsPage().getLastIssueSummaryFromDetails()).
                isEqualTo(issueId + ": " + reportIssuePage.summaryText);

        mantisSite.getIssueDetailsPage().deleteLastIssue();
        mantisSite.getMainPage().goToViewIssuesPage();

        softAssert.assertThat(mantisSite.getViewIssuesPage().getLastIssueId()).
                isNotEqualTo(issueId);
        softAssert.assertAll();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/view_all_bug_page.php", currentUrl);
    }
}
