package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.RestorativeProduktePage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static Praktikum14Cucumber.utils.DataHelper.*;
import static Praktikum14Cucumber.context.TestContext.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationBarSteps {

    HomePage homePage =new HomePage();
    RestorativeProduktePage restorativeProduktePage = new RestorativeProduktePage();

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
        assertEquals(TestContext.getDriver().getCurrentUrl(),
                ConfigurationReader.get(correctPageUrl));
        assertEquals(TestContext.getDriver().getTitle(),
                ConfigurationReader.get(correctTitle));
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
}

