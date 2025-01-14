package Praktikum14Cucumber.steps;

import Praktikum14Cucumber.dto.Address;
import Praktikum14Cucumber.pages.CheckOutPage;
import Praktikum14Cucumber.pages.PurchaseConfirmationPage;
import Praktikum14Cucumber.pages.ShoppingCartPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.DataHelper;
import Praktikum14Cucumber.utils.SearchPageHelp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Praktikum14Cucumber.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseSteps {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    PurchaseConfirmationPage confirmationPage = new PurchaseConfirmationPage();
    SearchPageHelp searchPageHelp = new SearchPageHelp();


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


    @And("The order conformation button is displayed")
    public void theOrderConformationButtonIsDisplayed() {
        assertTrue(confirmationPage.orderDetailsButton.isDisplayed());
    }

    @And("The user selects an invoicing address with the {string}")
    public void theUserSelectsAnInvoicingAddressWithThe(String customerName) {
        searchPageHelp.selectSorting(checkOutPage.selectAddress,ConfigurationReader.get(customerName));
        checkOutPage.nextStepButtonInTheInvoicingCard.click();
    }

    @And("The user selects a new invoicing address with the {string}")
    public void theUserSelectsANewInvoicingAddressWithThe(String customerName) {
        searchPageHelp.selectSorting(checkOutPage.selectAddress,ConfigurationReader.get(customerName));
    }

    @And("The user fill out a new shipping address")
    public void theUserfillOutAformForNewShippingAddress(){
        Address newAddress = DataHelper.addressForNewUser();
        checkOutPage.selectGermanyCountry.click();
        checkOutPage.selectBayernProvince.click();
        checkOutPage.inputFieldCity.sendKeys(newAddress.getCity());
        checkOutPage.inputFieldStreet.sendKeys(newAddress.getStreet());
        checkOutPage.inputFieldZip.sendKeys(newAddress.getZipCode());
        checkOutPage.inputFieldPhoneNumber.sendKeys(newAddress.getPhoneNumber());
        checkOutPage.nextStepButtonInTheInvoicingCard.click();
    }

    @And ("The user fill out a mew shipping address without city name")
    public void theUserfillOutAformForNewShippingAddressWithoutCity(){
        Address newAddress = DataHelper.addressForNewUser();
        checkOutPage.selectGermanyCountry.click();
        checkOutPage.selectBayernProvince.click();
        checkOutPage.inputFieldStreet.sendKeys(newAddress.getStreet());
        checkOutPage.inputFieldZip.sendKeys(newAddress.getZipCode());
        checkOutPage.inputFieldPhoneNumber.sendKeys(newAddress.getPhoneNumber());
        checkOutPage.nextStepButtonInTheInvoicingCard.click();
    }

    @Then("The user should see a required filed error message")
    public void theUserSeesAnErrorMessageCityIsRequired(){
        getWait().until(ExpectedConditions.visibilityOf(checkOutPage.cityRequiredErrorMessage));
        assertEquals(ConfigurationReader.get("messageRequiredCityFieldInCheckOutForm"),
                checkOutPage.cityRequiredErrorMessage.getText());
    }

}
