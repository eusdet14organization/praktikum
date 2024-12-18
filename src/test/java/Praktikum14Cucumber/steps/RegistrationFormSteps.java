package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormSteps {

    HomePage homePage =new HomePage();

    @And("The user click on the \"Mein Konto\" in the main menu")
    public void theUserClickOnTheMMeinKontoInTheMainMenu() {
        homePage.getMeinMenu("Mein Konto");
    }


}
