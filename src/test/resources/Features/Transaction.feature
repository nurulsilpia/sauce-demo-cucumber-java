@Product @Transaction
Feature: Transaction

  Background:
    Given User already login with valid credential
      | username      | password     |
      | standard_user | secret_sauce |

  @Positive
  Scenario Outline: Transaction successfully
    When I click cart logo on the top right
    And I click button Checkout
    Then The system will display checkout information
    When I input First Name <firstName>
    And I input Last Name <lastName>
    And I input Zip Code <zip>
    And I click button Continue
    Then The system will display checkout overview
    When I click button Finish
    Then Payment is complete

    Examples:
      | firstName | lastName | zip  |
      | John      | Doe      | 1234 |

  @Negative
  Scenario: Checkout without any product on the cart
  user should not be able to click the checkout button

    When I click cart logo on the top right
    And I make sure that there is no product on the cart
    Then I can't continue payment proses