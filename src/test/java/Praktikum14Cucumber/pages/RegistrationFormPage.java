package Praktikum14Cucumber.pages;

import Praktikum14Cucumber.dto.User;
import Praktikum14Cucumber.utils.DataHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormPage extends BasePage {

    @FindBy(xpath = "//h1[@class='h3 text-light mb-0']")
    public WebElement titleH1;

    @FindBy(xpath = "//*[@id='gender']")
    public WebElement gender;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='gender-male']")
    public WebElement genderMale;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='gender-female']")
    public WebElement genderFemale;

    @FindBy(xpath = "//*[@id='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement dateOfBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement dateOfBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement dateOfBirthYear;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath = "//*[@id='Company']")
    public WebElement company;

    @FindBy(xpath = "//*[@id='Newsletter']")
    public WebElement newsLetter;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@name='register-button']")
    public WebElement registerButton;

    @FindBy (xpath = "//label[@class='d-flex justify-content-end col-4']")
    public List<WebElement> fieldNames;

    @FindBy (xpath = "//*[@id='FirstName-error']")
    public WebElement fieldValidationErrorFirstName;

    @FindBy (xpath = "//*[@id='LastName-error']")
    public WebElement fieldValidationErrorLastName;

    @FindBy (xpath = "//*[@id='Email-error']")
    public WebElement fieldValidationErrorEmail;

    @FindBy (xpath = "//div[@class='alert alert-primary alert alert-danger validation-summary-errors']")
    public WebElement fieldAlarmMessage;

    @FindBy (xpath = "//*[@id='Password-error']")
    public WebElement fieldValidationErrorPassword;

    @FindBy (xpath = "//*[@id='ConfirmPassword-error']")
    public WebElement fieldValidationErrorConfirmPassword;

    public void verifyFormFields(List<String> namesOfField) {
        List<String> actualFieldNames = fieldNames.stream()
                                                .map(WebElement::getText)
                                                .toList();

        for (String expectedNameOfField : namesOfField) {
            assertTrue(actualFieldNames.contains(expectedNameOfField),
                    "Поле '" + expectedNameOfField + "' отсутствует на странице!");
        }
    }
    public void enteringCorrectDataInTheAllFields () throws InterruptedException {
    User newTestUser = DataHelper.createNewTestUser();
        genderMale.click();
        firstName.sendKeys(newTestUser.getFirstName());
        Thread.sleep(500);
        for (char ch : newTestUser.getLastName().toCharArray()) {
        lastName.sendKeys(String.valueOf(ch));
        Thread.sleep(100);
    }
        dateOfBirthSelection();

        eMail.sendKeys(newTestUser.getEmail());
        Thread.sleep(600);
        company.sendKeys(newTestUser.getCompany());
        Thread.sleep(300);
        password.sendKeys(newTestUser.getPassword());
        Thread.sleep(200);
        confirmPassword.sendKeys(newTestUser.getPassword());
        Thread.sleep(400);
        }

    public void enteringIncorrectDataInTheFirstNameField (String incorrectDataFirstName) throws InterruptedException {
        User newTestUser = DataHelper.createNewTestUser();
        genderFemale.click();
        firstName.sendKeys(incorrectDataFirstName);
        Thread.sleep(800);
        for (char ch : newTestUser.getLastName().toCharArray()) {
            lastName.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        dateOfBirthSelection();

        eMail.sendKeys(newTestUser.getEmail());
        Thread.sleep(900);
        company.sendKeys(newTestUser.getCompany());
        Thread.sleep(600);
        password.sendKeys(newTestUser.getPassword());
        Thread.sleep(200);
        confirmPassword.sendKeys(newTestUser.getPassword());
        Thread.sleep(400);
    }

    public void enteringIncorrectDataInTheLastNameField (String incorrectDataLastName) throws InterruptedException {
        User newTestUser = DataHelper.createNewTestUser();
        genderMale.click();
        for (char ch : newTestUser.getFirstName().toCharArray()) {
            firstName.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        lastName.sendKeys(incorrectDataLastName);
        Thread.sleep(500);

        dateOfBirthSelection();

        eMail.sendKeys(newTestUser.getEmail());
        Thread.sleep(900);
        company.sendKeys(newTestUser.getCompany());
        Thread.sleep(600);
        password.sendKeys(newTestUser.getPassword());
        Thread.sleep(300);
        confirmPassword.sendKeys(newTestUser.getPassword());
        Thread.sleep(400);
    }

    public void enteringIncorrectEmailField (String incorrectEmail) throws InterruptedException {
        User newTestUser = DataHelper.createNewTestUser();
        genderFemale.click();
        firstName.sendKeys(newTestUser.getFirstName());
        Thread.sleep(600);
        for (char ch : newTestUser.getLastName().toCharArray()) {
            lastName.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        dateOfBirthSelection();

        eMail.sendKeys(incorrectEmail);
        Thread.sleep(700);
        company.sendKeys(newTestUser.getCompany());
        Thread.sleep(500);
        password.sendKeys(newTestUser.getPassword());
        Thread.sleep(300);
        confirmPassword.sendKeys(newTestUser.getPassword());
        Thread.sleep(500);
    }

    public void enteringIncorrectPasswordField (String incorrectPassword) throws InterruptedException {
        User newTestUser = DataHelper.createNewTestUser();
        genderMale.click();
        firstName.sendKeys(newTestUser.getFirstName());
        Thread.sleep(600);
        for (char ch : newTestUser.getLastName().toCharArray()) {
            lastName.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        dateOfBirthSelection();

        eMail.sendKeys(newTestUser.getEmail());
        Thread.sleep(700);
        company.sendKeys(newTestUser.getCompany());
        Thread.sleep(500);
        for (char ch : incorrectPassword.toCharArray()) {
            password.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
        confirmPassword.sendKeys(incorrectPassword);
        Thread.sleep(500);
    }

    public void dateOfBirthSelection (){
        Random random = new Random();
        Select selectDay = new Select(dateOfBirthDay);
        selectDay.selectByVisibleText(String.valueOf(random.nextInt(30) + 1));
        Select selectMonth = new Select(dateOfBirthMonth);
        String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
                "Oktober", "November", "Dezember"};
        selectMonth.selectByVisibleText(months[random.nextInt(months.length)]);
        int currentYear = Year.now().getValue();
        int randomYear = 1914 + random.nextInt(currentYear - 1914 + 1);
        Select selectYear = new Select(dateOfBirthYear);
        selectYear.selectByVisibleText(String.valueOf(randomYear));
    }
}
