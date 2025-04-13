# Arcazon Java App Project 2

## Running Project:
1. Ensure that proper schema for "arcazon_db" is created in MySQL
2. Run spring server in eclipse using command `mvnw.cmd spring-boot:run` (ensure command is run in project root directory)


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
