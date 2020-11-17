Feature: Launch Browser based on requirements

Scenario: Launch Browser

Given Launch the Browser
When User enters URL of the portal
Then Validate Login Page is displayed

Scenario: Login with Valid Credentials

Given User is On Login Page
When User enters Username and Password
Then Click on Login Button
Then Validate User is on Home Page
And user logs out.





Scenario: Login with Invalid Credentials

Given User is On Login Page
When User enters invalid Username and Password
Then Click on Login Button
Then user to verify error message is displayed as invalid username and password
