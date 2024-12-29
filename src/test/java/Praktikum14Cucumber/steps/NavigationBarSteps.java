package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.pages.*;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static Praktikum14Cucumber.utils.DataHelper.*;
import static Praktikum14Cucumber.context.TestContext.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationBarSteps {

    HomePage homePage =new HomePage();
    RestorativeProduktePage restorativeProduktePage = new RestorativeProduktePage();
    SearchPage searchPage = new SearchPage();

    @When("The user moves the mouse on the {string} in the main menu and clicks")
    public void theUserMovesTheMouseOnTheMenuNameInTheMainMenuAndClicks(String nameMenu) {
        homePage.getMeinMenu(nameMenu).click();
    }

    @And("The User selects \"Restorative Produkte\" in the main menu")
    public void theUserSelectsInTheMainMenu() {
        homePage.menuRestorativeProdukte.click();
    }

    @Then("The user should be redirected to the {string} and page have {string}")
    public void theUserClickOnTheButton(String correctPageUrl, String correctTitle) {
        assertEquals(ConfigurationReader.get(correctPageUrl),getDriver().getCurrentUrl());
        assertEquals(ConfigurationReader.get(correctTitle),getDriver().getTitle());
    }

    @When("The user moves mouse to the \"Restorative Producte\" in the main menu")
    public void theUserMovesMouseToTheInTheMainMenu() {
        getActions().moveToElement(homePage.menuRestorativeProdukte).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(homePage.menuRestorativeProdukte));
    }

    @Then("The user must see a submenu appearing")
    public void theUserMustSeeASubmenuAppearing() {
        List<String> expectedSubMenu = new ArrayList<>(List.of("Composite", "Bleaching", "Befestigungscomposite",
                "Prophy Materials", "Liners", "Etching", "Bonding"));
        assertEquals(expectedSubMenu, getListStringByListWebElement(homePage.listSubmenuOfRestorativeProdukte));
    }

    @And("The user selects a {string} item")
    public void theUserSelectsANameMenuItem(String nameMenu) {
        homePage.getDropMenuRestorativeProdukte(nameMenu).click();
    }

    @And("The user should be redirected to the Restorative Produkte page and this page have correct title")
    public void theUserShouldBeRedirectedToTheAndThisPageHave() {
        assertEquals(ConfigurationReader.get("recoveryProductsUrl"), getDriver().getCurrentUrl());
        assertEquals(ConfigurationReader.get("recoveryProductsUrlTitle"),getDriver().getTitle());
    }

    @When("The user select a {string} item")
    public void theUserSelectANameLeftMenuItem(String nameLeftMenu) {
        restorativeProduktePage.selectTheLeftMenuItem(nameLeftMenu).click();
    }

    @When("The user chooses a {string} item")
    public void theUserChoosesANameCenterMenuItem(String nameCenterMenu) {
        restorativeProduktePage.selectTheCenterMenuItem(nameCenterMenu).click();
    }

    @Then("The user can opens the card of each product in this section")
    public void theUserOpensTheCardOfEachProductInThisSection() {
        for (int i = 0; i < searchPage.listNameProduct.size(); i++) {
            String nameOfProduct = searchPage.listNameProduct.get(i).getText();
            WebElement product = searchPage.listNameProduct.get(i);
            getWait().until(ExpectedConditions.elementToBeClickable(product));
            getJs().executeScript("arguments[0].click();", product);
            assertEquals(getDriver().getTitle(), "Dr Müller. "+nameOfProduct);
            getDriver().navigate().back();
        }
    }
}

