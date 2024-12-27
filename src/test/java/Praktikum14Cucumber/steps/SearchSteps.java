package Praktikum14Cucumber.steps;


import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.ProductPage;
import Praktikum14Cucumber.pages.SearchPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.SearchPageHelp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    SearchPageHelp searchPageHelp = new SearchPageHelp();
    ProductPage productPage = new ProductPage();

    @When("The user enters the name or part the name of the {string} in the search field  auf Top Menu.")
    public void theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchFieldAufTopMenu(String nameProduct) {

        homePage.fieldSearch.sendKeys(nameProduct);
        searchPage.searchNavMenuButton.click();
    }

    @When("The user enters the name or part the name of the {string} in the search field.")
    public void theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchField(String nameProduct) {

        searchPage.fieldInputSearch.sendKeys(nameProduct);
    }

    @When("The user selects a product {string}")
    public void theUserSelectsAProductCategory(String categoryProduct) {

        Select category = new Select(searchPage.selectCategorySearch);
        category.selectByVisibleText(categoryProduct);
    }

    @And("The user go to Search Page")
    public void theUserGoToSearchPage() {

        homePage.getFooterMenu("Suchen").click();
    }

    @And("The user marks the field {string}")
    public void theUserMarksTheField(String nameAdvancedOption) {

        searchPage.getAdvancedSearchMenu(nameAdvancedOption).click();
    }

    @And("The user click Search")
    public void theUserClickSearch() {

        searchPage.searchButton.click();
    }

    @And("The user goes to the product page.")
    public void theUserGoesToTheProductPage() {

        searchPage.listPictureProduct.get(searchPageHelp.randomizer(searchPage.listProduct)).click();
    }

    @Then("The user sees the {string} he was looking for.")
    public void theUserSeesTheProductHeWasLookingFor(String nameProduct) {

        assertTrue(searchPage.listProduct.size()>0);
        assertEquals(searchPage.listProduct.size(),
                searchPageHelp.getAmountByValue(searchPage.listNameProduct,nameProduct));
    }

    @Then("The user sees in the products the {string} he was looking for.")
    public void theUserSeesInTheProductsTheDescriptionHeWasLookingFor(String nameDescription) {

        assertTrue(searchPage.listProduct.size()>0);
        assertEquals(searchPage.listProduct.size(),
                searchPageHelp.getAmountByValue(searchPage.listDescriptionProduct,nameDescription));
    }


    @Then("The user sees the page of the selected {string}.")
    public void theUserSeesThePageOfTheSelectedProduct(String condition) {

        assertTrue(productPage.titleProduct.getText().contains(condition));
        assertTrue(productPage.descriptionProduct.isDisplayed());
        assertTrue(productPage.tableCharacteristicsAdvantages.isDisplayed());
    }

    @Then("The user sees the {string}.")
    public void theUserSeesThe(String message) {

        assertTrue(searchPage.messageNoProducts.isDisplayed());
        assertEquals(ConfigurationReader.get(message),searchPage.messageNoProducts.getText());
    }
}
