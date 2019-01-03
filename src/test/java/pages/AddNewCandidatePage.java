package pages;

import data.CandidateData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCandidatePage extends GenericWebPage {

    private WebDriver driver;

    public AddNewCandidatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "addCandidate[firstName]")
    private WebElement firstName;


    @Step
    public CandidatePage createCandidate(CandidateData data){
        firstName.sendKeys(data.getFirstName());
        return new CandidatePage(driver);
    }

    /*        driver.findElement(By.name("addCandidate[firstName]")).sendKeys(firstName);
        driver.findElement(By.name("addCandidate[middleName]")).sendKeys(middleName);
        driver.findElement(By.name("addCandidate[lastName]")).sendKeys(lastName);
        driver.findElement(By.name("addCandidate[email]")).sendKeys("ahmedo@pes.com");
        driver.findElement(By.name("addCandidate[contactNo]")).sendKeys("+380762123432");
        driver.findElement(By.id("btnSave")).click();*/
}
