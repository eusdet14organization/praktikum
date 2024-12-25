package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//h1[@class='h3 text-light mb-0'][text()]")
    public WebElement namePage;

    @FindBy(xpath = "//li[@class='breadcrumb-item text-nowrap active'][text()]")
    public WebElement nameActivePage;

    @FindBy(xpath = "//div[@class='widget']/h6/a[text()]")
    public List<WebElement> listNameProductInCart;

    @FindBy(xpath = "//select[@class='form-control custom-select MctCartQtyDrp']")
    public List<WebElement> listSelectAmountProduct;

    @FindBy(xpath = "//div[@class='m-2']")
    public List<WebElement> listDeleteProductButton;

    @FindBy(xpath = "//button[@id='BtnConfirmOk']")
    public List<WebElement> listConfirmDeleteProductButton;

}
