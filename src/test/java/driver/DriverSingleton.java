package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver == null){
            switch (System.getProperty("browser") == null ? "edge" : System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}