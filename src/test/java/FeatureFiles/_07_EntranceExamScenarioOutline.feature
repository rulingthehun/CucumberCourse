#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
Feature: Create and delete a exam

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful

  Scenario Outline: Create and delete a exam

    And Click on the element in left nav
      | entranceExams      |
      | examSetup          |
      | entranceExamsSetup |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod         |
      | <academicPeriodOption> |
      | gradeLevel             |
      | <gradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExams      |
      | examSetup          |
      | entranceExamsSetup |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName         | academicPeriodOption | gradeLevelOption |
      | Math exam is11   | academicPeriodClick  | gradeLevel2      |
      | IT exam is11     | academicPeriodClick  | gradeLevel3      |
      | Oracle exam is11 | academicPeriodClick  | gradeLevel4      |
      | Math exam  is11  | academicPeriodClick  | gradeLevel5      |