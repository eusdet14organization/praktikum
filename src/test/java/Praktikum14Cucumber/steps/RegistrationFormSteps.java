package Praktikum14Cucumber.steps;

import io.cucumber.java.en.Given;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormSteps {

    @And("The user click on the \"Mein Konto\" in the main menu")
    public void theUserIsOnTheMainPage() {
        assertTrue(homePage.companyLogo.isDisplayed());
    }
}
