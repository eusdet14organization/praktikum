@ignored
Feature: Search Functionality
  Background:
    Given The user is on the main page

  Scenario Outline:Search for products using the search field on the Home page
    When The user enters the name or part the name of the '<Product>' in the search field  auf Home Page.
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |
      | Kaiser Flowable Composite |
      | Muller Bleach Office 35%  |
      | Nord Liner                |
      | Nord Faste                |



  Scenario Outline:Search for products via search page
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                               |
      | Muller Gingiva Protector              |
      | Nord Gel 4 X 1,2 ml                   |
      | Terra Root Cem Viscous 8 g Kartusche  |
      | Nord Bonding                          |



  Scenario Outline:Advanced search for products by description
    And The user go to Search Page
    When The user enters the name or part the name of the '<Description>' in the search field.
    And The user marks the field "Erweiterte Suche"
    And The user marks the field "In den Produktbeschreibungen suchen"
    And The user click Search
    Then The user sees in the products the '<Description>' he was looking for.
    Examples:
      | Description           |
      | Resin Cement          |
      | amalgams and porcelain|
      | cementation of crowns |
      | during chairside      |


  Scenario Outline:Advanced search for products by Category
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user marks the field "Erweiterte Suche"
    When The user selects a product '<Category>'
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |Category                                |
      | Kaiser Flowable Composite |Restorative Produkte >> Composite       |
      | Nord Faste                |Restorative Produkte >> Prophy Materials|
      | Adler Selective Etch Bond |Restorative Produkte >> Bonding         |
      | Kaiser Flowable Composite |Restorative Produkte                    |


  Scenario Outline:Advanced search for products by Category
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user marks the field "Erweiterte Suche"
    When The user selects a product '<Category>'
    And The user marks the field "Unterkategorien einbeziehen"
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product    |Category                            |
      | Kaiser     |Restorative Produkte >> Composite   |
      | Bleaching  |Restorative Produkte >> Bleaching   |


  Scenario Outline:Transition to the product page from search results from the Home page
    When The user enters the name or part the name of the '<Product>' in the search field  auf Home Page.
    And The user goes to the product page.
    Then The user sees the page of the selected '<Product>'.

    Examples:
      | Product                                                 |
      | Kaiser Flowable Composite                               |
      | Kaiser Flowable Composite Medium 2 X 2g Syringe-Spritze |
      | Nord Liner 4 X 2.5 gr                                   |
      | Nord Gel                                                |


  Scenario Outline:Transition to the product page from search results from the Search Page
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user click Search
    And The user goes to the product page.
    Then The user sees the page of the selected '<Product>'.

    Examples:
      | Product                        |
      | One Patient Bleaching Kit      |
      | Kaiser Nano Komposite Compules |
      | Total Etching Gel              |
      | Nord Bonding LC Adhesive       |


  Scenario Outline:Entering a product that is not on the site in the search field on the Home page
    When The user enters the name or part the name of the '<BadProduct>' in the search field  auf Home Page.
    Then The user sees the "messageNoProducts".
    Examples:
      | BadProduct    |
      | Waschmaschine |
      | Staubsauger   |


  Scenario Outline:Search for products that is not on the site via search page
    And The user go to Search Page
    When The user enters the name or part the name of the '<BadProduct>' in the search field.
    And The user click Search
    Then The user sees the "messageNoProducts".
    Examples:
      | BadProduct    |
      | Waschmaschine |
      | Staubsauger   |


  Scenario Outline:Advanced search for products that is not on the site by description
    And The user go to Search Page
    When The user enters the name or part the name of the '<BadDescription>' in the search field.
    And The user marks the field "Erweiterte Suche"
    And The user marks the field "In den Produktbeschreibungen suchen"
    And The user click Search
    Then The user sees the "messageNoProducts".
    Examples:
      | BadDescription|
      | Waschmaschine |
      | Staubsauger   |