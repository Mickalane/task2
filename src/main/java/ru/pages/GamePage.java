package ru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamePage {

    private final WebDriver driver;

    public GamePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void gamePageUniqueElement(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='glance_tags_label']")));
    }

    public String nameGame(){
        return driver.findElement(By.xpath("//*[@id='appHubAppName']")).getText();
    }

    public String dateGame(){
        return driver.findElement(By.xpath("//*[@class='release_date']/descendant::div[@class='date']")).getText();
    }

    public String costGame(){
        String str = driver.findElement(By.xpath("//div[@class='game_purchase_price price'][1]")).getText();
        return str.replaceAll("\\.", "");
    }

}
