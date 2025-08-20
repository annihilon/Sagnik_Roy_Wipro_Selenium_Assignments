Feature: Change user address

Scenario: Update user address details
Given user is logged in and account page is open
When change address to "123 ABC" and city to "PQR"
Then address should be updated successfully