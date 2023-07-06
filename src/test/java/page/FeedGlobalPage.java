package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedGlobalPage {

    public static final String EDIT_POSTS_LINK = "//aside[contains(@class,'column')]//a[contains(@href,'mydata')]";
    public DashboardPage clickEditPostLink() {
        $(By.xpath(EDIT_POSTS_LINK)).click();
        return new DashboardPage();
    }

}
