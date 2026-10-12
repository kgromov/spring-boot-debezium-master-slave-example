# Debezium Installation with Spring Boot, Postgresql and Mysql

## What is Debezium?

Debezium is an open-source distributed platform for capturing real-time changes in databases. It provides a way to stream database changes as events, which can be consumed by other applications for real-time data processing, analytics, or other purposes.   
It works by setting up a Debezium connector that monitors the database and sends changes as events to a Kafka topic.    
So on quite low level by reading database logs. Connector is needed on consumer side to add listener (consumer listen to events from producer side via connector).

## Setup and env
With embedded `DebeziumEngine` implementation it's actually required to have only connector to input/producer datasource (in our case postgres) and consumer side (in our case mysql) that consumes events from producer side but in-memory. So no kafka needed as well as zookeeper and debezium itself. So full docker-compose setup is rather for reference to show closer to real life setup.    
Datasources setup via docker compose and used trick to create db if missed - `createDatabaseIfNotExist` flag that apparently supported by both postgres and mysql.

[![Debezium Installation with Spring Boot, Postgresql and Mysql](https://img.youtube.com/vi/gurxMenlj9E/maxresdefault.jpg)](https://youtu.be/gurxMenlj9E)
## [See full youtube video](https://youtu.be/gurxMenlj9E)

### Get ready to experience the ultimate tutorial on Debezium Installation with Spring Boot, PostgreSQL, and MySQL! 

🚀 In this mind-blowing video, we dive deep into the world of data mirroring and synchronization using Debezium. 

 🔗 Take advantage of Spring Boot's seamless integration with Debezium, ensuring a smooth and efficient data streaming process. Harness the power of real-time event streaming with Kafka, and witness your database changes propagate immediately at lightning speed! 

⚡️ Explore step-by-step instructions, powerful tips, and hands-on examples that will make you a Debezium superstar in no time. 

Don't miss out on this exciting adventure, watch now! #Debezium #SpringBoot #Kafka

# Spring Boot Debezium - Master Slave Real Project Example

[![Spring Boot Debezium - Master Slave Real Project Example](https://img.youtube.com/vi/n0m6r0kXZh8/maxresdefault.jpg)](https://youtu.be/n0m6r0kXZh8)
## [See full youtube video](https://youtu.be/n0m6r0kXZh8)

### In this tutorial, we will explore how to implement Change Data Capture (CDC) in a master-slave architecture using Spring Boot and Debezium. This demonstration is targeted towards teenagers, developers, programmers, and students looking to expand their knowledge of CDC and its implementation in real-world scenarios.

Inside this video 📺, you will see:

To implement Change Data Capture (CDC) in a master-slave architecture using Spring Boot and Debezium, you can follow these steps:

Setting up the Database:
Set up your database (e.g., MySQL, PostgreSQL) with the required tables. Ensure that binary logging is enabled in your database settings. 🛠️

Add Dependencies:
In your Spring Boot project's pom.xml, add dependencies for Spring Boot, Debezium, and the database connector (e.g., debezium-connector-mysql). 📦

Configure Debezium:
Configure Debezium in your Spring Boot application. This involves setting up properties like database connection details, CDC configuration, etc. Configure Debezium to use the appropriate connector for your database (e.g., MySQL, PostgreSQL). ⚙️

Define Kafka Connect Configuration:
Define the Kafka Connect configuration file to specify the source database, topics, and other configurations. 📝

Implement the Consumer/ Listener:
Implement a Kafka consumer in your Spring Boot application to consume the change events published by Debezium. Process these change events and apply them to your slave database accordingly. 👩‍💻

Replicate Changes to Slave Database:
Use the information from the consumed change events to apply the corresponding changes to the slave database. Implement mechanisms to handle data consistency, error handling, and conflict resolution if needed. 🔄

Handle Data Transformations:
If required, transform the data before applying it to the slave database. This might involve mapping data types, restructuring data, etc. 🔄

#ChangeDataCapture #CDC #SpringBoot #Debezium #MasterSlaveArchitecture #KafkaConnect

