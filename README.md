# SimpleNoteApi



This application is a simple note CRUD operations using MYSQL  and JPA
# Requirements
> Java - 1.8

> Maven - 3.x

> Mysql-5.x

# Project Setup
1 . Clone the application

       git clone https://github.com/Revansidda/Note-API-spring-boot.git

2.Create Mysql database
   create database note_crud
   
 3.Change mysql username and password as per your installation in application.properties file
      Build and run the application
      The application will start running at http://localhost:8080.

4.Below are the APIs


    GET /v1/notes
    
    POST /v1/notes
    
    GET /v1/notes/{noteId}
    
    PUT /v1/notes/{noteId}
    
    DELETE /v1/notes/{noteId}
