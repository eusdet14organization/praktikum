package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    @FindBy(xpath = "//h3[text()='Address']")
    public WebElement address;

    @FindBy(xpath = "//h3[text()='WhatsApp']")
    public WebElement whatsApp;

    @FindBy(xpath = "//h3[text()='Phone']")
    public WebElement phone;

    @FindBy(xpath = "//h3[text()='Email addresses']")
    public WebElement emailAddresses;

    @FindBy(xpath = "//div[@class=\"form-fields\"]")
    public WebElement formFields;

    @FindBy(xpath = "//label[text()='Ihr Name : ']")
    public WebElement name;

    @FindBy(xpath = "//label[text()='Ihre E-Mail : ']")
    public WebElement email;

    @FindBy(xpath = "//label[text()='Betreff : ']")
    public WebElement theme;

    @FindBy(xpath = "//label[text()='Anfrage : ']")
    public WebElement request;

    @FindBy(xpath = "//button[@name='send-email']")
    public WebElement submitButton;



}
