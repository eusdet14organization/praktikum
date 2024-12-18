package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.pages.RegistrationFormPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormSteps {

    HomePage homePage =new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @And("The user click on the {string} in the main menu")
    public void theUserClickOnTheMMeinKontoInTheMainMenu(String nameMenu) {
        homePage.getMeinMenu(nameMenu).click();
    }

    @And("The user click on the \"Hallo Konto\" menu item")
    public void theUserClickOnTheMenuItem() {
        homePage.loginUser.click();
    }

    @And("The user click on the {string} menu item in the footer")
    public void theUserClickOnTheMenuItemInTheFooter(String nameFooterMenu) {
        homePage.getFooterMenu(nameFooterMenu).click();
    }

    @When("The user click on the Register button")
    public void theUserClickOnTheButton() {
        myAccountPage.registerButton.click();
    }

    @Then("The user should be redirected to the registration page")
    public void theUserShouldBeRedirectedToTheRegistrationPage() {
        assertEquals(TestContext.getDriver().getCurrentUrl(),
                ConfigurationReader.get("logInUrl"));
        assertEquals(TestContext.getDriver().getTitle(),
                "Dr Müller. Registrierung");
    }

    @And("The name of registration form should be displayed")
    public void theNameOfRegistrationFormShouldBeDisplayed() {
        assertEquals(registrationFormPage.titleH1.getText(),
                "Registrierung");
    }

    @And("The form should include the following fields")
    public void theFormShouldIncludeTheFollowingFields(List<String> namesOfField) {
        registrationFormPage.verifyFormFields(namesOfField);
        assertTrue(registrationFormPage.firstName.isDisplayed());
        assertTrue(registrationFormPage.lastName.isDisplayed());
        assertTrue(registrationFormPage.eMail.isDisplayed());
        assertTrue(registrationFormPage.password.isDisplayed());
        assertTrue(registrationFormPage.confirmPassword.isDisplayed());
    }

    @And("The form should include a Register button")
    public void theFormShouldIncludeAButton() {
        assertTrue(registrationFormPage.registerButton.isDisplayed());
    }
}
