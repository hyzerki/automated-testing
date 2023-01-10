package page;

import org.openqa.selenium.WebDriver;

public class GoogleMapsPage {

    protected WebDriver driver;

    public String getTitle(){
        return driver.getTitle();
    }


    protected GoogleMapsPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
