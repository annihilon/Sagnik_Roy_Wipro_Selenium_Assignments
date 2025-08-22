Feature: Login to eBay

Scenario Outline: Login with valid credentials
Given login page should be open in default browser1
When click on signin link and enter <username> and <password>
Then login successfully and open home page

Examples:
|username            |password     |
|sroy20442@gmail.com |Pword123@79  |