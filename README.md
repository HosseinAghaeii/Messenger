# Messenger
![Static Badge](https://img.shields.io/badge/Message%20broker-grey)
![Static Badge](https://img.shields.io/badge/RabbitMQ-orange)
![Static Badge](https://img.shields.io/badge/MySQL-blue)


Backend logic for messaenger website using **message broker**.
~~Sockets~~ are not used in this project.

## Description
The goal of this project is to build a messaging website that can transfer messages in a fraction of a second using a message broker.
For this purpose, rabbitmq has been used. So far, the message logic has been implemented one by one. the project does not have a frontend section.

## Prerequisites
For run this app you should:
- install an **IDE** for java language like *inteliJ IDEA*
- intall **MySQL sever** and Use a database user interface like *phpMyAdmin* or *workbench*
- install **RabbitMQ managment server**
It is recommended to use **Docker**

## Installing
First you should build two client like client1 in this repository and for each client in createMessage in main class write uniqe username.
```
messageRequest.setPublisherId("Custom username");
```
You should run mysql and rabbitmq server then run Messenger app and finally you may run clients and enjoy messaging between them!
**Notice**: The ports of all servers must match
You can see detail of connection between servers and apps in application.properties 

## Versions
- JDK 17
- Spring boot 3.1.1
- mysql 5.0.12
- rabbitmq 3.12.1-management


