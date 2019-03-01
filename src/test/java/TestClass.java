import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pages.UzPage;

public class TestClass {

    private static WebDriver driver;

    @Test
    public void testKyivOdesa(){
        System.setProperty(Config.CHROME_WEBDRIVER_SYSTEM_PROPERTY, Config.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(Config.URL);
        UzPage uzPage = new UzPage(driver);
        uzPage.setCityFromKyiv();
        uzPage.setCityToOdesa();
    }
    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }
}
