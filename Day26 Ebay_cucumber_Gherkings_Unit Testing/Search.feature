Feature: Search products on eBay

Scenario Outline: Perform multiple searches
Given user is logged in and search page is available
When enter <searchTerm> in search box
Then search results should be displayed

Examples:
|searchTerm|
|Watch     |
|Pen       |
|Laptop    |