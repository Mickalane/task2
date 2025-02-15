package TestCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
    }

    @Test
    public void test() {
        String pageMessage = "Page was not open";

        Assert.assertTrue(pageMessage, mainPage.page().isDisplayed());

        mainPage.mainPageUniqueElement();



        mainPage.clickAbout();
        Assert.assertTrue(pageMessage, driver.getCurrentUrl().contains("/about/"));

        aboutPage.aboutPageUniqueElement();

        int onlineNum = aboutPage.onlineNum();
        int playingNowNum = aboutPage.playingNowNum();
        Assert.assertTrue("Online players aren`t greater than gamers that playing now",onlineNum > playingNowNum);

        mainPage.clickStore();
        Assert.assertTrue(pageMessage, driver.getCurrentUrl().contains("/store"));
    }
}
