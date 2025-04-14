# Arcazon Java App Project 2

## Running Project:

### Create MySQL SCEMA 
- Ensure that proper schema for "arcazon_db" is created in MySQL

### Check application.properties
- There are three different application.properties files: `application.properties` and one for Austin, and one for everyone else.
- Either find a file that matches your settings or just edit the default file
- Remember key word in name of custom .properties file name. Example: for `application-local.properties` the keyword is `local`

### Run Spring command
- Open local terminal in eclipse
- CD to project root
- If happy with default application settings then run spring server using command `mvnw.cmd spring-boot:run`
- If using one of the other existing application files then run `mvnw.cmd spring-boot:run -Dspring-boot.run.profiles={keyword}`
- Example of command is: `mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=local`
- Check local host url: `http://localhost:8080`

## APIs

### Get All Products
Get: http://localhost:8080/api/products

### Get Product by id
Get: http://localhost:8080/api/products/{id}

### Get Products by price Range
Ensure that min and max are numbers with two decimals
Get: http://localhost:8080/api/products/price-range/{min}/{max}

### Add Product
POST: http://localhost:8080/api/products/add  
<br/>
**JSON Example:** 
<br/>
{ <br/>
&emsp;   "categoryId": 1, <br/>
&emsp;   "name": "Santa's Pants XL", <br/>
&emsp;   "description": "Warm and soft", <br/>
&emsp;   "price": 74.99, <br/>
&emsp;   "stock": 1 <br/>
} <br/>

### Get Categories
Get: http://localhost:8080/api/categories

### Get Categories by id
Get: http://localhost:8080/api/categories/{id}

### Search Customers by Email Domain
Find customers whose email contains the specified domain <br/>
Get: http://localhost:8080/api/customers/search/email/{domain}

### Checkout Process
Proceed to Checkout from index.html <br/>
Add any number of items to the cart (increase their quantity above 0) <br/>
Scroll to the bottom of the page to find the Place Order button <br/>
View your order confirmation <br/>
