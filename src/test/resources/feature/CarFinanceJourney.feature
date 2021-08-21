Feature: Tests car finance journey

  Scenario: Verify page title
    Given I am on car finance page
    Then page title should be "Go Compare Money | Car Finance."

  Scenario: Verify page title for Terms and conditions page
    Given I am on car finance page
    When I click terms and conditions footer link
    And I select Terms and Conditions window
    Then page title should be "Terms and conditions - GoCompare.com"

  Scenario Outline: Error message displayed when invalid car registration details provided
    Given I am on car finance page
    When I type "<Invalid_registration_number>" on registration number field
    And I click Find Car button
    Then error message "We are sorry but no vehicles could be found." should be displayed
    Examples:
      | Invalid_registration_number |
      | AAA                         |
      | UH123D	                    |
      | 111	                        |

  Scenario: Verify end to end car finance user journey
    Given I am on car finance page
    When I fill mandatory details on Car Finance page
    And I navigate to About You page
    And I fill mandatory details on About You page
    And I navigate to Your Finances page
    And I fill mandatory details on Finances page
    And I accept privacy statement
    Then I should see personalised results

