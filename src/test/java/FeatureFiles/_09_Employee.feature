#Senaryo :
#  Employee menüsü için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.
Feature: Scenario Outline and DataTable for employees

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful

  Scenario Outline: Add and delete a employee

    And Click on the element in left nav
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | firstNameInput  | <nameInput>       |
      | lastNameInput   | <lastNameInput>   |
      | EmployeeIDInput | <EmployeeIDInput> |

    And Click on the element in the Dialog
      | statusInput          |
      | <statusSelect>       |
      | documentType         |
      | <documentTypeSelect> |
      | contactAddress       |

    And User sending the keys in Dialog content
      | countryInput | <countryInput> |


    #Then Success message should be displayed
#
    #And User delete item from Dialog
    #  | <nameInput> |
#
    #Then Success message should be displayed
    Examples:
      | nameInput  | lastNameInput | EmployeeIDInput  | statusSelect  | documentTypeSelect | countryInput   |
      | nameInput1 | codeInput1    | integrationCode1 | statusPassive | dCPersonalID       | bananaRepublic |
      | nameInput2 | codeInput2    | integrationCode2 | statusActive  | dCPassport         | appleRepublic  |
      | nameInput3 | codeInput3    | integrationCode3 | statusActive  | dCBirthCertificate | orangeRepublic |
      | nameInput4 | codeInput4    | integrationCode4 | statusPassive | dCPassport         | appleRepublic  |
      | nameInput5 | codeInput5    | integrationCode5 | statusPassive | dCPersonalID       | bananaRepublic |