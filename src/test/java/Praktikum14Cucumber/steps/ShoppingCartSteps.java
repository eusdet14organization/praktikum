package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.dto.Cart;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.ProductPage;
import Praktikum14Cucumber.pages.SearchPage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.SearchPageHelp;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Praktikum14Cucumber.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SearchPage searchPage = new SearchPage();
    SearchSteps searchSteps = new SearchSteps();
    SearchPageHelp searchPageHelp = new SearchPageHelp();
    ProductPage productPage = new ProductPage();

    int amountProductInCartStart = 0;
    int amountProductAddToCart = 1;


    @DataTableType
    public Cart addProduct(Map<String, String> table) {
        return new Cart(table.get("Product"), table.get("Amount"));
    }

    @When("The user clicks on the image of the Shopping Cart.")
    public void theUserClicksOnTheImageOfTheShoppingCart(){
        homePage.imagesCart.click();
    }

    @When("The user clicks on the number next to the shopping cart image.")
    public void theUserClicksOnTheNumberNextToTheShoppingCartImage() {
        homePage.amountProductInCart.click();
    }

    @When("The user clicks on the word Warenkorb in the top menu of the page.")
    public void theUserClicksOnTheWordWarenkorbInTheTopMenuOfThePage() {
        homePage.toCartButton.click();
    }

    @When("The user clicks on the word {string} in the bottom menu of the page.")
    public void theUserClicksOnTheWordInTheBottomMenuOfThePage(String namePage) {
        homePage.getFooterMenu(namePage).click();
    }

    @When("The user searches for and adds several products to the cart")
    public void theUserSearchesForAndAddsSeveralProductsToTheCart(List<Cart> carts) {
        amountProductAddToCart = 0;
        for (Cart cart : carts) {
            searchSteps.theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchFieldAufTopMenu(cart.getNameProduct());
            for (int i = 0; i < Integer.parseInt(cart.getAmount()); i++) {
                searchPage.listAddToCartButton.getFirst().click();
                searchPage.closeMessageButton.click();
                getWait().until(ExpectedConditions.invisibilityOf(searchPage.windowsNotification));
            }
            amountProductAddToCart = amountProductAddToCart + Integer.parseInt(cart.getAmount());
        }
    }

    @When("The user searches for and adds several products to the cart from product card.")
    public void theUserSearchesForAndAddsSeveralProductsToTheCartFromProductCard(List<Cart> carts){
        amountProductAddToCart =0;
        for (Cart cart:carts){
            searchSteps.theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchFieldAufTopMenu(cart.getNameProduct());
            searchPage.listNameProduct.getFirst().click();
            Select amountProduct = new Select(productPage.selectAmountProduct);
            amountProduct.selectByVisibleText(cart.getAmount());
            productPage.addToCartButton.click();
            searchPage.closeMessageButton.click();
            amountProductAddToCart = amountProductAddToCart + Integer.parseInt(cart.getAmount());
        }
    }

    @When("The user removes an product from the cart.")
    public void theUserRemovesAnProductFromTheCart(Map<String,String> dataTable) {
        int idx=searchPageHelp.getIndexProductByName(shoppingCartPage.listNameProductInCart,getDataTable(dataTable));
        shoppingCartPage.listDeleteProductButton.get(idx).click();
        shoppingCartPage.listConfirmDeleteProductButton.getLast().click();
    }

    @And("The user records the number of items in the cart.")
    public void theUserRecordsTheNumberOfItemsInTheCart() {
        amountProductInCartStart = Integer.parseInt(homePage.amountProductInCart.getText());
    }

    @And("The user clicks on the button Add to Cart on Product Card")
    public void theUserClicksOnTheButtonAddToCartOnProductCard() {
        searchPage.listAddToCartButton.getFirst().click();
    }

    @And("The user clicks on the button Add to Cart on Product Card {int} times")
    public void theUserClicksOnTheButtonAddToCartOnProductCardAmountTimes(int amount) {
        amountProductAddToCart = amount;
        for (int i = 0; i < amount; i++) {
            searchPage.listAddToCartButton.getFirst().click();
            searchPage.closeMessageButton.click();
            getWait().until(ExpectedConditions.invisibilityOf(searchPage.windowsNotification));
        }
    }

    @And("The user sees a {string} at the top of the page.")
    public void theUserSeesAAtTheTopOfThePage(String message) {
        assertTrue(searchPage.messageAddProductToCart.isDisplayed());
        assertEquals(ConfigurationReader.get(message), searchPage.messageAddProductToCart.getText());
        searchPage.closeMessageButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(searchPage.windowsNotification));
    }

    @And("The user change the amount of a product in the cart to {string}.")
    public void theUserChangeTheAmountOfAProductInTheCartToNewAmount(String newAmount) {
        Select amountProductSelect = new Select(shoppingCartPage.listSelectAmountProduct.getFirst());
        amountProductSelect.selectByVisibleText(newAmount);
    }

    @And("The user go to product card.")
    public void theUserGoToProductCard() {
        searchPage.listNameProduct.getFirst().click();
    }

    @And("The user clicks on the button Add to Cart.")
    public void theUserClicksOnTheButtonAddToCart(){
        productPage.addToCartButton.click();
        searchPage.closeMessageButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(searchPage.windowsNotification));
    }


    @Then("The user goes to the Cart page.")
    public void theUserGoesToTheCartPage() {
        assertTrue(shoppingCartPage.namePage.isDisplayed());
        assertEquals("Warenkorb", shoppingCartPage.namePage.getText());
        assertTrue(shoppingCartPage.nameActivePage.isDisplayed());
        assertEquals("Warenkorb", shoppingCartPage.nameActivePage.getText());
    }


    @Then("The user checks the amount product in the cart using the information in the main menu.")
    public void theUserChecksTheAmountProductInTheCartUsingTheInformationInTheMainMenu() {
        assertTrue(homePage.amountProductInCart.isDisplayed());
        assertEquals(amountProductAddToCart,
                Integer.parseInt(homePage.amountProductInCart.getText())- amountProductInCartStart);
    }


    @Then("The user checks the name {string} and {int}  in the cart.")
    public void theUserChecksTheNameProductAndAmountInTheCart(String nameProduct, int amountProduct) {
        Select amountProductSelect = new Select(shoppingCartPage.listSelectAmountProduct.getFirst());
        assertEquals(nameProduct,shoppingCartPage.listNameProductInCart.getFirst().getText());
        assertEquals(amountProduct,Integer.parseInt(amountProductSelect.getFirstSelectedOption().getText()));
    }

    @Then("The user checks the amount and product in the cart.")
    public void theUserChecksTheAmountAndProductInTheCart(Map<String,String> dataTable) {
        assertEquals(getDataTable(dataTable),searchPageHelp.getMapProductInCart(shoppingCartPage.listNameProductInCart,
                searchPageHelp.getAmountBySelect(shoppingCartPage.listSelectAmountProduct)));
    }


    @Then("The user selects the required {string} of product")
    public void theUserSelectsTheRequiredAmountOfProduct(String amount) {
        amountProductAddToCart=Integer.parseInt(amount);
        Select amountProductToCart = new Select(productPage.selectAmountProduct);
        amountProductToCart.selectByVisibleText(amount);
    }

    public Map<String,String> getDataTable(Map<String,String> dataTable) {
        Map<String, String> processedData = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : dataTable.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            processedData.put(key, value);
        }
        return processedData;
    }



}
