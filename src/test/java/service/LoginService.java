package service;

import model.User;
import page.LoginPage;

public class LoginService {
    private LoginPage loginPage = new LoginPage();

    public FeedGlobalService login(User user) {
        loginPage.openLoginPage()
                .enterEmail(user.getUserEmail())
                .enterPassword(user.getUserPassword())
                .clickLoginButton();
        return new FeedGlobalService();
    }
}
