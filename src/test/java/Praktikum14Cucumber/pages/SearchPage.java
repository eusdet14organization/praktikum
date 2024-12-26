package Praktikum14Cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Praktikum14Cucumber.context.TestContext.getDriver;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//div[@id='SearchButton']")
    public WebElement searchNavMenuButton;

    @FindBy(xpath = "//input[@class='search-text form-control']")
    public WebElement fieldInputSearch;

    @FindBy(xpath = "//select[@class='form-control custom-select']")
    public WebElement selectCategorySearch;

    public WebElement getAdvancedSearchMenu(String nameAdvancedOption) {
        return getDriver().findElement(By.xpath(
                String.format("//label[@class='custom-control-label'][text()='%s']", nameAdvancedOption)));
    }

    @FindBy(xpath = "//i[@class='czi-search mr-1']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='text-center p-3 mt-5'][text()]")
    public WebElement messageNoProducts;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement messageAddProductToCart;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeMessageButton;

    @FindBy(xpath = "//div[@id='bar-notification']")
    public WebElement windowsNotification;



    @FindBy(xpath = "//div[@class='card']")
    public List<WebElement> listProduct;

    @FindBy(xpath = "//div[@class='picture']")
    public List<WebElement> listPictureProduct;

    @FindBy(xpath = "//div[@class='card']//h5[@class='product-title']/a[text()]")
    public List<WebElement> listNameProduct;

    @FindBy(xpath = "//div[@class='card']//div[@class='description'][text()]")
    public List<WebElement> listDescriptionProduct;

    @FindBy(xpath = "//button[contains(@class,'btn-danger')]")
    public List<WebElement> listAddToCartButton;

    @FindBy(xpath = "//span[@class='h3 font-weight-normal'][text()]")
    public List<WebElement> listPriceProduct;

}
