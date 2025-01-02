@ignored
Feature:FooterFunctionality

  Background:
    Given The user is on the main page


  Scenario Outline:Transition to pages via links from the footer,
  German version of the site, which do not require authorization.
    When The user click on "DE" in the top menu
    And The user clicks '<Link Title>' in the footer of the site
    Then The user checks that the '<Page title>' matches

    Examples:
      | Link Title         | Page title               |
      | Shipping & returns | Shipping & returns       |
      | Privacy notice     | Privacy notice           |
      | Conditions of Use  | Conditions of Use        |
      | Über Uns           | Über Uns                 |
      | Kontakt            | Kontakt aufnehmen        |
      | Suchen             | Suchen                   |
      | Kürzlich angesehen | Kürzlich angesehen       |
      | Produkte           | Produkte                 |
      | Warenkorb          | Warenkorb                |
      | Mein Konto         | Wiederkehrender Benutzer |
      | Aufträge           | Wiederkehrender Benutzer |
      | Adressen           | Wiederkehrender Benutzer |


  Scenario Outline:Transition to pages via links from the footer,
  English version of the site, which do not require authorization.
    When The user click on "EN" in the top menu
    And The user clicks '<Link Title>' in the footer of the site
    Then The user checks that the '<Page title>' matches

    Examples:
      | Link Title               | Page title               |
      | Shipping & returns       | Shipping & returns       |
      | Privacy notice           | Privacy notice           |
      | Conditions of Use        | Conditions of Use        |
      | About us                 | About us                 |
      | Contact us               | Contact Us               |
      | Search                   | Search                   |
      | Recently viewed products | Recently viewed products |
      | New products             | New products             |
      | Shopping cart            | Shopping Cart            |
      | My account               | Returning Customer       |
      | Orders                   | Returning Customer       |
      | Addresses                | Returning Customer       |


  Scenario Outline:Transition to pages via links from the footer,
  German version of the site, that require authorization.

    When The user click on "DE" in the top menu
    And The user is logged by "testEmail2" and "testPassword2"
    And The user clicks '<Link Title>' in the footer of the site
    Then The user checks that the '<Page title>' matches

    Examples:
      | Link Title | Page title  |
      | Mein Konto | Kunden-Info |
      | Aufträge   | Aufträge    |
      | Adressen   | Kunden-Info |


  Scenario Outline:Transition to pages via links from the footer,
  English version of the site, that require authorization.

    When The user click on "EN" in the top menu
    And The user is logged by "testEmail3" and "testPassword3"
    And The user clicks '<Link Title>' in the footer of the site
    Then The user checks that the '<Page title>' matches

    Examples:
      | Link Title | Page title    |
      | My account | Customer info |
      | Orders     | Orders        |
      | Addresses  | Customer info |


  Scenario:Checking subscription activation from the footer, German version of the site, for the correct Email.
    When The user click on "DE" in the top menu
    And The user enters an Email in the subscription field
    And The user click Subscribe button
    Then The user sees the 'messageNewLetterDE'


  Scenario Outline:Checking subscription activation from the footer, German version of the site, for the wrong Email.
    When The user click on "DE" in the top menu
    And The user enters an '<Email>' in the subscription field
    And The user click Subscribe button
    Then The user sees the '<Message>'

    Examples:
      | Email      | Message               |
      | badEmail   | badMessageNewLetterDE |
      |            | badMessageNewLetterDE |


  Scenario:Checking subscription activation from the footer, English version of the site, for the correct Email.
    When The user click on "EN" in the top menu
    And The user enters an Email in the subscription field
    And The user click Subscribe button
    Then The user sees the 'messageNewLetterEN'

  Scenario Outline:Checking subscription activation from the footer, English version of the site,for the wrong Email..
    When The user click on "EN" in the top menu
    And The user enters an '<Email>' in the subscription field
    And The user click Subscribe button
    Then The user sees the '<Message>'

    Examples:
      | Email      | Message               |
      | badEmail   | badMessageNewLetterEN |
      |            | badMessageNewLetterEN |