@wip
Feature: Web Restaurant search functionality
  Agile Story: As a user when I am on Web Restaurant home page
  I should be able to search for an item, see all results contain
  the search parameter, add an item to shopping cart and empty
  shopping cart

  Background:
    Given User is on Web Restaurant home page

  Scenario: User searches for an item
    When User searches for an item "stainless work table"
    Then All results should contain key word "Table"


  Scenario: User adds item to cart and empties cart
    When User searches for an item "stainless work table"
    And User adds last found item to cart
    And User empties cart
    Then Cart should be empty