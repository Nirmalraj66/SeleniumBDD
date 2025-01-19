@LoginPage
Feature: Home page feature

  #Background:
  #Given Browser is opened
  @Smoke @PDF
  Scenario Outline: Positive LogIn test
    Given Browser is opened
    When I enter valid <username> and <password>
    Then I validate the Home page is opened successfully

    Examples: 
      | username | password    |
      | student  | Password123 |
      | teacher  |   aaa      |

  @Datatbale
  Scenario: Login using datatable
    Given Browser is opened
    When I enter valid credntials
      | username | password    | details |
      | student  | Password123 |   aaa      |
    Then I validate the Home page is opened successfully
