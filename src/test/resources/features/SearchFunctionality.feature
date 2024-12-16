Feature: Search Functionality
  Scenario Outline:Search for products via the main page  search for products via search page
    Given The user is on the main page
    When The user enters the name of the '<Product>' in the search field  auf Home Page.
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |
      | Kaiser Flowable Composite |



  Scenario Outline:Search for products via search page
    Given The user is on the main page
    And The user go to Search Page
    When The user enters the name of the '<Product>' in the search field.
    And The user click Search
    Then The user sees the '<Product>' he was looking for.
    Examples:
      | Product                   |
      | Kaiser Flowable Composite |



  Scenario Outline:Advanced search for products by description
    Given The user is on the main page
    And The user go to Search Page
    When The user enters the name of the '<Description>' in the search field.
    And The user marks the field "Erweiterte Suche"
    And The user marks the field "In den Produktbeschreibungen suchen"
    And The user click Search
    Then The user sees in the products the '<Description>' he was looking for.
    Examples:
      | Description          |
      | Fissurenversiegelung |