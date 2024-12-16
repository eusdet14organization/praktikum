package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps {

    HomePage homePage=new HomePage();
    SearchPage searchPage=new SearchPage();

    @When("The user enters the name of the {string} in the search field  auf Home Page.")
    public void theUserEntersTheNameOfTheProductInTheSearchFieldAufHomePage(String nameProduct) {
        homePage.fieldSearch.sendKeys(nameProduct);
        searchPage.searchButtonM.click();
    }

    @When("The user enters the name of the {string} in the search field.")
    public void theUserEntersTheNameOfTheProductInTheSearchField(String nameProduct) {
    searchPage.fieldInputSearch.sendKeys(nameProduct);
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
        int count=0;
        for (WebElement name: searchPage.nameProduct){
            if(name.getText().contains(nameProduct)){
                count++;
            }
        }
        assertEquals(searchPage.listProduct.size(),count);
    }

    @Then("The user sees in the products the {string} he was looking for.")
    public void theUserSeesInTheProductsTheDescriptionHeWasLookingFor(String nameDescription) {
        int count=0;
        for (WebElement name: searchPage.descriptionProduct){
            if(name.getText().contains(nameDescription)){
                count++;
            }
        }
        assertEquals(searchPage.listProduct.size(),count);
    }
}
