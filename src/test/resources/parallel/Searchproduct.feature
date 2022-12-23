Feature: Search Functionality
Scenario: Searching of Product
Given  User should be already logged in with "8668321787" and "123456"
When User enters the text "Iphone 14" and search
Then Iphones list should get displayed
