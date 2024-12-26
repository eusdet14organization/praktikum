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
        compositeProductPage.checkThatTheSuccessBarIsAppears();
    }
    @And("The user clicks on the button buy")
    public void clickOnTheBuyButtonOnTheFirstCard(){
        compositeProductPage.clickOnKaufenButton();
    }
    @And ("The user clicks on the button Check out")
    public void clickOnCheckOutButton(){
        shoppingCartPage.clickOnKaufenCheckOutButton();
    }



    @And("The user clicks on the button next step on the shipping cart")
    public void theUserClicksOnTheButtonNextStepOnTheShippingCart() {
        checkOutPage.clickOnTheButtonNextStepShippingCard();
    }

    @And("The user clicks on the button next step on the payment method cart")
    public void theUserClicksOnTheButtonNextStepOnThePaymentMethodCart() {
        checkOutPage.clickOnTheButtonNextStepPaymentCard();
    }

    @And("The user clicks on the button next step on the confirmation cart")
    public void theUserClicksOnTheButtonNextStepOnTheConfirmationCart() {
        checkOutPage.clickOnTheButtonNextStepOrderConfirmation();

    }

    @Then("The user should see the success text on the top of the page")
    public void theUserShouldSeeTheSuccessTextOnTheTopOfThePage() {
        WebDriverWait wait = TestContext.getWait();
        wait.until(ExpectedConditions.visibilityOf(confirmationPage.conformationTextOnTheCenterOnThePage));
        confirmationPage.checkTheTextOnThePage();
    }

    @And("The user should see the success text in the middle on the page")
    public void theUserShouldSeeTheSuccessTextInTheMiddleOnThePage() {
        confirmationPage.checkTheTextOfSuccessOrderIsDisplayed();
    }

    @And("The order conformation button is displayed")
    public void theOrderConformationButtonIsDisplayed() {
        confirmationPage.checkIfTheButtonOfOrderDetailsIsPresent();
    }


    @And("The user selects an invoicing address with the {string}")
    public void theUserSelectsAnInvoicingAddressWithThe(String customerName) {
        Select selectAddress = new Select(checkOutPage.selectAddress);
        String nameFromConF = ConfigurationReader.get(customerName);
        if (nameFromConF.isEmpty()) {
            selectAddress.selectByVisibleText(customerName);
        }else selectAddress.selectByVisibleText(nameFromConF);

        checkOutPage.clickOnButtonNextStepInvoicingcard();
    }
}
