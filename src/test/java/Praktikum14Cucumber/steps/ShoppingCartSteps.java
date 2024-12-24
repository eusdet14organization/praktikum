package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @When("The user clicks on the image of the Shopping Cart.")
    public void theUserClicksOnTheImageOfTheShoppingCart() {
        homePage.imagesCart.click();
    }


    @When("The user clicks on the number next to the shopping cart image.")
    public void theUserClicksOnTheNumberNextToTheShoppingCartImage() {
        homePage.amountProductInCart.click();
    }

    @When("The user clicks on the word {string} in the top menu of the page.")
    public void theUserClicksOnTheWordInTheTopMenuOfThePage(String namePage) {
        homePage.toCartButton.click();
    }

    @When("The user clicks on the word {string} in the bottom menu of the page.")
    public void theUserClicksOnTheWordInTheBottomMenuOfThePage(String namePage) {
        homePage.getFooterMenu(namePage).click();
    }

    @Then("The user goes to the Cart page.")
    public void theUserGoesToTheCartPage() {
        assertTrue(shoppingCartPage.namePage.isDisplayed());
        assertEquals("Warenkorb", shoppingCartPage.namePage.getText());
        assertTrue(shoppingCartPage.nameActivePage.isDisplayed());
        assertEquals("Warenkorb",shoppingCartPage.nameActivePage.getText());


    }
}
