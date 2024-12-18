package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverallSteps {
    HomePage homePage =new HomePage();

    @Given("The user is on the main page")
    public void theUserIsOnTheMainPage() {
        assertTrue(homePage.companyLogo.isDisplayed());
    }

    @When("I should see options to {string}.")
    public void iShouldSeeOptionsToLanguage() {
    }
}
