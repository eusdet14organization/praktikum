package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverallSteps {
    HomePage homePage = new HomePage();
    MyAccountPage accountPage = new MyAccountPage();

    @Given("The user is on the main page")
    public void theUserIsOnTheMainPage() {
        assertTrue(homePage.companyLogo.isDisplayed());
    }

    @Given("The user is logged")
    public void theUserIsLogged() throws InterruptedException {
        homePage.loginUser.click();
        accountPage.fillOutTheLogInFormWithData();
        accountPage.clickOnLogInButton();
        WebDriverWait wait = TestContext.getWait();
        wait.until(ExpectedConditions.visibilityOf(accountPage.logOutButton));
        assertTrue(accountPage.titleH1.isDisplayed());
    }
    @And("The user should be redirected on the {string}")
    public void checkTheActualUrl(String expectedUrl){
        String urlLowerCaseWithoutSpace = expectedUrl.replace(" ", "").toLowerCase();
        assertEquals(TestContext.getDriver().getCurrentUrl(),
                ConfigurationReader.get(urlLowerCaseWithoutSpace));
    }

}