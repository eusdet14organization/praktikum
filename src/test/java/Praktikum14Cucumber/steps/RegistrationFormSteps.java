package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.dto.User;
import Praktikum14Cucumber.pages.HomePage;
import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.pages.RegistrationFormPage;
import Praktikum14Cucumber.pages.RegistrationResultPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.DataHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;
import java.util.List;
import java.util.Random;

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
        Random random = new Random();
        User newTestUser = DataHelper.createNewTestUser();
        registrationFormPage.genderMale.click();
        registrationFormPage.firstName.sendKeys(newTestUser.getFirstName());
        Thread.sleep(500);
        for (char ch : newTestUser.getLastName().toCharArray()) {
            registrationFormPage.lastName.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        Select selectDay = new Select(registrationFormPage.dateOfBirthDay);
        selectDay.selectByVisibleText(String.valueOf(random.nextInt(30) + 1));
        Select selectMonth = new Select(registrationFormPage.dateOfBirthMonth);
        String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
                "Oktober", "November", "Dezember"};
        selectMonth.selectByVisibleText(months[random.nextInt(months.length)]);
        int currentYear = Year.now().getValue();
        int randomYear = 1914 + random.nextInt(currentYear - 1914 + 1);
        Select selectYear = new Select(registrationFormPage.dateOfBirthYear);
        selectYear.selectByVisibleText(String.valueOf(randomYear));

        registrationFormPage.eMail.sendKeys(newTestUser.getEmail());
        Thread.sleep(900);
        registrationFormPage.company.sendKeys(newTestUser.getCompany());
        Thread.sleep(600);
        registrationFormPage.password.sendKeys(newTestUser.getPassword());
        Thread.sleep(200);
        registrationFormPage.confirmPassword.sendKeys(newTestUser.getPassword());
        Thread.sleep(400);
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

    }
}
