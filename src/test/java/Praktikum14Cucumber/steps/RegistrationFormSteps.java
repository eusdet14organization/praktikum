package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.pages.RegistrationFormPage;
import Praktikum14Cucumber.pages.RegistrationResultPage;
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
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

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

    @When("The user enters correct personal data")
    public void theUserEntersCorrectPersonalData() throws InterruptedException {
        registrationFormPage.enteringCorrectDataInTheAllFields();
    }

    @And("The user clicks the Register button")
    public void theUserClicksTheRegisterButton() {
        registrationFormPage.registerButton.click();
    }

    @Then("The user sees a message about successful registration")
    public void theUserSeesAMessageAboutSuccessfulRegistration() {
        assertEquals(registrationResultPage.successfulRegistration.getText(),
                ConfigurationReader.get("messageSuccessfulRegistration"));
    }

    @And("The user clicks the \"Weiter\" button to access their account")
    public void theUserClicksTheButtonToAccessTheirAccount() {
        registrationResultPage.continueAfterReg.click();
    }

    @Then("The user account page opens")
    public void theUserAccountPageOpens() {
        assertEquals(TestContext.getDriver().getCurrentUrl(),
                ConfigurationReader.get("accountUrl"));
    }

    @Then("The user should see an alarm messages against all mandatory fields")
    public void theUserShouldSeeAnAlarmMessagesAgainstAllMandatoryFields() {
        assertEquals(registrationFormPage.fieldValidationErrorFirstName.getText(),
                ConfigurationReader.get("messageRequiredFirstNameField"));
        assertEquals(registrationFormPage.fieldValidationErrorLastName.getText(),
                ConfigurationReader.get("messageRequiredLastNameField"));
        assertEquals(registrationFormPage.fieldValidationErrorEmail.getText(),
                ConfigurationReader.get("messageRequiredAdressField"));
        assertEquals(registrationFormPage.fieldValidationErrorPassword.getText(),
                ConfigurationReader.get("messageRequiredPasswordField"));
        assertEquals(registrationFormPage.fieldValidationErrorConfirmPassword.getText(),
                ConfigurationReader.get("messageRequiredPasswordField"));
    }

    @When("The user tries to enter {string} in the first name field")
    public void theUserTriesToEnterIncorrectDataInTheFirstNameField(String incorrectDataFirstName) throws InterruptedException {
        if ("SP".equals(incorrectDataFirstName)) {
            incorrectDataFirstName = " ";
        }
    registrationFormPage.enteringIncorrectDataInTheFirstNameField(incorrectDataFirstName);
    }

    @Then("The user should see an alarm message next to the incorrectly filled in first name field")
    public void theUserShouldSeeAnAlarmMessageNextToTheIncorrectlyFilledInFirstNameField() {
        assertEquals(registrationFormPage.fieldValidationErrorFirstName.getText(),
                ConfigurationReader.get("messageRequiredFirstNameField"));
    }

    @When("The user tries to enter {string} in the last name field")
    public void theUserTriesToEnterIncorrectDataInTheLastNameField(String incorrectDataLastName) throws InterruptedException {
        if ("SP".equals(incorrectDataLastName)) {
            incorrectDataLastName = " ";
        }
        registrationFormPage.enteringIncorrectDataInTheLastNameField(incorrectDataLastName);
    }

    @Then("The user should see an alarm message next to the incorrectly filled in last name field")
    public void theUserShouldSeeAnAlarmMessageNextToTheIncorrectlyFilledInLastNameField() {
        assertEquals(registrationFormPage.fieldValidationErrorLastName.getText(),
                ConfigurationReader.get("messageRequiredLastNameField"));
    }

    @When("The user tries to enter {string} in the Email field")
    public void theUserFillsInAllFieldsExceptEmail(String incorrectEmail) throws InterruptedException {
        if ("SP".equals(incorrectEmail)) {
            incorrectEmail = " ";
        }
        registrationFormPage.enteringIncorrectEmailField(incorrectEmail);
    }

    @When("The user tries to enter {string} in the email field")
    public void theUserTriesToEnterIncorrectDataInTheEmailField(String incorrectEmail) {
       registrationFormPage.eMail.sendKeys(incorrectEmail);
       registrationFormPage.password.click();
    }

    @Then("The user should see an {string} v1 next to the incorrectly filled in email field")
    public void theUserShouldSeeAnAlarmMessageV1NextToTheIncorrectlyFilledInEmailField(String correctAlarmMassage) {
        assertEquals(registrationFormPage.fieldValidationErrorEmail.getText(),
                ConfigurationReader.get(correctAlarmMassage));
    }

    @Then("The user should see an {string} v2 next to the incorrectly filled in email field")
    public void theUserShouldSeeAnAlarmMessageV2NextToTheIncorrectlyFilledInEmailField(String correctAlarmMassage) {
        assertEquals(registrationFormPage.fieldAlarmMessage.getText(),
                ConfigurationReader.get(correctAlarmMassage));
    }

    @When("The user tries to enter {string} in the password field")
    public void theUserTriesToEnterIncorrectDataInThePasswordField(String incorrectPassword) throws InterruptedException {
        if ("SP".equals(incorrectPassword)) {
            incorrectPassword = " ";
        }
        registrationFormPage.enteringIncorrectPasswordField(incorrectPassword);
    }

    @Then("The user should see an {string} next to the incorrectly filled in password field")
    public void theUserShouldSeeAnAlarmMessageNextToTheIncorrectlyFilledInPasswordField(String correctAlarmMassage) {
        assertTrue(registrationFormPage.fieldValidationErrorPassword.getText().contains(ConfigurationReader.get(correctAlarmMassage)));
    }

    @When("The User has entered a {string} and {string} in confirmation password field")
    public void theUserHasEnteredAValidPasswordAndIncorrectDataInConfirmationPasswordField(String correctPassword, String incorrectConfirmPassword) throws InterruptedException {
        registrationFormPage.enteringIncorrectConfirmPasswordField(correctPassword, incorrectConfirmPassword);
    }

    @Then("The user should see an {string} next to the incorrectly filled in confirm password field")
    public void theUserShouldSeeAnAlarmMessageNextToTheIncorrectlyFilledInConfirmPasswordField(String correctAlarmMassage) {
        assertEquals(registrationFormPage.fieldValidationErrorConfirmPassword.getText(),
                ConfigurationReader.get(correctAlarmMassage));
    }
}
