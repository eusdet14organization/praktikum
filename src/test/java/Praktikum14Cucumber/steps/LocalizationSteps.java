package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.LocalizationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LocalizationSteps {

    HomePage homePage = new HomePage();
    LocalizationPage localizationPage = new LocalizationPage();

    @When("I hover the mouse over the Language switcher")
    public void iHoverTheMouseOverTheLanguageSwitcher() {
       // TestContext.getWait().until(ExpectedConditions.elementToBeClickable(homePage.switchLanguageEN));
        TestContext.getActions().moveToElement(homePage.switchLanguageEN).perform();
    }

    @Then("I see a choose of two languages with country flags: English and German")
    public void iSeeAChooseOfTwoLanguagesWithCountryFlagsEnglishAndGerman() {
        TestContext.getWait().until(ExpectedConditions.visibilityOf(homePage.switchLanguageEN));
        TestContext.getWait().until(ExpectedConditions.visibilityOf(homePage.switchLanguageDE));
        assertTrue(homePage.switchLanguageEN.isDisplayed(), "English flag is not displayed");
        assertTrue(homePage.switchLanguageDE.isDisplayed(), "German flag is not displayed");
    }



    @When("I move the cursor over the English language icon")
    public void iMoveTheCursorOverTheEnglishLanguageIcon() {
        TestContext.getActions().moveToElement(homePage.switchLanguageEN).perform();
    }

    @Then("the Tooltip {string} is displayed below the English  language button")
    public void theTooltipIsDisplayedBelowTheEnglishLanguageButton(String arg0) {
        TestContext.getWait().until(ExpectedConditions.visibilityOf(localizationPage.englishLanguageTitle));
        assertEquals("EN", localizationPage.englishLanguageTitle.getAttribute("title"), "Tooltip text is not correct");
    }



    @When("I move the cursor over the German language icon")
    public void iMoveTheCursorOverTheGermanLanguageIcon() {
        TestContext.getActions().moveToElement(homePage.switchLanguageDE).perform();
    }

    @Then("the Tooltip {string} is displayed below the German button")
    public void theTooltipEdIsDisplayedBelowTheGermanButton() {
        TestContext.getWait().until(ExpectedConditions.visibilityOf(localizationPage.englishLanguageTitle));
        assertEquals("DE", localizationPage.germanLanguageTitle.getAttribute("title"), "Tooltip text is not correct");
    }



    @When("I click on the German language icon")
    public void iClickOnTheGermanLanguageIcon() {
        homePage.switchLanguageDE.click();
    }

    @Then("all text on the site is displayed in German")
    public void allTextOnTheSiteIsDisplayedInGerman() {
        String languageText = localizationPage.startSeite.getText();
        assertTrue(languageText.contains("Startseite"), "Site text is not in German");
        System.out.println(languageText.contains("Startseite"));
    }

    @Then("all texts on the website should be displayed in German")
    public void allTextsOnTheWebsiteShouldBeDisplayedInGerman() {
        //TestContext.getWait().until(ExpectedConditions.visibilityOf(localizationPage.startSeite));
        String actualText = localizationPage.startSeite.getText();
        assertTrue(actualText.contains("Startseite"),"The text is not in German");
    }

    @When("I reload the page")
    public void iReloadThePage() {
        TestContext.getDriver().navigate().refresh();
    }

    @Then("all texts on the website should still be displayed in German")
    public void allTextsOnTheWebsiteShouldStillBeDisplayedInGerman() {
        //TestContext.getWait().until(ExpectedConditions.visibilityOf(localizationPage.startSeite));
        String actualText = localizationPage.startSeite.getText();
        assertTrue(actualText.contains("Startseite"),"The text is not in German");
    }

}