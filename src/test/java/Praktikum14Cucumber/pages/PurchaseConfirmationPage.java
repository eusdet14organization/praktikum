package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PurchaseConfirmationPage extends BasePage {

    @FindBy(xpath = "//div[@class='title'][strong[text()='Ihr Auftrag wurde erfolgreich übermittelt.']]")
    public WebElement conformationTextOnTheCenterOnThePage;

    @FindBy(xpath = "//div[@class='text-sm-center mt-3']")
    public WebElement orderDetailsButton;


}
