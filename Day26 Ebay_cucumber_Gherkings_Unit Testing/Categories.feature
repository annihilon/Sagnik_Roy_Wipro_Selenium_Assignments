Feature: Browse products by categories

Scenario: Shop by all categories
Given user is logged in and homepage is open
When click on all categories
Then all categories page should be displayed

Scenario: Shop by art category
Given user is logged in and homepage is open
When click on art category
Then art category page should be displayed