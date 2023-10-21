@Product @AddToCart
Feature: Add product to cart

  Background:
    Given User already login with valid credential
      | username      | password     |
      | standard_user | secret_sauce |

  @Positive
  Scenario: Add product to cart via list
    When I click button Add to cart
    And I click cart logo on the top right
    Then The system will display the products that I added

    Scenario: Add product via detail
      When I detailing product
      And I click button Add to cart
      And I click cart logo on the top right
      Then The system will display the products that I added

