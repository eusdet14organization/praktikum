package Praktikum14Cucumber.pages;


import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait wait = TestContext.getWait();
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        Actions actions = TestContext.getActions();
        actions.moveToElement(logInButton).click().perform();


       // logInButton.click();
        Thread.sleep(2000);
    }

    public void fillOutTheLogInFormWithData() throws InterruptedException {
        for (char ch : ConfigurationReader.get("eMail").toCharArray()) {
            eMail.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        for (char ch : ConfigurationReader.get("password").toCharArray()) {
            password.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
    }



    public void getTextTitel () {
        titleH1.isDisplayed();
    }
}
