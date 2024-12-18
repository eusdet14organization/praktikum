package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends BasePage {

    @FindBy(xpath = "#gender")
    public WebElement gender;

    @FindBy(xpath = "#gender-male")
    public WebElement genderMale;

    @FindBy(xpath = "#gender-female")
    public WebElement genderFemale;

    @FindBy(xpath = "#FirstName")
    public WebElement firstName;

    @FindBy(xpath = "#LastName")
    public WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement dateOfBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement dateOfBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement dateOfBirthYear;

    @FindBy(xpath = "#Email")
    public WebElement eMail;

    @FindBy(xpath = "#Company")
    public WebElement company;

    @FindBy(xpath = "#Newsletter")
    public WebElement newsLetter;

    @FindBy(xpath = "#Password")
    public WebElement password;

    @FindBy(xpath = "#ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(xpath = "#register-button")
    public WebElement registerButton;
}
