package tests;

import com.github.javafaker.Faker;
import data.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class CreateNewCandidate extends GenericWebTest{

    @BeforeClass
    public void beforeClassTest(){
        System.out.println("Child before class");
    }

    @Test
    public void testCreateNewCandidate() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String middleName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " "  + middleName + " " + lastName;

        openWebApp(Constant.URL)
                .loginAs(Constant.USERNAME, Constant.PASSWORD);
        HomePage homePage = new HomePage(driver);



        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.name("addCandidate[firstName]")).sendKeys(firstName);
        driver.findElement(By.name("addCandidate[middleName]")).sendKeys(middleName);
        driver.findElement(By.name("addCandidate[lastName]")).sendKeys(lastName);
        driver.findElement(By.name("addCandidate[email]")).sendKeys("ahmedo@pes.com");
        driver.findElement(By.name("addCandidate[contactNo]")).sendKeys("+380762123432");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();


        List<WebElement> candidateNames = driver.findElements(By.cssSelector("#resultTable a[href *='addCandidate']"));
        List<String> names = new ArrayList<>();

        for(WebElement el : candidateNames){
            names.add(el.getText());
        }

        System.out.println(names);

        Assert.assertTrue(names.contains(fullName),
                "Candidate with name " + fullName + " is not found in Candidate table");
    }
}
