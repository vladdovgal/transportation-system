-- code to execute in Workbench (or IntellijIDEA) to create db and accompanying tables
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
    DATED   DATE           NOT NULL,
    LOGGER  VARCHAR(50)    NOT NULL,
    LEVEL   VARCHAR(10)    NOT NULL,
    MESSAGE VARCHAR(1000)  NOT NULL
);