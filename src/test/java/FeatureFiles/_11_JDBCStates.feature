Feature: Testing JDBC States
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    #Then User should login successful

  Scenario: States testing with JDBC
    And Click on the element in left nav
      | setup      |
      | parameters |
      | states  |
    Then Send the query to the database "select * from states" and control match