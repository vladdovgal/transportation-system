-- code to execute in Workbench (or IntellijIDEA) to create db and accompanying tables

CREATE DATABASE transportation;
USE transportation ;

CREATE TABLE parcels (
	parcelId INT(8) NOT NULL auto_increment,
    senderName VARCHAR(25) DEFAULT NULL,
    recipientName VARCHAR(25) DEFAULT NULL,
    startCity VARCHAR(20) DEFAULT NULL,
	endCity VARCHAR(20) DEFAULT NULL,
    weight FLOAT(5) DEFAULT NULL,
    PRIMARY KEY(parcelID));

CREATE TABLE cities(
	cityId int(8) not null auto_increment,
    cityName varchar(25) DEFAULT NULL,
    cityAlias varchar(25) DEFAULT NULL,
    PRIMARY KEY(cityId))