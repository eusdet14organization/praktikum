package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.dto.Cart;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.SearchPage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SearchPage searchPage = new SearchPage();
    SearchSteps searchSteps = new SearchSteps();

    int amountProductInCart = 0;
    int amountProductAddToCart = 1;


    @DataTableType
    public Cart addProduct(Map<String, String> table) {
        return new Cart(table.get("Product"), table.get("Amount"));
    }

    @When("The user clicks on the image of the Shopping Cart.")
    public void theUserClicksOnTheImageOfTheShoppingCart() {
        homePage.imagesCart.click();
    }


    @When("The user clicks on the number next to the shopping cart image.")
    public void theUserClicksOnTheNumberNextToTheShoppingCartImage() {
        homePage.amountProductInCart.click();
    }

    @When("The user clicks on the word Warenkorb in the top menu of the page.")
    public void theUserClicksOnTheWordWarenkorbInTheTopMenuOfThePage(String namePage) {
        homePage.toCartButton.click();
    }

    @When("The user clicks on the word {string} in the bottom menu of the page.")
    public void theUserClicksOnTheWordInTheBottomMenuOfThePage(String namePage) {
        homePage.getFooterMenu(namePage).click();
    }

    @When("The user searches for and adds several products to the cart")
    public void theUserSearchesForAndAddsSeveralProductsToTheCart(List<Cart> carts) throws InterruptedException {
        amountProductInCart = Integer.parseInt(homePage.amountProductInCart.getText());
        amountProductAddToCart = 0;
        for (Cart cart : carts) {
            searchSteps.theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchFieldAufTopMenu(cart.getNameProduct());
            for (int i = 0; i < Integer.parseInt(cart.getAmount()); i++) {
                searchPage.listAddToCartButton.getFirst().click();
                assertTrue(searchPage.messageAddProductToCart.isDisplayed());
                searchPage.closeMessageButton.click();
                Thread.sleep(2000);
            }
            amountProductAddToCart = amountProductAddToCart + Integer.parseInt(cart.getAmount());
        }
    }

    @And("The user records the number of items in the cart.")
    public void theUserRecordsTheNumberOfItemsInTheCart() {
        amountProductInCart = Integer.parseInt(homePage.amountProductInCart.getText());
    }

    @And("The user clicks on the button Add to Cart on Product Card")
    public void theUserClicksOnTheButtonAddToCartOnProductCard() {
        searchPage.listAddToCartButton.getFirst().click();
    }

    @And("The user clicks on the button Add to Cart on Product Card {int} times")
    public void theUserClicksOnTheButtonAddToCartOnProductCardAmountTimes(int amount) throws InterruptedException {
        amountProductAddToCart = amount;
        for (int i = 0; i < amount; i++) {
            searchPage.listAddToCartButton.getFirst().click();
            assertTrue(searchPage.messageAddProductToCart.isDisplayed());
            searchPage.closeMessageButton.click();
            Thread.sleep(2000);
        }
    }

    @And("The user sees a {string} at the top of the page.")
    public void theUserSeesAAtTheTopOfThePage(String message) {
        assertTrue(searchPage.messageAddProductToCart.isDisplayed());
        assertEquals(ConfigurationReader.get(message), searchPage.messageAddProductToCart.getText());
    }


    @Then("The user goes to the Cart page.")
    public void theUserGoesToTheCartPage() {
        assertTrue(shoppingCartPage.namePage.isDisplayed());
        assertEquals("Warenkorb", shoppingCartPage.namePage.getText());
        assertTrue(shoppingCartPage.nameActivePage.isDisplayed());
        assertEquals("Warenkorb", shoppingCartPage.nameActivePage.getText());
    }


    @Then("The user checks amount Product in Cart")
    public void theUserChecksAmountProductInCart() {
        assertTrue(homePage.amountProductInCart.isDisplayed());
        assertEquals(amountProductInCart + amountProductAddToCart,
                Integer.parseInt(homePage.amountProductInCart.getText()));
    }

}
