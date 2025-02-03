package properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseConfigData {

    protected WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Singleton.setDriver(driver);
    }

    @After
    public void tearDown() {
        Singleton.quit();
    }
}
