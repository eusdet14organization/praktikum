package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalizationPage {

    @FindBy(xpath = "//img[@title='DE']")
    public WebElement germanLanguageTitle;

    @FindBy(xpath = "//img[@title='EN']")
    public WebElement englishLanguageTitle;

    @FindBy(xpath = "//li[@class='nav-item']/a[text()='Startseite']")
    public WebElement startSeite;

}
