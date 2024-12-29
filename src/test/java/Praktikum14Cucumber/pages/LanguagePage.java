package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguagePage extends BasePage{

    @FindBy(xpath = "//img[@title='DE']")
    public WebElement germanLanguageTitle;

    @FindBy(xpath = "//img[@title='EN']")
    public WebElement englishLanguageTitle;

    @FindBy(xpath = "//a[@class='nav-link' and contains(text(), 'Startseite')]")
    public WebElement startSeite;

    @FindBy(xpath = "//input[@class='form-control appended-form-control ui-autocomplete-input']")
    public WebElement searchField;

    @FindBy(xpath = "//span[@class='badge badge-secondary w-100 p-2 mb-2 font-size-lg']")
    public WebElement nameOfHeaderOfCategoryPage;


}
