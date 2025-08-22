Feature: Account activity 

Scenario: Check account activity and pay bill
Given user logged in
When click on account activity and then on sub module pay bill
And choose payee, account and amount and then select date from new window and add description
And click or enter on pay button
Then payment done
