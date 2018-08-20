Feature: HelloController

#This is how background can be used to eliminate duplicate steps 
Background: SayHello

Scenario Outline: access sayHello method with paramter name
   Given I will say hello to "<name>"
   When access sayHello method with paramter name
   Then I call parser to resovle response

Examples:
   | name    |
   | Dolly   |