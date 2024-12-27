package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'page-title-overlap')]//h1[text()]")
    public WebElement titleProduct;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-button')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//select[contains(@class,'custom-select')]")
    public WebElement selectAmountProduct;

    @FindBy(xpath = "//div[@class='short-description'][text()]")
    public WebElement descriptionProduct;

    @FindBy(xpath = "//div[contains(@class,'border-top')]")
    public WebElement tableCharacteristicsAdvantages;

}
