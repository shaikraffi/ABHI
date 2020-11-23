Feature: To check the functionality of agent commission statement

Scenario: To display the commission statement from commission cards

Given user to Login into Portal
When user latest three commission cards are displayed
Then mouseover onto the commission amount in commission card
And click on view in tool tip
Then Verify month in the commission statement page

Scenario: To display the commission statement from main menu

Given Agent to click on My Commissions in main menu
When commission statement page is displayed
Then select cycle, month, year in the dropdowns
And click on search button
Then click on download statement

