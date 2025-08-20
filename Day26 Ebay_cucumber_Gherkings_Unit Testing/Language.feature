Feature: Change language settings

Scenario: Change language to Korean
Given user is logged in and account settings page is open
When change language to Korean
Then language should be changed to Korean