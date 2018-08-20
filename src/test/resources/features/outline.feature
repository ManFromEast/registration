Feature: Annotation

#This is how background can be used to eliminate duplicate steps 
Background: User navigates to Facebook
Given I am on Facebook login page

Scenario: enter invalid username or password to login facebook.
   When I enter username as "TOM"
   And I enter password as "JERRY" 
   Then Login should fail 


Scenario: enter proper username and password to login facebook.
   When I enter username as "xxxxxxxxxxxxxxx" 
   And I enter password as "xxxxxxxxxxxxxxxxx" 
   But Relogin option should be available
