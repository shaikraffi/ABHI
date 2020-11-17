Feature: To check the functionality of overview page 

Scenario: To verify GUI of Overview page

Given user is on the overview page
When ABHI logo is displayed
Then verify main menu options are displayed
And verify default period is displayed
Then verify proposal status section is displayed
And verify Latest commissions cards are displayed.

Scenario: To verify the proposal status and latest commissions within the selected period

Given user clicks on the period dropdown
When user selects the period in the calender
Then verify proposal status is displayed within the selected range of period 
And verify  latest commissions is displayed within the selected range of period

Scenario: To verify mousehovering onto proposal status section

Given User to mouseover onto premium amount in proposal bucket
When Tool tip is displayed with subcounts of proposals
Then Verify click on view in tool tip
Then Verify user is redirected to proposal list page 
And Verify proposals are displayed based on the selected proposal bucket
And Click on back button

Scenario: To verify mousehovering onto Latest commissions section

Given User to mouseover onto commission amount in commission card
When Tool tip is displayed with Commission amount , Paid amount, NOP
Then Verify click on view in commission tool tip
Then Verify user is redirected to commission statement page
And Click on overview in main menu 

Scenario: To verify the functionality of Menu navigation

Given User to click on My Proposals in main menu
When My proposals page is displayed
Then click on overview option and verify if view info is displayed
And User clicks on My Commissions in main menu
Then verify Commission Statement page is displayed
Then click on overview option















