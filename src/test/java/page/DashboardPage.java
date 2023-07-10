package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    public static final String DASHBOARD_URL ="https://www.moodpanda.com/dashboard/";
    private static final String RATING_SELECTS = "//td//select";
    private static final String UPDATE_BUTTONS = "//button[contains(@class, 'is-outdlined')]";
    private static final String SUCCESS_MESSAGE = "//*[contains(text(), 'Post updated')]";
    private static final String HUG_BUTTONS = "//a[text() = 'Hug']";
    private static final String HUG_SENT_MESSAGE = "//div[contains(text(), 'Your hug was sent to')]";
    private static final String REPLY_BUTTONS = "//a[contains(text(), 'Reply')]";
    private static final String COMMENT_POSTED_MESSAGE = "//div[contains(text(), 'Your comment was posted')]";
    private static final String REPLY_TEXT_FIELD = "//textarea";
    private static final String SEND_REPLY_BUTTON = "//button[contains(text(), 'Send reply')]";

    public DashboardPage openPage() {
        open(DASHBOARD_URL);
        return new DashboardPage();
    }
    public String getRatingSelects() {
        return RATING_SELECTS;
    }

    public DashboardPage clickHugButton(int postPosition) {
        $$(By.xpath(HUG_BUTTONS)).get(postPosition).click();
        return this;
    }
    public DashboardPage clickReplyButton(int postPosition) {
        $$(By.xpath(REPLY_BUTTONS)).get(postPosition).click();
        return this;
    }
    public DashboardPage clickSendReplyButton() {
        $(By.xpath(SEND_REPLY_BUTTON)).click();
        return this;
    }
    public DashboardPage enterReplyMessage(String message) {
        $(By.xpath(REPLY_TEXT_FIELD)).sendKeys(message);
        return this;
    }
    public DashboardPage clickUpdateButton(int ratingPosition) {
        $$(By.xpath(UPDATE_BUTTONS)).get(ratingPosition).click();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return $(By.xpath(SUCCESS_MESSAGE)).should(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
    public boolean isHugSentMessageDisplayed() {
        return $(By.xpath(HUG_SENT_MESSAGE)).should(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
    public boolean isCommentPostedMessageDisplayed() {
        return $(By.xpath(COMMENT_POSTED_MESSAGE)).should(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
