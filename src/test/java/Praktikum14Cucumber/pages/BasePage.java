package Praktikum14Cucumber.pages;

import Praktikum14Cucumber.context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(TestContext.getDriver(), this);
    }

}
