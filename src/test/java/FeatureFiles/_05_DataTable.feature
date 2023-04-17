Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successful

  Scenario: Create Country
    And Click on the element in left nav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brk160626 |
      | codeInput | 160626    |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | brk160626 |

  Scenario: Create a Nationality
    And Click on the element in left nav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brk160626 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | brk160626 |

    #TODO : Crate a fee, delete fee