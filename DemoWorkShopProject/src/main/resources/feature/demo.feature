Feature: In order to buy products
         As a e-commerce customer
         I want to register into the application
         

Background: 
Given I have a browser with demoworkshop page

        
Scenario Outline: Details of phone
When I enter username as '<username>' and password as '<password>' and I go to electronics and click on phone and get the details of the product
Then I should get the details of phone
Examples: 
|username|password|
|mohithayarramsetty@gmail.com|yarramsetty|


Scenario: Setting the quantity of the product to 2
When I  go to apparel and shoes and click on any product and change the quantity to '2'
Then The quantity of the product should be changed to '2'

  
Scenario Outline: Sort By price
When I enter username as '<username>' and password as '<password>' and I go to digital downloads and change the sort by to 'Price: High to Low'
Then It should be sorted to high to low
Examples: 
|username|password|
|mohithayarramsetty@gmail.com|yarramsetty|



Scenario Outline: Filter by price
When I enter username as '<username>' and password as '<password>' and I go to jewelry change the filter by price 
Then It should be change to 700-3000 filter
Examples: 
|username|password|
|mohithayarramsetty@gmail.com|yarramsetty|


Scenario Outline: View as list
When I enter username as '<username>' and password as '<password>' and I go to gift cards change the view as to 'List'
Then It should be changed to list      
Examples: 
|username|password|
|mohithayarramsetty@gmail.com|yarramsetty|




