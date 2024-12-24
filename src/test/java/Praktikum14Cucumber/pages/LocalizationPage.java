package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalizationPage extends BasePage{

    @FindBy(xpath = "//img[@title='DE']")
    public WebElement germanLanguageTitle;

    @FindBy(xpath = "//img[@title='EN']")
    public WebElement englishLanguageTitle;

    @FindBy(xpath = "//a[@class='nav-link' and contains(text(), 'Startseite')]")
    public WebElement startSeite;

    @FindBy(xpath = "//input[@class='form-control appended-form-control ui-autocomplete-input']")
    public WebElement searchField;

    @FindBy(xpath = "//span[text()='Kürzlich angesehen']")
    public WebElement recentlyViewed;



}
