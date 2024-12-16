package Praktikum14Cucumber.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
@FindBy(xpath = "//a[@class='navbar-brand d-none d-sm-block mr-3 flex-shrink-0']/img[@title='Dr Muller']")
public WebElement companyLogo;


}
