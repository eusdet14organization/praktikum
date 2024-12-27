package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.pages.CheckOutPage;
import Praktikum14Cucumber.pages.CompositeProductPage;
import Praktikum14Cucumber.pages.PurchaseConfirmationPage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Praktikum14Cucumber.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseSteps {

    CompositeProductPage compositeProductPage = new CompositeProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    PurchaseConfirmationPage confirmationPage = new PurchaseConfirmationPage();




    @And(" The user clicks on the button buy")
    public void theUserClickOnTheBuyButtonInTheFirstCart() {
        compositeProductPage.checkIfTheFirstCardIsAvailable();
        compositeProductPage.clickOnKaufenButton();
    }

    @And("The user should see the success adding the product on the cart")
    public void theSuccessTextIsAppears() {
        compositeProductPage.successBarNotification.isDisplayed();
    }
    @And("The user clicks on the button buy")
    public void clickOnTheBuyButtonOnTheFirstCard(){
        compositeProductPage.buttonKaufenCardKaiserBulk.click();
    }
    @And ("The user clicks on the button Check out")
    public void clickOnCheckOutButton(){
        shoppingCartPage.checkOutButton.click();
    }



    @And("The user clicks on the button next step on the shipping cart")
    public void theUserClicksOnTheButtonNextStepOnTheShippingCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(checkOutPage.nextStepButtonInTheShippingCard));
        checkOutPage.nextStepButtonInTheShippingCard.click();
    }

    @And("The user clicks on the button next step on the payment method cart")
    public void theUserClicksOnTheButtonNextStepOnThePaymentMethodCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(checkOutPage.nextStepButtonInThePaymentCard));
        checkOutPage.nextStepButtonInThePaymentCard.click();
    }

    @And("The user clicks on the button next step on the confirmation cart")
    public void theUserClicksOnTheButtonNextStepOnTheConfirmationCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(checkOutPage.nextStepButtonOrderConfirmation));
        checkOutPage.nextStepButtonOrderConfirmation.click();
    }

    @Then("The user should see the success text on the top of the page")
    public void theUserShouldSeeTheSuccessTextOnTheTopOfThePage() {
        getWait().until(ExpectedConditions.visibilityOf(confirmationPage.conformationTextOnTheCenterOnThePage));
        assertEquals(ConfigurationReader.get("messageSuccessOrder"),
                confirmationPage.conformationTextOnTheCenterOnThePage.getText());
    }

    @And("The user should see the success text in the middle on the page")
    public void theUserShouldSeeTheSuccessTextInTheMiddleOnThePage() {
        assertTrue(confirmationPage.confirmationTextOnTheTopOnThePage.isDisplayed());
    }

    @And("The order conformation button is displayed")
    public void theOrderConformationButtonIsDisplayed() {
        assertTrue(confirmationPage.orderDetailsButton.isDisplayed());
    }


    @And("The user selects an invoicing address with the {string}")
    public void theUserSelectsAnInvoicingAddressWithThe(String customerName) {
        Select selectAddress = new Select(checkOutPage.selectAddress);
        selectAddress.selectByVisibleText(ConfigurationReader.get(customerName));

        checkOutPage.nextStepButtonInTheInvoicingCard.click();

    }
}
