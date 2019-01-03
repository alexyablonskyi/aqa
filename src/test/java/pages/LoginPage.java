package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage{
    private WebDriver driver;

    @FindBy(id = "txtUsername")
    private WebElement usernameElement;

    @FindBy(id = "txtPassword")
    private WebElement passwordElement;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(id = "btnLogin")
    private List<WebElement> loginButtonEl;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }






    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    private void fillForm(String username, String password){
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButton.click();
    }

    public LoginPage fillLoginFormWithInvalidData(String username, String password){
        fillForm(username, password);
        return this;
    }

    @Step("Login as")
    public HomePage loginAs(String username, String password){
        fillForm(username, password);
        return new HomePage(driver);
    }
}
