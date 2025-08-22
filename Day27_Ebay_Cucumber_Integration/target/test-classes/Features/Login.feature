Feature: validate login page 
#scenario outline for multiple test cases and scenario for one test case
Scenario: Check for valid and invalid credentials
Given login page should be open in default browser

#<> this is the user input part
When click on username button and enter <username1> and add <password1>
And check <status>
Then login successful and open home page
Examples:
|username1|password1|status|
|username|password|success|
