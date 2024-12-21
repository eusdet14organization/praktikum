package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='result alert alert-success']")
    public WebElement successfulRegistration;

    @FindBy(xpath = "//input[@name='register-continue']")
    public WebElement continueAfterReg;
}
