package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.LanguagePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LanguageSteps {
    HomePage homePage = new HomePage();
    LanguagePage languagePage = new LanguagePage();

    @When("I hover the mouse over the Language switcher")
    public void iHoverTheMouseOverTheLanguageSwitcher() {
        TestContext.getActions().moveToElement(homePage.switchLanguageEN).perform();
    }

    @Then("I see a choose of two languages with country flags: English and German")
    public void iSeeAChooseOfTwoLanguagesWithCountryFlagsEnglishAndGerman() {
        TestContext.getWait().until(ExpectedConditions.visibilityOf(homePage.switchLanguageEN));
        TestContext.getWait().until(ExpectedConditions.visibilityOf(homePage.switchLanguageDE));
        assertTrue(homePage.switchLanguageEN.isDisplayed(), "English flag is not displayed");
        assertTrue(homePage.switchLanguageDE.isDisplayed(), "German flag is not displayed");
    }

    @Then("the Tooltip {string} is displayed below the English  language button")
    public void theTooltipEnIsDisplayedBelowTheEnglishLanguageButton() {
        assertEquals(languagePage.englishLanguageTitle.getAttribute("title"), "EN", "Tooltip text is not correct");
    }

    @When("The user click on {string} in the top menu")
    public void theUserClickOnLanguageInTheTopMenu(String language) {
        if (language.equals("DE")) {
            homePage.switchLanguageDE.click();
        } else {
            homePage.switchLanguageEN.click();
        }
    }

    @Then("The user should see the menu item in the {string}")
    public void theUserShouldSeeTheMenuItemInTheCorrectLanguage(String correctLanguage) {
        if (correctLanguage.equals("Startseite")) {
            assertEquals(languagePage.searchField.getAttribute("placeholder"), "Shop durchsuchen", "Site text is not in German");
        } else {
            assertEquals(languagePage.searchField.getAttribute("placeholder"), "Search store", "Site text is " +
                                                                                               "not in English");
        }
    }

    @When("The user switch the {string} to")
    public void theUserSwitchTheLanguageTo(String language) {
        if (language.equals("DE")) {
            homePage.switchLanguageDE.click();
        } else {
            homePage.switchLanguageEN.click();
        }
    }

    @And("The user reload the Page")
    public void theUserReloadThePage() {
        TestContext.getDriver().navigate().refresh();
    }

    @Then("the website should display content {string} in")
    public void theWebsiteShouldDisplayContentTextIn(String text) {
        if (text.equals("Startseite")) {
            assertEquals(languagePage.searchField.getAttribute("placeholder"), "Shop durchsuchen", "Site text is not in German");
        } else {
            assertEquals(languagePage.searchField.getAttribute("placeholder"), "Search store", "Site text is " +
                                                                                               "not in English");
        }
    }

    @When("The user switch the language to German")
    public void theUserSwitchTheLanguageToGerman() {
        homePage.switchLanguageDE.click();
    }

    @And("The user moves the cursor over the navigation menu")
    public void theUserMovesTheCursorOverTheNavigationMenu() {
        TestContext.getActions().moveToElement(homePage.menuRestorativeProdukte).perform();
    }

    @And("The user click on the {string}")
    public void theUserClickOnThe(String nameDropMenu) {
        homePage.getDropMenuRestorativeProdukte(nameDropMenu).click();
    }

    @Then("the website should display content in German")
    public void theWebsiteShouldDisplayContentInGerman() {
        assertEquals(languagePage.nameOfHeaderOfCategoryPage.getText(), "Kategorien", "This name is not in German");
    }
}