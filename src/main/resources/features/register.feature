@register
Feature: Register Endpoint Testing
  These tests verify the behavior of the /register endpoint under different input conditions.

  Background:
    Given Base URL is set

  @positive
  Scenario: Successful registration
    Given I set valid username "newuser1234"
    And I set valid password "SecurePass12"
    And I set confirm password "SecurePass12"
    When I send POST request to "/register"
    Then the response code should be 10

  @negative
  Scenario: Missing username
    Given I set valid username ""
    And I set valid password "SecurePass12"
    And I set confirm password "SecurePass12"
    When I send POST request to "/register"
    Then the response code should be 112

  @negative
  Scenario: Missing password
    Given I set valid username "user1234"
    And I set valid password ""
    And I set confirm password "SecurePass12"
    When I send POST request to "/register"
    Then the response code should be 112

  @negative
  Scenario: Missing confirm password
    Given I set valid username "user1234"
    And I set valid password "SecurePass12"
    And I set confirm password ""
    When I send POST request to "/register"
    Then the response code should be 112

  @negative
  Scenario: Password does not match confirm password
    Given I set valid username "user1234"
    And I set valid password "SecurePass12"
    And I set confirm password "WrongPass12"
    When I send POST request to "/register"
    Then the response code should be 129

  @negative @edge
  Scenario: Password equals username
    Given I set valid username "mypassword"
    And I set valid password "mypassword"
    And I set confirm password "mypassword"
    When I send POST request to "/register"
    Then the response code should be 129

  @negative
  Scenario: Username already exists
    Given I set valid username "test1"
    And I set valid password "NewPass123"
    And I set confirm password "NewPass123"
    When I send POST request to "/register"
    Then the response code should be 113

  @edge
  Scenario Outline: Username length edge cases
    Given I set valid username "<username>"
    And I set valid password "NewPass123"
    And I set confirm password "NewPass123"
    When I send POST request to "/register"
    Then the response code should be <code>

    Examples:
      | username                                   | code |
      | abc                                        | 99   |
      | verylongusernamealsotbilisiiscapitalofgeorgia       | 99   |

  @edge
  Scenario Outline: Password length edge cases
    Given I set valid username "user1234"
    And I set valid password "<password>"
    And I set confirm password "<password>"
    When I send POST request to "/register"
    Then the response code should be <code>

    Examples:
      | password  | code |
      | short     | 99  |

  @edge @positive
  Scenario Outline: Valid username and password edge lengths
    Given I set valid username "<username>"
    And I set valid password "<password>"
    And I set confirm password "<password>"
    When I send POST request to "/register"
    Then the response code should be 10

    Examples:
      | username                            | password     |
      | user                                | EdgePass12   |
      | tbilisi_is_capital_of_georgiaa | PassWord123  |
      | goodname                            | abcdefgh     |