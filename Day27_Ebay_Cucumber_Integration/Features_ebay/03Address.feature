Feature: Change user address

Scenario: Update user address details
Given user is logged in and account page is open
When change address to <add> and city to <city1>
Then address should be updated successfully
Examples:
|add           |city1     |
|1223ABC road |Kolkata  |