package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.ContactPage;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactSteps {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();
//
//    @And("The user click on the {string} in the main menu the main menu")
//    public void theUserClickOnTheInTheMainMenuTheMainMenu(String nameMenu) {
//        homePage.getMeinMenu(nameMenu).click();
//    }

    @And("The user click on the button {string} in the main menu")   //when
    public void theUserClickOnTheButtonKontaktInTheMainMenu(String nameMenu) {
        homePage.getMeinMenu(nameMenu).click();
    }

    @When("The user click on the Address Button")   // Then  all contact info
    public void theUserClickOnTheAddressButton() {
        assertEquals(contactPage.contactAddress.getText(),
                ConfigurationReader.get("contactAddress"));
    }

}
