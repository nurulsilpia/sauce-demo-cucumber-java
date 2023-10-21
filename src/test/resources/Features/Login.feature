@Login
Feature: Login Sauce Demo

  @Negative
  Scenario Outline: Login with valid username and invalid password
    Given I on login page
    When I enter username <username>
    And I enter password <password>
    And I click button login
    Then The system will show error message

    Examples:
      | username      | password          |
      | standard_user | secret_sauce_fail |

  @Negative
  Scenario Outline: Login with invalid username and valid password
    Given I on login page
    When I enter username <username>
    And I enter password <password>
    And I click button login
    Then The system will show error message

    Examples:
      | username           | password     |
      | standard_user_fail | secret_sauce |

  @Negative
  Scenario Outline: Login with invalid username and invalid password
    Given I on login page
    When I enter username <username>
    And I enter password <password>
    And I click button login
    Then The system will show error message

    Examples:
      | username           | password          |
      | standard_user_fail | secret_sauce_fail |

  @Positive
  Scenario Outline: Login with valid credential
    Given I on login page
    When I enter username <username>
    And I enter password <password>
    And I click button login
    Then The system will redirect to the Products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
