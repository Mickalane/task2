package properties;

import org.openqa.selenium.WebDriver;

public class Singleton {
    private static Singleton instance = null;
    private static WebDriver driver;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
