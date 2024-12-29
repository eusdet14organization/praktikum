package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.dto.User;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.DataHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Praktikum14Cucumber.context.TestContext.getActions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooterSteps {
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @And("The user clicks {string} in the footer of the site")
    public void theUserClicksLinkTitleInTheFooterOfTheSite(String titleLink) {
        getActions().moveToElement(homePage.getFooterMenu(titleLink)).click().perform();
    }

    @And("The user enters an Email in the subscription field")
    public void theUserEntersAnEmailInTheSubscriptionField() {
        User newTestUser = DataHelper.createNewTestUser();
        homePage.inputEmailSubscriptionField.sendKeys(newTestUser.getEmail());
    }

    @And("The user enters an {string} in the subscription field")
    public void theUserEntersAnEmailInTheSubscriptionField(String email) {
       homePage.inputEmailSubscriptionField.sendKeys(email);

    }

    @And("The user click Subscribe button")
    public void theUserClickSubscribeButton() {
        homePage.newsletterSubscribeButton.click();
    }



    @Then("The user checks that the {string} matches")
    public void theUserChecksThatThePageTitleMatchesLinkTitle(String titlePage) {
        assertEquals(titlePage, shoppingCartPage.namePage.getText());
        assertEquals(titlePage, shoppingCartPage.nameActivePage.getText());
    }


    @Then("The user sees the {string}")
    public void theUserSeesTheMessage(String message) {
        assertEquals(ConfigurationReader.get(message), homePage.messageNewsLetter.getText());
    }


}
