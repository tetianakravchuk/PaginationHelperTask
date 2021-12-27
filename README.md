# PaginationHelper Java
## Overview
[The PaginationHelper](https://github.com/tetianakravchuk/PageHelper/blob/master/src/main/java/PaginationHelper.java)
class is designed to take in an array of values and an integer
indicating how many items will be allowed per page.

[The PaginationHelperTest class](https://github.com/tetianakravchuk/PageHelper/blob/master/src/test/java/PaginationHelperTest.java)
is designed to test all methods with different conditions. 

## Methods of PaginationHelper:
 1. pageCount(); - calculates how many total pages. If there is no pages, it returns 0, otherwise returns number of pages.
 2. itemCount(); - calculates how many total items. 
 3. pageItemCount; - calculates how many items on particular page. 
 4. pageIndex(); - returns index of page by index of item in the given array
 


