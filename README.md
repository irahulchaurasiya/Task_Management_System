# Welcome to Task Management System Application README File :wave:


## Framework Used
___
```bash
 Springboot
```

## Language Used
___
```bash
 Java
```

## Tools Used
___
```bash
 Intellij IDEA
 MySQL Workbench
 Maven
 Swagger
```
## Database Used
___
```bash
 MySQL
```

# :office: DataFlow of the program 
<br>

## Client Interaction
___
> The client, such as a web browser or a mobile app, sends HTTP requests to the server for Task Management System Application operations, including SignUp User , SignIn User , Create Task , Update Task , Delete Task etc. (CRUD operations).

## Controller Layer
___
> In the Spring Boot application, the incoming HTTP requests are handled by the Controller layer. The Controller receives the requests and delegates them to the appropriate methods in the service layer.

## Service Layer
___
> The Service layer contains the business logic of the application and handles Task Management System Application operations. When a request is received from the Controller, the Service layer performs the necessary actions. For example, when creating a SignUp User , SignIn User , Create Task , Update Task , Delete Task etc. The Service layer validates the input data, generates a unique identifier, and interacts with the data access layer.

## Data Access Layer
___
> The Data Access layer is responsible for interacting with the MySQL database to perform CRUD operations on the data. It uses SQL to map Java objects to database tables and execute SQL queries.

## Security and Authentication
___
> In this application, security is a top priority, ensuring the confidentiality and integrity of user data. To safeguard user passwords, I have implemented encryption mechanisms, adding an extra layer of protection against unauthorized access. Additionally, each user action, such as CRUD operations on tasks, is fortified with an authorization token. This token is issued upon successful sign-in, acting as a secure passkey for authenticated users. This robust security infrastructure is designed to fortify the project, transforming it into a reliable and secure task management system. Users can perform their tasks with confidence, knowing that their data is safeguarded by advanced encryption and authentication measures.


## Database
___
> The MySQL database stores Task Management System Application data, including  SignUp User , SignIn User , Create Task , Update Task , Delete Task etc.

## Response
___
> After the data operation is completed, the response flows back through the layers in the reverse ordersEntity. The Service layer receives the response from the Data Access layer, performs any necessary post-processing or formatting, and sends it back to the Controller.

## Controller Response
___
> The Controller layer receives the response from the Service layer and returns an appropriate HTTP response to the client, indicating the success or failure of the requested operation.



## Summary
___
This is a README file for explain the details about the project. This is a Task Management System Application project which is used to SignUp User , SignIn User , Create Task , Update Task , Delete Task etc. In this project we can perform the following functions given below :-

* SignIn User.
* SignUp User.
* SignOut User.
* Create a task.
* Get all tasks.
* Get task by Id.
* Update a task.
* Delete a task.


## Installation and Usage
___
* Clone the repository to your local machine.
* Make sure you have Java and Maven installed.
* Make sure you have MySQL workbench installed.
* Set up the database according to the configuration in the application properties file.
* Run the application using your preferred IDE.
* Access the API endpoints using tools like Postman , Swagger or your web browser.

## :frowning_man: Author
___
Rahul Chaurasiya
* Github : [@irahulchaurasiya](https://github.com/irahulchaurasiya)


## :handshake: Contributing
___
Contributions, issues & feature requests are  welcome!

Feel free to contact me at the above github link.

## Show your Support
___
Give a :heart: if you liked this project.

## :memo: License
___
Copyright :copyright: Rahul Chaurasiya.

This project is licensed for ResoTech Solutions.

___
This README was generated with :heart: by Rahul Chaurasiya
