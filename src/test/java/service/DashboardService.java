package service;

import org.openqa.selenium.By;
import page.DashboardPage;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardService {
    private DashboardPage dashboardPage = new DashboardPage();

    public DashboardService setupRating(int ratingPosition, String rating) {
        $$(By.xpath(dashboardPage.getRatingSelects())).get(ratingPosition).selectOptionByValue(rating);
        return this;
    }

    public DashboardService clickUpdateButton(int ratingPosition) {
        dashboardPage.clickUpdateButton(ratingPosition);
        return this;
    }

    public DashboardService clickHugButton(int hugPosition) {
        dashboardPage
                .openPage()
                .clickHugButton(hugPosition);
        return this;
    }
    public DashboardService replyToPost(int postPosition, String message) {
        dashboardPage
                .openPage()
                .clickReplyButton(postPosition)
                .enterReplyMessage(message)
                .clickSendReplyButton();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return dashboardPage.isSuccessMessageDisplayed();
    }
    public boolean isHugSentMessageDisplayed() {
        return dashboardPage.isHugSentMessageDisplayed();
    }
    public boolean isCommentPostedMessageDisplayed() {
        return dashboardPage.isCommentPostedMessageDisplayed();
    }

}
