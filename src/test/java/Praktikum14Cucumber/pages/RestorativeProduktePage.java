package Praktikum14Cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Praktikum14Cucumber.context.TestContext.getDriver;

public class RestorativeProduktePage extends BasePage{

    @FindBy(xpath = "//h5[@class='product-title']")
    public List<WebElement> productsTitle;

    public WebElement selectTheLeftMenuItem(String nameLeftMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//li[@class='border-bottom mb-0']//a[text()=' %s ']",nameLeftMenu)));
    }

    public WebElement selectTheCenterMenuItem(String nameCenterMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//h3[@class='h3 title'][text()='%s']",nameCenterMenu)));
    }
}
