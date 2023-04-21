#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  name, code, intCode ve priority için 5 farklı değerler için çalıştırınız.
Feature: Scenario Outline and DataTable

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful

  Scenario Outline: Create and delete a fee

    And Click on the element in left nav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <nameInput>       |
      | codeInput       | <codeInput>       |
      | integrationCode | <integrationCode> |
      | priorityInput   | <priorityInput>   |

    And Click on the element in the Dialog
      | toggleSlide |
      | saveButton  |

    Then Success message should be displayed

    And User delete item from Dialog
      | <nameInput> |

    Then Success message should be displayed
    Examples:
      | nameInput  | codeInput  | integrationCode  | priorityInput  |
      | nameInput1 | codeInput1 | integrationCode1 | priorityInput1 |
      | nameInput2 | codeInput2 | integrationCode2 | priorityInput2 |
      | nameInput3 | codeInput3 | integrationCode3 | priorityInput3 |
      | nameInput4 | codeInput4 | integrationCode4 | priorityInput4 |
      | nameInput5 | codeInput5 | integrationCode5 | priorityInput5 |