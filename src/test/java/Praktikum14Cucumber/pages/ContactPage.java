package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    @FindBy(xpath = "//li[@class='nav-item']/a[text()='Kontakt']")
    public WebElement kontaktButton;

    @FindBy(xpath = "//p[@class='fs-sm text-muted']")
    public WebElement contactAddress;

    @FindBy(xpath = "//button[@type='submit' and text()=' Absenden ' ]")
    public WebElement submitButton;

}
