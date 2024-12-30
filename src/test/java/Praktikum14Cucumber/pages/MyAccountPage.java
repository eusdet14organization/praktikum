package Praktikum14Cucumber.pages;


import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Praktikum14Cucumber.context.TestContext.getActions;
import static Praktikum14Cucumber.context.TestContext.getWait;

public class MyAccountPage extends BasePage {
    //Returning Customer page
    @FindBy(xpath = "//h1[@class='h3 text-light mb-0']")
    public WebElement titleH1;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='RememberMe']")
    public WebElement rememberMe;

    @FindBy(xpath = "//div[@class='d-flex flex-wrap justify-content-between']/a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary col-12']")
    public WebElement logInButton;

    @FindBy(xpath = "//button[@class='btn btn-success col-12']")
    public WebElement registerButton;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement logOutButton;


    public void clickOnLogInButton() throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(logInButton));
        getActions().moveToElement(logInButton).click().perform();
        Thread.sleep(400);
    }

    public void fillOutTheLogInFormWithData(String email, String passwordIn) throws InterruptedException {

        for (char ch : ConfigurationReader.get(email).toCharArray()) {
            eMail.sendKeys(String.valueOf(ch));
            Thread.sleep(500);
        }
        for (char ch : ConfigurationReader.get(passwordIn).toCharArray()) {
            password.sendKeys(String.valueOf(ch));
            Thread.sleep(400);
        }
    }



    public void getTextTitel () {
        titleH1.isDisplayed();
    }
}
