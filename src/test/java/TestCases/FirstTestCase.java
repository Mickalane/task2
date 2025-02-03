package TestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import properties.BaseConfigData;
import properties.Singleton;
import ru.pages.AboutPage;
import ru.pages.MainPage;

public class FirstTestCase extends BaseConfigData {
    private AboutPage aboutPage;
    private MainPage mainPage;

    @Before
    public void set() {
        driver = Singleton.getInstance().getDriver();
        driver.get("https://store.steampowered.com/");
        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
    }

    @Test
    public void test() {
        mainPage.page();

        mainPage.mainPageUniqueElement();

        mainPage.clickAbout();

        aboutPage.aboutPageUniqueElement();

        int onlineNum = aboutPage.onlineNum();
        int playingNowNum = aboutPage.playingNowNum();
        Assert.assertTrue("Online players aren`t greater than gamers that playing now",onlineNum > playingNowNum);

        mainPage.clickStore();
    }
}
