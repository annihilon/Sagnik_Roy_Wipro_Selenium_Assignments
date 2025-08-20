Feature: Add and remove items from cart

Scenario: Add product to cart and remove it
Given user is logged in and homepage is open
When add product "Laptop" to cart
Then remove item from cart