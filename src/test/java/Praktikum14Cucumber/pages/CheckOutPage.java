package Praktikum14Cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckOutPage extends BasePage{

    @FindBy(xpath = "//*[@id='BillingNewAddress_CountryId']/option[@value='84']")
    public WebElement selectGermanyCountry;

    @FindBy(xpath = "//*[@id='BillingNewAddress_StateProvinceId']/option[@value='347']")
    public WebElement selectBayernProvince;

    @FindBy(xpath = "//*[@id='BillingNewAddress_City']")
    public WebElement inputFieldCity;

    @FindBy(xpath = "//*[@id='BillingNewAddress_Address1']")
    public WebElement inputFieldStreet;

    @FindBy(xpath = "//*[@id='BillingNewAddress_ZipPostalCode']")
    public WebElement inputFieldZip;

    @FindBy(xpath = "//*[@id='BillingNewAddress_PhoneNumber']")
    public WebElement inputFieldPhoneNumber;

    @FindBy(xpath = "//button[@class='button-2 btn btn-primary']")
    public WebElement nextStepButtonInTheInvoicingCard;

    @FindBy(xpath = "//*[@id='BillingNewAddress_StateProvinceId']")
    public WebElement stateProvinceInputField;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//button[@class='btn btn-primary']")
    public WebElement nextStepButtonInTheShippingCard;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//button[@class='btn btn-primary']")
    public WebElement nextStepButtonInThePaymentCard;

    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']//button[@class='btn btn-primary']")
    public WebElement nextStepButtonOrderConfirmation;

    @FindBy(xpath = "//select[@id='billing-address-select']")
    public WebElement selectAddress;
    @FindBy(xpath = "//span[@data-valmsg-for='BillingNewAddress.City']")
    public WebElement cityRequiredErrorMessage;


}
