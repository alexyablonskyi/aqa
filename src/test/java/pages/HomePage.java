package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends GenericWebPage{

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
}
