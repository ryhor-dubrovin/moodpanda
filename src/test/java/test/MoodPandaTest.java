package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.DashboardService;
import service.LoginService;

public class MoodPandaTest extends BaseTest {
    private LoginService loginService;
    private DashboardService dashboardService;

    @BeforeClass
    public void setup() {
        loginService = new LoginService();
    }

    @Test
    public void updatePostTest() {
        User user = new User("mogal95@gmail.com", "AQA20onl");
        final String RATING = "1";
        final int RATING_POSITION = 0;
        dashboardService = loginService
                .login(user)
                .clickEditPostLink()
                .setupRating(RATING_POSITION, RATING)
                .clickUpdateButton(RATING_POSITION);
        Assert.assertTrue(dashboardService.isSuccessMessageDisplayed(), "Post is not updated!");
    }
    @Test(dependsOnMethods = "updatePostTest")
    public void sentHugTest() {
        final int HUG_POSITION = 0;
        boolean isHugSent = dashboardService
                .clickHugButton(HUG_POSITION)
                .isHugSentMessageDisplayed();
        Assert.assertTrue(isHugSent, "Hug is not sent!");
    }
    @Test(dependsOnMethods = "updatePostTest")
    public void replyToPostTest() {
        final int POST_POSITION = 0;
        final String REPLY_MESSAGE = "This is message =)";
        boolean isReplyPosted = dashboardService
                .replyToPost(POST_POSITION, REPLY_MESSAGE)
                .isCommentPostedMessageDisplayed();
        Assert.assertTrue(isReplyPosted , "Reply is not posted!");
    }
}
