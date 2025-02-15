package ru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    
    public WebElement page(){
        return driver.findElement(By.xpath("//*[@id='logo_holder']/child::a"));
    }

    public void mainPageUniqueElement() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='gutter_header gutter_top']")));
    }

    public void clickAbout(){
        String about = "//a[contains(@href,'/about/') and contains(@href,'global-header')]";
        driver.findElement(By.xpath(about)).click();
    }

    public void clickStore(){
        String store = "//div[@class='supernav_container']/child::a[contains(@data-tooltip-content,'Store')]";
        driver.findElement(By.xpath(store)).click();
    }
    
    public void topSellers(){
        WebElement popupWindow = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='noteworthy_tab']")));
        popupWindow.click();

        driver.findElement(By.xpath("//a[@class='popup_menu_item' and contains(@href,'topselling')]")).click();
    }
}
