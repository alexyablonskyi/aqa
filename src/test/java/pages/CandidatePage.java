package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CandidatePage extends GenericWebPage {

    private WebDriver driver;

    public CandidatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(css = "#resultTable a[href *='addCandidate']")
    private List<WebElement> candidateNames;


    @Step
    public AddNewCandidatePage openAddNewCandidatePage(){
        addButton.click();
        return new AddNewCandidatePage(driver);
    }

    @Step("Is Candidate created")
    public boolean isCandidateCreated(String candidateName){
        for(WebElement el : candidateNames) {
            if(el.getText().equalsIgnoreCase(candidateName)){
                return true;
            }
        }
        return false;
    }

}
