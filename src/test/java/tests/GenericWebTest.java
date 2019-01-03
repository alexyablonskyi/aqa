package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GenericWebTest {
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getWebDriver();

        System.out.println("I will start test");
    }

    @AfterClass
    public void afterClass(){
        closeBrowser(driver);
    }

    @Step("Open browser")
    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")
                        + File.separator
                        + "drivers"
                        + File.separator
                        + "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @Step("Open Web app")
    public LoginPage openWebApp(String url){
        driver.get(url);
        return  new LoginPage(driver);
    }

    @Step("Close browser")
    public void closeBrowser(WebDriver driver){
        driver.quit();
    }
}
