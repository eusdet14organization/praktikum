package Praktikum14Cucumber.steps;


import Praktikum14Cucumber.pages.MyAccountPage;
import Praktikum14Cucumber.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyAccountPageSteps {
    MyAccountPage accountPage = new MyAccountPage();


    @Then("The user has successfully logged")
    public void theUserIsLogged() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(accountPage.logOutButton.isDisplayed());
    }

    @And("The user filling out the login form with email {string} and password {string}")
    public void fillingOutTheLoginForm(String userEmail, String userPassword) throws InterruptedException {
        accountPage.fillOutTheLogInFormWithData(userEmail,userPassword);
    }
    @And ("The user should see the title on the Log in page")
    public void getTextFromLogInPage(){
        accountPage.getTextTitel();
    }
    @And ("The user click on Log in button")
    public void onLogInButnClick() throws InterruptedException {
        accountPage.clickOnLogInButton();
    }

    @And("The user filling {string} and {string} out the login form")
    public void theUserFillingAndOutTheLoginForm(String email, String password) throws InterruptedException {
        for (char ch : ConfigurationReader.get(email).toCharArray()) {
            accountPage.eMail.sendKeys(String.valueOf(ch));
            Thread.sleep(2000);
        }
        for (char ch : ConfigurationReader.get(password).toCharArray()) {
            accountPage.password.sendKeys(String.valueOf(ch));
            Thread.sleep(2000);
        }
    }
}
