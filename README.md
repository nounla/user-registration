# user-registration
	This module is developed for User Registration process, using the In-memory DB, RESTful and Spring 
Features of the module:
	1) Adds a new user
	2) Deletes a user
	3) Lists all the registered users

Technologies used to implement:
	Java 1.7, 
	Spring 4.0, 
	JAX-RS 2.0 (RESTful Web ServiceS), 
	Hibernate 4.3, 
	H2 in-memory database, 
	Tomcat Server 7, 
	Mavens, 
	Eclipse.

For unit testing:
	junit 4.4, 
	easymock 3.3.

Integration-test to test the interface end to end:
	Springtest 2.5. 

For logging:
	log4j. 

Build and Deployment instrutctions:
	1) mvn clean package (its create user-registration.war file). 
	2) Deploy war filr from step 1 to web server. 

Testing REST Endpoints:

1. To add a user to system
	URL:http://localhost:9080/user-registration/user/add
	Method: POST
	Content-type:application/json
	Sample data:{"name":"xxx","email":"mml1@gmail.com"}

	If a user is added to system, will see the response below

	{"code":1,"message":"User added Successfully !"}

	Note: the above method is POST, we need to use some rest client/plugin to test the end point
	we can add 'Poster' plug-in in the google chrome to post data to rest end points.


2. To get list of all registered users

	URL:http://localhost:9080/user-registration/user/list
	Method:GET
	Sample Response:[{"id":1,"name":"vijay1","email":"mml1@gmail.com","registeredDate":"08-02-2015"},{"id":2,"name":"vijay2","email":"mml2@gmail.com","registeredDate":"08-02-2015"},{"id":3,"name":"vijay3","email":"mml3@gmail.com","registeredDate":"08-02-2015"}]

3. To delete user from system

	URL: http://localhost:9080/user-registration/user/delete/{Id}
	Method:GET
	Example: http://localhost:9080/user-registration/user/delete/2

	if user is deleted from the system, you will see below response

	{"code":2,"message":"User deleted Successfully !"}


Note: Regarding InMemoery DB Persistnece implementation,able to save the data to file/disk before JVM/application shutdown. But unable to load it back to use when the application re-starts.
