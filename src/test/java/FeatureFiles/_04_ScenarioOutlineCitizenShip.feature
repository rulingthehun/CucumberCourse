#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Yukarıdki işlemleri Parameter yöntemi ile yapınız.
Feature: CitizenShip page

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful
    And Navigate to citizenships page

  Scenario: Add citizenship
    When Add a citizenship
    Then Success message should be displayed for citizenship

  Scenario: Add second citizenship
    When Add a citizenship
    Then Unsuccess message should be displayed