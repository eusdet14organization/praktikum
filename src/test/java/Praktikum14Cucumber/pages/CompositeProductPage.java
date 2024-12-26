package Praktikum14Cucumber.pages;


import Praktikum14Cucumber.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompositeProductPage extends BasePage {

    @FindBy(xpath = "//div[@data-productid='4']")
    public WebElement firstCartKaiserBulk;

    @FindBy(xpath = "//div[@data-productid='4']//div[@class='buttons']")
    public WebElement buttonKaufenCardKaiserBulk;

    @FindBy(xpath = "//div[@class='bar-notification success']")
    public WebElement successBarNotification;


    public void checkIfTheFirstCardIsAvailable() {
        assertTrue(firstCartKaiserBulk.isDisplayed());
    }

    public void clickOnKaufenButton() {
        buttonKaufenCardKaiserBulk.click();
    }

    public String checkTheCurrentPageUrl() {
        return TestContext.getDriver().getCurrentUrl();
    }
    public void checkThatTheSuccessBarIsAppears(){
        successBarNotification.isDisplayed();
    }

}
