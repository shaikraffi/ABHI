Feature: To check the functionality of tpd page 

 

Scenario: To display the commission statement  within the selected cycle 

Given User is On TPD Login Page
When User enters Username and Password and clicks on log in
Then Validate User is on TPD Page
Then select cycle,month,year in the dropdown and click on search
And verify commission statement is displayed
Then user clicks on show/hide

 


Scenario: Verify the functionality of download statement 

Given user to click on download statement
When download statement pop up is displayed
Then user clicks on download
And verify the file is downloaded

 


Scenario: Verify the functionality of Select all in download statement pop up 

Given user to check whether select all is enabled
When user clicks on select all 
Then verify whether all the checkboxes are enabled
And user to click on clear all

 


Scenario: Verify the GUI of TPD page.

Given user is on tpd page
When cycle,month,year dropdown is displayed
Then verify table grid is dispalyed
And verify gross total is displayed
Then verify download statement is displayed