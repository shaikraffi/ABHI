Feature: To check the latest commissions of the user in home page

Scenario: To check the latest three commissions cards of the user

Given user to check the Latest three commissions cycles along with commission amount
When mousehovering onto commission amount a tool tip should be displayed with Commission Amount and Paid Amount and NOP
And mousehovering onto any other element tool tip should not be displayed
And user clicks on Commission period/Amount
Then  Verify My Commission statements page is displayed


Scenario: To check the Agency Commission Statements details

Given user is on agency commission statement page
When user selects Cycle and Month and Year in dropdowns
And user clicks on search button
Then Agent Commission statements details like agent name and agent code etc are displayed
And user clicks on download button
Then user to verify if the commission statement document is displayed
And user clicks on share button
And user enters the email id 
Then verify if the commission statement document is shared to agent



Scenario: To check the TPD Commissions Statements details

Given user is on TPD commission statement page
When user selects Cycle and Month and Year in dropdowns
And user clicks on search button
Then Commission Summary and Commission Details should be displayed
