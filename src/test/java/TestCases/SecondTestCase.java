package TestCases;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

        mainPage.page();

        mainPage.mainPageUniqueElement();

        mainPage.topSellers();

        topSellersPage.topSellersPageUniqueElement();

        topSellersPage.showMoreSellers();

        topSellersPage.checkboxOS();

        topSellersPage.checkboxAction();

        topSellersPage.checkboxLanCoop();


        int numAfterRequest = topSellersPage.countOfGamesAfterRequest();
        int numInList = topSellersPage.countOfGamesInList();
        Assert.assertEquals(message, numInList, numAfterRequest);

        String firstNameGame = topSellersPage.nameGame();
        String firstDateGame = topSellersPage.dateName();
        String firstCostGame = topSellersPage.costGame();

        topSellersPage.clickTopFirstGame();

        gamePage.gamePageUniqueElement();

        String secondNameGame = gamePage.nameGame();
        String secondDateGame = gamePage.dateGame();
        String secondCostGame = gamePage.costGame();

        Assert.assertEquals(message, firstNameGame, secondNameGame);
        Assert.assertEquals(message, firstDateGame, secondDateGame);
        Assert.assertEquals(message, firstCostGame, secondCostGame);
    }

}
