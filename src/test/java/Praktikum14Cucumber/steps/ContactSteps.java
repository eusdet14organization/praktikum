package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.ContactPage;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
       assertEquals("Dr Müller. Kontakt aufnehmen", TestContext.getDriver().getTitle());
    }

    @Then("The user should see ContactMethods in the contact section")
    public void theUserShouldSeeInTheContactSection() {
       assertTrue(contactPage.address.isDisplayed());
       assertTrue(contactPage.whatsApp.isDisplayed());
       assertTrue(contactPage.phone.isDisplayed());
       assertTrue(contactPage.emailAddresses.isDisplayed());
       assertTrue(contactPage.formFields.isDisplayed());
    }


    @Then("The user should see Contact Form")
    public void theUserShouldSee() {
        assertTrue(contactPage.name.isDisplayed());
        assertTrue(contactPage.email.isDisplayed());
        assertTrue(contactPage.theme.isDisplayed());
        assertTrue(contactPage.request.isDisplayed());
    }

    @And("The form should include a Submit button")
    public void theFormShouldIncludeASubmitButton() {
        contactPage.submitButton.isDisplayed();
    }
}
