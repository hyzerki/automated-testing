package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void waitBeforeNewTest(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterClass(alwaysRun = true)
    public void closeDriver()
    {
        driver.close();
    }
}
