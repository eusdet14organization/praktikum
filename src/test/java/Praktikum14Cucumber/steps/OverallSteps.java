package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static Praktikum14Cucumber.context.TestContext.getActions;
import static Praktikum14Cucumber.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverallSteps {
    HomePage homePage = new HomePage();
    MyAccountPage accountPage = new MyAccountPage();

    @Given("The user is on the main page")
    public void theUserIsOnTheMainPage() {
        assertTrue(homePage.companyLogo.isDisplayed());
    }

    @And("The user should be redirected on the {string}")
    public void checkTheActualUrl(String expectedUrl){
        String urlLowerCaseWithoutSpace = expectedUrl.replace(" ", "").toLowerCase();
        assertEquals(TestContext.getDriver().getCurrentUrl(),
                ConfigurationReader.get(urlLowerCaseWithoutSpace));
    }

    @Given("The user is logged by {string} and {string}")
    public void theUserIsLoggedByAnd(String email, String password) throws InterruptedException {
        homePage.loginUser.click();
        accountPage.fillOutTheLogInFormWithData(email,password);
        getActions().moveToElement(accountPage.logInButton).click().perform();
        getWait().until(ExpectedConditions.visibilityOf(accountPage.logOutButton));
        assertTrue(accountPage.titleH1.isDisplayed());
    }

    @And("The return to Home page")
    public void theReturnToHomePage () {
        getActions().moveToElement(homePage.companyLogo).click().perform();
        homePage.getMeinMenu("Startseite").click();
    }

    @And("The return to Home page EN")
    public void theReturnToHomePageEN() {
        getActions().moveToElement(homePage.companyLogo).click().perform();
        homePage.getMeinMenu("Home page").click();
    }
}