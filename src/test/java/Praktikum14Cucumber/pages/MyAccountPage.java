package Praktikum14Cucumber.pages;

import Praktikum14Cucumber.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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


    public void fillOutTheLogInFormWithData(String email, String passwordIn) throws InterruptedException {

        for (char ch : ConfigurationReader.get(email).toCharArray()) {
            eMail.sendKeys(String.valueOf(ch));
            Thread.sleep(200);
        }
        for (char ch : ConfigurationReader.get(passwordIn).toCharArray()) {
            password.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        Thread.sleep(1000);
    }

    public void getTextTitel () {
        titleH1.isDisplayed();
    }

}
