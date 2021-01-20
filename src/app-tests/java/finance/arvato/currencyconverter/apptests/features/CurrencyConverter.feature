Feature: Card Configuration integration

  @Test
  Scenario: verify if the currency conversion is successful
    When convert below listed currencies
      | currency1 | NOK |
      | currency2 | INR |
      | amount    | 100 |
    Then conversion is successful

  @Test
  Scenario: verify if the attributes returned in the response are correct
    When convert below listed currencies
      | currency1 | NOK |
      | currency2 | INR |
      | amount    | 100 |
    Then conversion is successful
    And The attributes received in the response body are correct
      | from   | NOK |
      | to     | INR |
      | amount | 100 |

  @Test
  Scenario: Verify Bad request error when currency1 == invalid
    When convert below listed currencies
      | currency1 | invalid |
      | currency2 | INR     |
      | amount    | 100     |
    Then response code is 400

  @Test
  Scenario: Verify Bad request error when currency2 == invalid
    When convert below listed currencies
      | currency1 | NOK     |
      | currency2 | invalid |
      | amount    | 100     |
    Then response code is 400

  @Test
  Scenario: Verify Bad request error when amount == null
    When convert below listed currencies
      | currency1 | NOK |
      | currency2 | INR |
      | amount    |     |
    Then response code is 400

  @Test
  Scenario: Verify Bad request error when amount < 0
    When convert below listed currencies
      | currency1 | NOK  |
      | currency2 | INR  |
      | amount    | -100 |
    Then response code is 400

  @Test
  Scenario: Verify Bad request error when currency1 == null
    When convert below listed currencies
      | currency1 |     |
      | currency2 | INR |
      | amount    | 100 |
    Then response code is 400

  @Test
  Scenario: Verify Bad request error when currency2 == null
    When convert below listed currencies
      | currency1 | NOK |
      | currency2 |     |
      | amount    | 100 |
    Then response code is 400


