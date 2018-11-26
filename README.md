# Residence Manager
![Login Page](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/login.jpg)


## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Status](#status)
* [Setup](#setup)
* [Images](#images)
* [Contact](#contact)

## General info
Residence Manager web app provides a simple, smart residence & owner management solution for any housing cooperative business.
It allows to track every single apartment, apartment owner and their detailed info as well as fixed rent and liabilities.
Application is/will be capable of tracking bank account operations (fetching payments),
calculating the current internal account balance and sending emails to the owners with account overdrafts.

## Technologies
* Spring MVC - version 5.0.8
* Spring Security - version 5.0.7
* Hibernate ORM - version 5.3.2
* Hibernate Validator - version 6.0.12
* HTML5, CSS, JSP, JSTL <br>
* Running locally with MySQL Community Server 8.0 and Apache Tomcat v9.0 <br>
* No Spring Boot used here. Spring with annotation based Java config used instead.

## Features
List of ready features:
* Logging in with database authentication.
* Listing all database owners or searching database by name or by id of an apartment owner.
* Adding or updating an owner or his/her apartment(s) and all of their details.
* User input validation.
* Deleting an owner or a apartment.
* Listing rent details, apartment liabilities and bank transfers.
* Calculating rents for all apartments after setting up the rates for utilities.
* Scheduler for monthly addition of the current rent amount to the total liability value on the apartment account.
* Recalculation of the apartment total liability value based on the monthly rent added previously.

TODO list:
* Scheduler for adding bank transactions to an apartment account.
* Total liability value recalculation (after addition of the bank transfers).
* Sending emails to owners with an account overdraft.
* Fetching bank account transfers.

## Status
Project is in progress.<br>
Project is up and running.

## Setup
### Running ResidenceManager locally

ResidenceManager is a Spring application built using Maven. You can build a jar file and run it from the command line:

#### Clone this repository
$ git clone https://github.com/dream-tree/ResidenceManager.git
#### Go into the repository
$ cd ResidenceManager
#### Build the project:
$ ./mvnw package
$ java -jar target/*.jar
#### Run the app
You can access ResidenceManager here: http://localhost:8080/residence-manager

## Images
![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard04.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard05.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard07a.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard07b.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard07c.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard08.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard09.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard10.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard21.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard22.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard23.jpg)

---

![](https://github.com/dream-tree/ResidenceManager/blob/master/src/main/webapp/resources/images/Clipboard99last.jpg)


## Contact
Created by [dream-tree](https://www.linkedin.com/in/marcin-klimek) - feel free to contact me!


---

Project #006.

---