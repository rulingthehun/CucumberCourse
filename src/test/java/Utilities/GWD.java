package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) { // 1 kere başlat
            //driver'ı start et doldur, başlat ve gönder

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

            //System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();

            //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            //WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();

            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.edge.verboseLogging", "true");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            //WebDriverManager.safaridriver().setup();
            //driver = new SafariDriver();
        }


        return driver;
    }

    public static void quitDriver() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null)  // dolu ise
        {
            driver.quit();
            driver = null;
        }
    }


}
