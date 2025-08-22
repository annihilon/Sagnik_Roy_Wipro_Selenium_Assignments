Feature: vcheck online banking 
#scenario outline for multiple test cases and scenario for one test case
Scenario: Online banking and statement download
Given zerobank page should be available with <username1> and <password1>
When click on online banking hyperlink then click on online statements
And select savings from dropdown and then select year and click on statements for download
Then statements downloaded
Examples:
|username1|password1|
|username|password|