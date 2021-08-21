package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverUtil {

    final static String BASE_URL = "https://money.gocompare.com/";
    final static String DRIVER_PATH = "/Users/compucorp/Downloads/cdr/chromedriver";
    final static String DRIVER_NAME = "webdriver.chrome.driver";
    WebDriver driver;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    @Before
    public WebDriver initiateDriver() {
        if (driver == null) {
            System.setProperty(DRIVER_NAME, DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @After
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
