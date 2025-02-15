package TestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import properties.BaseConfigData;
import properties.Singleton;
import ru.pages.GamePage;
import ru.pages.MainPage;
import ru.pages.TopSellersPage;

public class SecondTestCase extends BaseConfigData {

    private MainPage mainPage;
    private TopSellersPage topSellersPage;
    private GamePage gamePage;

    @Before
    public void set() {
        driver = Singleton.getInstance().getDriver();
        mainPage = new MainPage(driver);
        topSellersPage = new TopSellersPage(driver);
        gamePage = new GamePage(driver);
    }

    @Test
    public void test(){

        String message = "Values aren`t equals";
        String pageMessage = "Page was not achieved";

        mainPage.page().click();
        Assert.assertTrue(pageMessage, mainPage.page().isDisplayed());

        mainPage.mainPageUniqueElement();

        mainPage.topSellers();
        Assert.assertTrue(pageMessage, driver.getCurrentUrl().contains("/topselling/"));

        topSellersPage.topSellersPageUniqueElement();

        topSellersPage.showMoreSellers();
        Assert.assertTrue(pageMessage, driver.getCurrentUrl().contains("=topsellers"));

        topSellersPage.checkboxOS();
        WebElement checkOS = driver.findElement(By.xpath(topSellersPage.selectorOS()));
        String os = checkOS.getAttribute("class");
        Assert.assertTrue("Checkbox 'SteamOS + Linux' was not selected", os.contains("checked"));

        topSellersPage.checkboxAction();
        WebElement checkTag = driver.findElement(By.xpath(topSellersPage.selectorTag()));
        String action = checkTag.getAttribute("class");
        Assert.assertTrue("Checkbox 'Action' was not selected", action.contains("checked"));

        topSellersPage.checkboxLanCoop();
        WebElement checkNumber = driver.findElement(By.xpath(topSellersPage.selectorNumberOfPlayers()));
        String lan = checkNumber.getAttribute("class");
        Assert.assertTrue("Checkbox 'LAN Co-op' was not selected", lan.contains("checked"));


        int numAfterRequest = topSellersPage.countOfGamesAfterRequest();
        int numInList = topSellersPage.countOfGamesInList();
        Assert.assertEquals(message, numInList, numAfterRequest);

        String firstNameGame = topSellersPage.nameGame();
        String firstDateGame = topSellersPage.dateName();
        String firstCostGame = topSellersPage.costGame();

        topSellersPage.clickTopFirstGame();
        Assert.assertTrue(pageMessage, driver.getCurrentUrl().contains("/app"));

        gamePage.gamePageUniqueElement();

        String secondNameGame = gamePage.nameGame();
        String secondDateGame = gamePage.dateGame();
        String secondCostGame = gamePage.costGame();

        Assert.assertEquals(message, firstNameGame, secondNameGame);
        Assert.assertEquals(message, firstDateGame, secondDateGame);
        Assert.assertEquals(message, firstCostGame, secondCostGame);
    }

}
