package Praktikum14Cucumber.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    //Returning Customer page
    @FindBy(xpath = "#Email")
    public WebElement eMail;

    @FindBy(xpath = "#Password")
    public WebElement password;

    @FindBy(xpath = "#RememberMe")
    public WebElement rememberMe;

    @FindBy(xpath = "//div[@class='d-flex flex-wrap justify-content-between']/a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary col-12']")
    public WebElement logInButton;

    @FindBy(xpath = "//button[@class='btn btn-success col-12']")
    public WebElement registerButton;
}
