
Feature: Contact Methods
  This feature file contains scenarios to validate the functionality of the different contact methods on the website.

  Background:
    Given The user is on the main page

  Scenario: Contact Page Accessibility
  Verify that clicking "Kontakt" opens the contact form page
  Open the Contact page through the main menu
    And The user click on the "Kontakt" in the navigation menu
    Then The user should be redirected to the contact page


  Scenario Outline: Verify Contact Methods
    And The user click on the "Kontakt" in the navigation menu
    Then The user should see "<ContactMethods>" in the contact section
    Examples:
      | ContactMethods  |
      | Address         |
      | WhatsApp        |
      | Phone           |
      | Email addresses |
      | form-fields     |


  Scenario Outline: verify Contact Fields of  the Contact Form
    And The user click on the "Kontakt" in the navigation menu
    Then The user should see "<Contact Form>"
    Examples:
      | Contact Form  |
      | Ihr Name :    |
      | Ihre E-Mail : |
      | Betreff :     |
      | Anfrage :     |
    And The form should include a Submit button








