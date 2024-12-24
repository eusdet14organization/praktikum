package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//h1[@class='h3 text-light mb-0'][text()]")
    public WebElement namePage;

    @FindBy(xpath = "//li[@class='breadcrumb-item text-nowrap active'][text()]")
    public WebElement nameActivePage;

}
