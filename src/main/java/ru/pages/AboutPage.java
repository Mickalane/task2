package ru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {
    private final WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver=driver;
    }
    public void aboutPageUniqueElement(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='about_subtitle']")));
    }

    public int onlineNum(){
        WebElement onlineElement = driver.findElement(By.xpath("//*[contains(@class,'gamers_online')]/parent::*"));
        String onlineCount = onlineElement.getText().replaceAll("\\D+", "");
        return Integer.parseInt(onlineCount);
    }
    public int playingNowNum() {
        WebElement playingNowElement = driver.findElement(By.xpath("//*[contains(@class,'gamers_in_game')]/parent::*"));
        String playingNowCount = playingNowElement.getText().replaceAll("\\D+", "");
        return Integer.parseInt(playingNowCount);
    }
}
