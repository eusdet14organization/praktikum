
Feature: Contact Methods
  This feature file contains scenarios to validate the functionality of the different contact methods on the website.

  Background:
    Given The user is on the main page

  Scenario: Contact Page Accessibility
  Verify that clicking "Kontakt" opens the contact form page
  Open the Contact page through the main menu
    And The user click on the "Kontakt" in the navigation menu
    Then The user should be redirected to the contact page


  Scenario: Verify Contact Methods
    And The user click on the "Kontakt" in the navigation menu
    Then The user should see '<ContactMethods>' in the contact section


  Scenario: verify Contact Fields of  the Contact Form
    And The user click on the "Kontakt" in the navigation menu
    Then The user should see Contact Form
    And The form should include a Submit button

