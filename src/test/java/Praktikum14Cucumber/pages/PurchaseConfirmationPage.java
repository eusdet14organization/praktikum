package Praktikum14Cucumber.pages;

import Praktikum14Cucumber.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseConfirmationPage extends BasePage {
    @FindBy(xpath = "//h1[@class='c']")
    public WebElement confirmationTextOnTheTopOnThePage;

    @FindBy(xpath = "//div[@class='title']")
    public WebElement conformationTextOnTheCenterOnThePage;

    @FindBy(xpath = "//div[@class='text-sm-center mt-3']")
    public WebElement orderDetailsButton;

    public void checkTheTextOnThePage(){
        assertEquals(ConfigurationReader.get("messageSuccessOrder"),conformationTextOnTheCenterOnThePage.getText());
    }

    public void checkTheTextOfSuccessOrderIsDisplayed(){
        assertTrue(confirmationTextOnTheTopOnThePage.isDisplayed());
    }

    public void clickOnTheOrderDetailsButton(){
        orderDetailsButton.click();
    }

    public void checkIfTheButtonOfOrderDetailsIsPresent(){
        assertTrue(orderDetailsButton.isDisplayed());
    }


}
