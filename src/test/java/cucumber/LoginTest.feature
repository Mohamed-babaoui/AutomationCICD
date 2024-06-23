
Feature: Purchase Order Test

  @Regression
  Scenario Outline: Successful order placement
   Given Landed on E-Commerce website
    And Login using <username> and <password>
    When Select the  <product> to purchase
    And check<product> in checkoutpage
    Then "THANKYOU FOR THE ORDER." should be displayed
    Examples:
      | username           | password      | product         |
      | Med.baba@gmail.com | Password@2019 | ZARA COAT 3     |
      | Med.baba@gmail.com | Password@2019 | ADIDAS ORIGINAL |
      | Med.baba@gmail.com | Password@2019 | IPHONE 13 PRO   |