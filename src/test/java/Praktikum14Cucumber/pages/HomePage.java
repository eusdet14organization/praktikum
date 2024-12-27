package Praktikum14Cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Praktikum14Cucumber.context.TestContext.getDriver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'d-none')]/img[@title='Dr Muller']")
    public WebElement companyLogo;

    @FindBy(xpath = "//a[@class='topbar-link']")
    public WebElement linkWhatsApp;

    @FindBy(xpath = "//a[@class='ml-1']/img[@title='DE']")
    public WebElement switchLanguageDE;

    @FindBy(xpath = "//a[@class='ml-1']/img[@title='EN']")
    public WebElement switchLanguageEN;

    @FindBy(xpath = "//*[@id='small-searchterms']")
    public WebElement fieldSearch;

    @FindBy(xpath = "//div[contains(@class,'ml-n3')]")
    public WebElement loginUser;

   //Navigation Menu

    public WebElement getMeinMenu(String nameMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//li[@class='nav-item']/a[text()='%s']", nameMenu)));
    }

    @FindBy(xpath = "//li[@class='dropdown']/a[text()='Restorative Produkte']")
    public WebElement menuRestorativeProdukte;

    public WebElement getDropMenuRestorativeProdukte(String nameDropMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//ul[@class='dropdown-menu']//a[text()='%s']", nameDropMenu)));
    }

    //Center Menu

    public WebElement getCenterMenu(String nameCenterMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//div[@class='text-center m-3']/h3[text()='%s']", nameCenterMenu)));
    }

    //Footer

    public WebElement getFooterMenu(String nameFooterMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//li[@class='widget-list-item']/a[text()='%s']", nameFooterMenu)));
    }

    @FindBy(xpath = "//input[@id='newsletter-email']")
    public WebElement inputEmailSubscriptionField;

    @FindBy(xpath = "//input[@id='newsletter-subscribe-button']")
    public WebElement newsletterSubscribeButton;

    //CartMenu
    @FindBy(xpath = "//div[@id='flyout-cart']/a[contains(@class, 'navbar-tool-icon-box')]")
    public WebElement imagesCart;

    @FindBy(xpath = "//div[@id='flyout-cart']/a[contains(@class, 'navbar-tool-text')]")
    public WebElement toCartButton;

    @FindBy(xpath = "//span[@class='navbar-tool-label'][text()]")
    public WebElement amountProductInCart;

    @FindBy(xpath = "//a[@class='navbar-tool-text'][text()]")
    public WebElement sumProductInCart;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm'][text()='Zum Warenkorb']")
    public WebElement dropDownMenuGoToCartButton;

    @FindBy(xpath = "//span[@class='text-accent font-size-base ml-1'][text()]")
    public WebElement getDropDownMenuSum;

    @FindBy(xpath = "//a[@class='d-block mr-2']/img[@alt]")
    public List<WebElement> nameProductInCart;


}
