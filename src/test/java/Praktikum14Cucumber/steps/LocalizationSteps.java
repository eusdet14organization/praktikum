package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalizationSteps {

    HomePage homePage = new HomePage();

    @Then("I should see options to {string}.")
    public void iShouldSeeOptionsToLanguage(String language) {
//        assertTrue(homePage.switchLanguageEN.isDisplayed());
//        assertTrue(homePage.switchLanguageDE.isDisplayed());

            if (language.equals("German")) {
                assertTrue(homePage.switchLanguageDE.isDisplayed());
            } else if (language.equals("English")) {
                assertTrue(homePage.switchLanguageEN.isDisplayed());
            } else {
                throw new IllegalArgumentException("Unsupported language: " + language);
            }
    }

}