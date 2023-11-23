
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with <username> and <password>
    Then "Your User ID  or Password is incorrect. Try again." message is displayed

    Examples: 
      | username      | password     |
      | komal@att.com |  testqa1234  | 
