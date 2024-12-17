
Feature: Search Functionality

  Background:
    Given The user is on the main page

  @ignored
  Scenario Outline:Search for products using the search field on the main page
    When The user enters the name or part the name of the '<Product>' in the search field  auf Home Page.
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |
      | Kaiser Flowable Composite |


  @ignored
  Scenario Outline:Search for products via search page
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |
      | Kaiser Flowable Composite |


  @ignored
  Scenario Outline:Advanced search for products by description
    And The user go to Search Page
    When The user enters the name or part the name of the '<Description>' in the search field.
    And The user marks the field "Erweiterte Suche"
    And The user marks the field "In den Produktbeschreibungen suchen"
    And The user click Search
    Then The user sees in the products the '<Description>' he was looking for.
    Examples:
      | Description          |
      | Fissurenversiegelung |

  @ignored
  Scenario Outline:Advanced search for products by Category
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user marks the field "Erweiterte Suche"
    When The user selects a product '<Category>'
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |Category                         |
      | Kaiser Flowable Composite |Restorative Produkte >> Composite|


  @ignored
  Scenario Outline:Advanced search for products by Category
    And The user go to Search Page
    When The user enters the name or part the name of the '<Product>' in the search field.
    And The user marks the field "Erweiterte Suche"
    When The user selects a product '<Category>'
    And The user marks the field "Unterkategorien einbeziehen"
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product |Category                         |
      | Kaiser  |Restorative Produkte >> Composite|

  Scenario Outline:Transition to the product page from search results from the main page
    When The user enters the name or part the name of the '<Product>' in the search field  auf Home Page.
    And The user goes to the product page.
    Then The user sees the page of the selected '<Product>'.

    Examples:
      | Product                                                 |
      | Kaiser Flowable Composite                               |
      | Kaiser Flowable Composite Medium 2 X 2g Syringe-Spritze |