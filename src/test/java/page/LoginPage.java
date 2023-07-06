package page;

import model.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String LOGIN_URL = "https://www.moodpanda.com/login";
    private static final String EMAIL_INPUT = "//input[@placeholder='MoodPanda registered email ']";
    private static final String PASSWORD_INPUT = "//input[@name='password']";
    private static final String LOGIN_BUTTON = "//button[contains(@class,'button')]";

    public LoginPage openLoginPage() {
        open(LOGIN_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        $(By.xpath(LOGIN_BUTTON)).click();
        return this;
    }

    //move to service

    public FeedGlobalPage login(User user) {
        enterEmail(user.getUserEmail())
                .enterPassword(user.getUserPassword())
                .clickLoginButton();
        return new FeedGlobalPage();
    }
}
