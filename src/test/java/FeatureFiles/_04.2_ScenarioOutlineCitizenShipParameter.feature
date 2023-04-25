#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Yukarıdki işlemleri Parameter yöntemi ile yapınız.
Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful
    And Navigate to citizenships page
@Regression
  Scenario Outline: Add citizenship
    When Add a citizenship name as "<Name>" short name as "<shortName>"
    Then Success message should be displayed for citizenship
####
  #Scenario: Add second citizenship
    When Add a citizenship name as "<Name>" short name as "<shortName>"
    Then Unsuccess message should be displayed

    When Delete the user name as "<Name>"
    Then Success message should be displayed

    Examples:
      | Name     | shortName |
      | citName111 | citShort111 |
      | citName221 | citShort221 |
      | citName331 | citShort331 |
      | citName44 | citShort44 |