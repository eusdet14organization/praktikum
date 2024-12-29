package Praktikum14Cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Praktikum14Cucumber.context.TestContext.getDriver;

public class RestorativeProduktePage extends BasePage{

    public WebElement selectTheLeftMenuItem(String nameLeftMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//li[@class='border-bottom mb-0']//a[text()=' %s ']",nameLeftMenu)));
    }

    public WebElement selectTheCenterMenuItem(String nameCenterMenu) {
        return getDriver().findElement(By.xpath(
                String.format("//h3[@class='h3 title'][text()='%s']",nameCenterMenu)));
    }
}
