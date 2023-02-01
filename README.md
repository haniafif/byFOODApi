# byFOODApi 

## Introduction

This is as back-end server for a Fullstack challenge

Front-end https://github.com/haniafif/your-best-meal

Technologies used

Java 19
JDK 19.0.1
SpringBoot 3.0
Maven
SQLFlyway 

To run the project please install de dependencies using Maven after this configura MySQL

## MySQL configuration

Please configure the MySQL enviroment in application.properties

spring.datasource.url=jdbc:mysql://localhost/byFoodApi ( Database )
spring.datasource.username=root
spring.datasource.password=YOURPASSAWORD

SCHEMA for creation the table is in resources/db.migration

create table restaurant(
id bigint not null auto_increment,
name varchar(100) not null,
customer_rating int not null,
distance int not null,
price int not null,
cuisine_id int not null,

    primary key(id)
);

You must first populate the table with the .csv provided in the exam, query to populate table

LOAD DATA INFILE 'restaurants.csv'
INTO TABLE restaurant
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(name, customer_rating,distance,price, cuisine_id);

## Endpoints

This project currently have 2 end points:

/restaurants ( Get & Post )
/restaurants/filters (Post)

## VIDEO DOCUMENTATION

https://share.vidyard.com/watch/kGJNnt2D3z2ehPcCfWijgs?


