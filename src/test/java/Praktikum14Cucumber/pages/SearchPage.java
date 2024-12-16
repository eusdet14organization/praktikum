package Praktikum14Cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Praktikum14Cucumber.context.TestContext.getDriver;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//div[@id='SearchButton']")
    public WebElement searchButtonM;

    @FindBy(xpath = "//input[@class='search-text form-control']")
    public WebElement fieldInputSearch;

    @FindBy(xpath = "//label[@class='custom-control-label'][text()='Erweiterte Suche']")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "//select[@class='form-control custom-select']")
    public WebElement selectCategorySearch;

    @FindBy(xpath = "//label[@class='custom-control-label'][text()='Automatically search sub categories']")
    public WebElement subCategoriesSearchButton;

    @FindBy(xpath = "//label[@class='custom-control-label'][text()='Search In product descriptions']")
    public WebElement descriptionsSearchButton;

    public WebElement getAdvancedSearchMenu(String nameAdvancedOption) {
        return getDriver().findElement(By.xpath(
                String.format("//label[@class='custom-control-label'][text()='%s']", nameAdvancedOption)));
    }

    @FindBy(xpath = "//i[@class='czi-search mr-1']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='card']")
    public List<WebElement> listProduct;

    @FindBy(xpath = "//div[@class='card']//h5[@class='product-title']/a[text()]")
    public List<WebElement> nameProduct;

    @FindBy(xpath = "//div[@class='card']//div[@class='description'][text()]")
    public List<WebElement> descriptionProduct;

}
