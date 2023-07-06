package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;

public class MoodPandaTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
    }

    @Test
    public void moodTest() {
        User user = new User("mogal95@gmail.com","13101995Gg");
        final String RATING = "1";
        final int RATING_POSITION = 0;
        dashboardPage = loginPage.openLoginPage()
                .login(user)
                .clickEditPostLink()
                .setupRating(RATING_POSITION, RATING)
                .clickUpdateButton(RATING_POSITION);
        Assert.assertTrue(dashboardPage.isSuccessMessageDisplayed(), "");
    }
}
