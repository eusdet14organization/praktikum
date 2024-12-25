package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.ContactPage;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactSteps {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @And("The user click on the {string} in the navigation menu")
    public void theUserClickOnTheInTheNavigationMenu(String nameMenu) {
        homePage.getMeinMenu(nameMenu).click();
    }

    @Then("The user should be redirected to the contact page")
    public void theUserShouldBeRedirectedToTheContactPage() {
       assertEquals(TestContext.getDriver().getCurrentUrl(),
               ConfigurationReader.get("contactUrl"));
       assertEquals(TestContext.getDriver().getTitle(),"Dr Müller. Kontakt aufnehmen");
    }
}
