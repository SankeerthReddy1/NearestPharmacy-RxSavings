# NearestPharmacy-RxSavings
A Spring Boot application to display the nearest pharmacy along with the distance in miles to it.

## Initial Setup

### Technologies Used
* JDK v1.8
* Spring Boot v2.2.2
* MySQL v8.0.21

### Tools Used
* Eclipse J2EE IDE
* MySQL Workbench
* Postman

### Database Setup
* Created pharmacies schema and within the schema created a pharmacydetails table and imported the input pharmacies.csv file into MySQL Workbench. The database export file can be found in the root directory.

![Database screenshot](/pharmaciesDB.jpg)

* Then the spring boot application is connected to the database using `mysql-connector-java` through application.properties

## Result
* Using postman we can send the request in JSON format and view the nearest pharmacy details with distance in miles.

![Postman screenshot](/nearest_pharmacy.jpg)
