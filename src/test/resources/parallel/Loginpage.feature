Feature: Login Page
Scenario: title verification
Given User is on the landing page
When User gets the title of the page
Then page title should be "Online Shopping site in India: Shop Online for Mobiles, Books Watches, Shoes and More - Amazon.in,"

Scenario: Order link display verifivation
Given User is on the landing page
Then orders section should in displayed on webpage

Scenario: Login with corrcet credentials
Given User is on the landing page
When  User enters the username "8668321787"
And  User enters the password "123456"
And User clicks on login button
