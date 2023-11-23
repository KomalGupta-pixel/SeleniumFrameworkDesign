
@tag
Feature: Purchase the Order from E-Commerce
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page

  
  @tag2
  Scenario Outline: Positive test for submit an order
    Given Logged in with <username> and <password>
    When I add product <productName> to cart
    And Checkout <productName> and Submit the Order
    Then "Order Confirmation" message is displayed on Confirmation page

    Examples: 
      | username      | password     | productName  |
      | komal@att.com |  testqa@1234 | DAYTON       |
      
