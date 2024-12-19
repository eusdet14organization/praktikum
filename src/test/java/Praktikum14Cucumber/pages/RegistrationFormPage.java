package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormPage extends BasePage {

    @FindBy(xpath = "//h1[@class='h3 text-light mb-0']")
    public WebElement titleH1;

    @FindBy(xpath = "//*[@id='gender']")
    public WebElement gender;

    @FindBy(xpath = "//*[@id='gender-male']")
    public WebElement genderMale;

    @FindBy(xpath = "//*[@id='gender-female']")
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

    public void verifyFormFields(List<String> namesOfField) {
        List<String> actualFieldNames = fieldNames.stream()
                                                .map(WebElement::getText)
                                                .toList();

        for (String expectedNameOfField : namesOfField) {
            assertTrue(actualFieldNames.contains(expectedNameOfField),
                    "Поле '" + expectedNameOfField + "' отсутствует на странице!");
        }
    }
}
