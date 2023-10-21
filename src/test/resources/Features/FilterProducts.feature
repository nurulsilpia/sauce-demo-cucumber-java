@Product @Filter
Feature: Filter product

  Background:
    Given User already login with valid credential
      | username      | password     |
      | standard_user | secret_sauce |

  @Positive
  Scenario: Filter by name Z to A
    When I click button filter
    And I select option name Z to A
    Then The product is sort by name Z to A