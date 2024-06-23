@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given  Landed on E-Commerce website
    When Login using <username> and <password>
    Then "Incorrect email or password." message is displayed
    Examples:
      | username               | password     |
      | Med.baba@gmail.com | Passwrd@2019 |

