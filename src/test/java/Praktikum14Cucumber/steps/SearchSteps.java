package Praktikum14Cucumber.steps;


import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.SearchPage;
import Praktikum14Cucumber.utils.SearchPageHelp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    SearchPageHelp searchPageHelp = new SearchPageHelp();

    @When("The user enters the name or part the name of the {string} in the search field  auf Home Page.")
    public void theUserEntersTheNameOrPartTheNameOfTheProductInTheSearchFieldAufHomePage(String nameProduct) {
        homePage.fieldSearch.sendKeys(nameProduct);
        searchPage.searchButtonM.click();
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

    @Then("The user sees the {string} he was looking for.")
    public void theUserSeesTheProductHeWasLookingFor(String nameProduct) {

        assertEquals(searchPage.listProduct.size(),
                searchPageHelp.getAmountByValue(searchPage.nameProduct,nameProduct));
    }

    @Then("The user sees in the products the {string} he was looking for.")
    public void theUserSeesInTheProductsTheDescriptionHeWasLookingFor(String nameDescription) {

        assertEquals(searchPage.listProduct.size(),
                searchPageHelp.getAmountByValue(searchPage.descriptionProduct,nameDescription));
    }


}
