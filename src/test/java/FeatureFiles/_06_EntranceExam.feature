#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
Feature: Create and delete a exam

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful

  Scenario: Create and delete a exam

    And Click on the element in left nav
      | entranceExams      |
      | examSetup          |
      | entranceExamsSetup |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brkEg22212 |

    And Click on the element in the Form Content
      | academicPeriod      |
      | academicPeriodClick |
      | gradeLevel          |
      | gradeLevel2         |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExams      |
      | examSetup          |
      | entranceExamsSetup |

    And User delete item from Dialog
      | brkEg22212 |

    Then Success message should be displayed