Feature: check search feature

Scenario: check search button is working for valid and invalid cred
Given login user and search button available 
When Enter <input1> what you want to search and use keyboard enter key
Then List the output displayed and check <status>

Examples:
|input1|status|
|online banking|pass|