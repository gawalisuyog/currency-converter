Feature: Currency Conversion

  @Test
  Scenario Outline: verify if the currency conversion is successful
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then conversion is successful
    Examples:
      | currency1 | currency2 | amount |
      | NOK       | INR       | 100    |

  @Test
  Scenario Outline: verify if the attributes returned in the response are correct
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then conversion is successful
    And The attributes received in the response body are correct
      | from   | NOK |
      | to     | INR |
      | amount | 100 |
    Examples:
      | currency1 | currency2 | amount |
      | NOK       | INR       | 100    |

  @Test
  Scenario Outline: Verify Bad request error when currency1 == invalid
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      | invalid   | INR       | 100    |

  @Test
  Scenario Outline: Verify Bad request error when currency2 == invalid
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      | NOK       | invalid   | 100    |

  @Test
  Scenario Outline: Verify Bad request error when amount == null
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      | NOK       | INR       |        |

  @Test
  Scenario Outline: Verify Bad request error when amount < 0
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      | NOK       | INR       | -100   |

  @Test
  Scenario Outline: Verify Bad request error when currency1 == null
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      |           | INR       | 100    |

  @Test
  Scenario Outline: Verify Bad request error when currency2 == null
    Given Base currency is "<currency1>"
    And Target currency is "<currency2>"
    When I convert amount "<amount>"
    Then response code is 400
    Examples:
      | currency1 | currency2 | amount |
      | NOK       |           | 100    |


