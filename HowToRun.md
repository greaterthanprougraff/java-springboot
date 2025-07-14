# How To Run
The Spring Boot Application is ran through DemoApplication.java and can be run by (in VSCode) pressing the play button to Run Java. To access the application, you can use your browswer to go to http://localhost:8080/

## Greeting Controller
The greeting controller uses /greeting for all of its operations. Below is how to run GET, POST, PUT, and DELETE requests.

### GET Requests
To run a GET request you must use the ID number and add it to the URL. For example see the name under ID 0, you can go to http://localhost:8080/0 and receive the Hello, <name>! response. 

### POST Requests
To run a POST request you will be using something such as CURL, Postman, or Insomnia. For this and future examples, I will be using Insomnia. You will create a HTTP Request and set it to POST. Your URL will be set to http://localhost:8080/greeting and the body will look something like this:

```
{
	"id": "1",
  "name": "Joe"
}
```
One thing to note is that ID is not required, only the name is. If you want to specify which ID you want it to be under, you can specify it and it will put it under that ID. If the ID you specify is taken, it will put it in the next available number.

### PUT Requests
To run a PUT request you will be using something such as CURL, Postman, or Insomnia. You will need to set your HTTP Request to PUT. Your URL will be set to http://localhost:8080/greeting and the body will look something like this:

```
{
	"id": "1",
  "name": "Joe"
}
```
One thing to note is that ID and name are both required. This PUT command is for updating existing ID's with new names only. If the ID does not have a name accompanying it, it will not update the ID.

### DELETE Requests
To run a PUT request you will be using something such as CURL, Postman, or Insomnia. You will need to set your HTTP Request to PUT. Your URL will be set to http://localhost:8080/greeting/{id}. So for deleting id 0 it would look like this: http://localhost:8080/greeting/0. No body is required. Once ran it will delete the name associated with the id if there is a name attached to it.