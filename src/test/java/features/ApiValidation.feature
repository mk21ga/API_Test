Feature: Validate exchange rate api

Scenario: Verify if the status code is 200
Given Exchange rate api
When User calls "ExchangeRateApi" with "Get" http request
Then Api call should be success with status code 200

Scenario: Count the total currencies returned in response
Given Exchange rate api
When User calls "ExchangeRateApi" with "Get" http request
Then Get the total currencies from response body

Scenario: Verify if GBP currency is shown in response
Given Exchange rate api
When User calls "ExchangeRateApi" with "Get" http request
Then Check if "GBP" currency is shown in response body
