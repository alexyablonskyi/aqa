package tests;

import com.github.javafaker.Faker;
import data.CandidateData;
import data.CandidateDataProvider;
import data.Constant;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CandidatePage;
import pages.GenericWebPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

@Epic("MAIN EPIC")
@Feature("CANDIDATE")
@Story("OCE-123")
public class CreateNewCandidate extends GenericWebTest{
    private CandidateData candidateData;

    @BeforeClass
    public void beforeCreateNewCandidate(){
         candidateData = new CandidateDataProvider().generateCandidateData();
    }
    @Test
    public void testCreateNewCandidate() {
        HomePage homePage = openWebApp(Constant.URL)
                .loginAs(Constant.USERNAME, Constant.PASSWORD);
        GenericWebPage genericPage = new GenericWebPage(driver);

        CandidatePage candidatePage = genericPage.openCandidatePage().openAddNewCandidatePage()
                .createCandidate(candidateData);

        Assert.assertTrue(candidatePage.isCandidateCreated(candidateData.getFullName()),
                "Candidate with name " + candidateData.getFullName() + " is not found in Candidate table");
    }
}
