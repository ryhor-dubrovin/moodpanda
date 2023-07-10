package service;

import page.FeedGlobalPage;

public class FeedGlobalService {
    private FeedGlobalPage feedGlobalPage = new FeedGlobalPage();

    public DashboardService clickEditPostLink() {
        feedGlobalPage.clickEditPostLink();
        return new DashboardService();
    }
}
