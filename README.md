# Transportation system

It is simple CRUD application designed to store data on parcels, as well as on cities that are part of the postal network.

Application is being deployed on Heroku : https://transportation-system-project.herokuapp.com/ParcelServlet.do?action=listParcels

Application features:
- Read information about all parcels, add new parcels;
- Edit and Delete existing parsels;
- Change status of parcel (Arrived, Departed, In the way);
- View additional information (as time when parcel was created or updated last time);
- Add / Edit / Delete cities of thhe postal network;
- Read event logs (on separate page) and clear logs;
- Order parcels by parameters: - ID, CitySender, CityRecipient, Weight, Status;
- Logs are written to database, console and file.

Personal project task for Epam University.

## Technologies stack
- Java
- MySQL 8.5, JDBC
- Log4j 2 
- Servlet API 3.0
- Stream API
- Bootstrap 4

Pattern: MVC (View layer is represented by Java Server Pages).

## How to run
1) Run SQL queries from 'transportation-system/src/main/resources/sql/queries.sql' file:
:
```sql
CREATE DATABASE transportation;
USE transportation ;

CREATE TABLE parcels (
	parcelId VARCHAR (15) NOT NULL auto_increment,
    senderName VARCHAR(25) DEFAULT NULL,
    recipientName VARCHAR(25) DEFAULT NULL,
    startCity VARCHAR(20) DEFAULT NULL,
	endCity VARCHAR(20) DEFAULT NULL,
    weight FLOAT(5) DEFAULT 1,
    PRIMARY KEY(parcelID)
);

CREATE TABLE cities(
	cityId int(8) not null auto_increment,
    cityName varchar(25) DEFAULT NULL,
    cityAlias varchar(25) DEFAULT NULL,
    PRIMARY KEY(cityId)
);

CREATE TABLE LOGS(
    DATED   VARCHAR(40)    NOT NULL,
    LOGGER  VARCHAR(50)    NOT NULL,
    LEVEL   VARCHAR(10)    NOT NULL,
    MESSAGE VARCHAR(1000)  NOT NULL
);

Run code in 'resources/sql/test-data.sql' to fill database with test data;
```
Connect to DB using username (root) and password (Skleroz123_).

2) Add new (or use existing) Tomcat Server Run Configuration.

Built artifact: trasportation-system:war exploded.

Set URL target: http://localhost:8080/transportation_system_war_exploded/ParcelServlet.do?action=listParcels. 

3) Run Tomcat Server.

4) Open next link if target URL is not set:
```link
http://localhost:8080/transportation_system_war_exploded/ParcelServlet.do?action=listParcels
```


