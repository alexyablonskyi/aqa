package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GenericWebPage {
    private WebDriver driver;

    public GenericWebPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GenericWebPage(){

    }

    @FindBy(css = "[class= 'firstLevelMenu']")
    private List<WebElement> menuItems;

    private void clickOnMenuItem(String menuItemName){
        for(int i=0; i < menuItems.size(); i++){
            if(menuItems.get(i).getText().equalsIgnoreCase(menuItemName)){
                menuItems.get(i).click();
                break;
            }
        }
    }
    @Step("Open Candidate page")
    public CandidatePage openCandidatePage(){
        clickOnMenuItem("Recruitment");
        return new CandidatePage(driver);
    }


}
