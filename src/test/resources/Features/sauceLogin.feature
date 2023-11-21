@Login

Feature: Saucedemo Login Test
  Scenario: Success Login on saucedemo

    Given User open SauceDemo Website
    Then Input username "standard_user" and password "secret_sauce"
    When Click button login
    And Should redirect to home page

    Scenario Outline: Login success on saucedemo using scenario outline
      And Input username "<username>" and password "<password>"
      When Click button login
      Then Should redirect to home page
      Examples:
      |username | password|
      |standard_user|secret_sauce     |

  Scenario Outline: Login failed on saucedemo using scenario outline
    And Input username "<username>" and password "<password>"
    When Click button login
    Then Failed login and show message
    Examples:
      |username | password|
      |standard_user|abcseddkd|