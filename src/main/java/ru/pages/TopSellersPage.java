package ru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.properties.ConfigProvider;

import java.time.Duration;
import java.util.List;

public class TopSellersPage {

    private final WebDriver driver;

    public TopSellersPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    public void topSellersPageUniqueElement(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='page_content_ctn']/descendant::h1")));
    }

    public void showMoreSellers(){
        String show = "//*[@class='DialogButton _DialogLayout Primary Focusable']";
        driver.findElement(By.xpath(show)).click();
    }

    public void checkboxOS(){
        driver.findElement(By.xpath("//*[@data-loc='" + ConfigProvider.getOS() + "']")).click();
    }
    public void checkboxLanCoop(){
        driver.findElement(By.xpath("//div[@data-collapse-name='category3']")).click();
        driver.findElement(By.xpath("//div[@data-loc='" + ConfigProvider.getLAN() +"']")).click();
    }
    public void checkboxAction(){
        WebElement input = driver.findElement(By.xpath("//*[@id='TagSuggest']"));
        input.sendKeys(ConfigProvider.getAction());
        WebElement check = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-loc='"+ ConfigProvider.getAction() + "']/descendant::span[@class='tab_filter_control_count']")));
        check.click();
    }

    public int countOfGamesAfterRequest(){
        WebElement count = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='search_results_count' and not(contains(@style, 'display: none'))]")));
        String[] countStr = count.getText().split(" ");
        int number = 0;
        for (String part : countStr)
            if (part.matches("\\d+"))
                number = Integer.parseInt(part);
        return number;
    }
    public int countOfGamesInList(){
        List<WebElement> count = driver.findElements(By.xpath("//a[contains(@class,'search_result_row') and not(contains(@style, 'display: none'))]"));
        return count.size();
    }

    public String nameGame() {
        return driver.findElement(By.xpath("//*[contains(@id,'search_resultsRows')]/descendant::span[1]")).getText();
    }
    public String dateName() {
        return driver.findElement(By.xpath("//*[contains(@id,'search_resultsRows')]/descendant::div[@class='col search_released responsive_secondrow'][1]")).getText();
    }
    public String costGame(){
        return driver.findElement(By.xpath("//*[contains(@id,'search_resultsRows')]/descendant::div[@class='discount_final_price'][1]")).getText();
    }

    public void clickTopFirstGame(){
        driver.findElement(By.xpath("//a[contains(@class, 'search_result_row') and not(contains(@style, 'display: none'))]")).click();
    }
}
