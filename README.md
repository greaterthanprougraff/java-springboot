# Latest Updates
## Day 4
Added Lombok and logging features. Here is a breakdown of what was added:
### Lombok
- @Getter - adds getter capabilities for constructor, reducing code required.
- @Setter - adds setter capabilities for constructor, reducing code required.
### Logger
- @Slf4j - adds logging capabilities to log all major actions done. This makes tracking actions much easier to follow.
## Day 3
Added unit tests using JUnit. This was done by utilizing these features:
- JUnit - unit testing framework for Java.
- MockMvc - provides mocking for testing Spring applications.
- @SpringBootTest - simulates running a Spring Boot application and is used for testing.

## Day 2
Added CRUD operations in a new controller file (GreetingController.java). The controller uses the below Spring annotations:
- @RestController - indicates GreetingController is a REST controller.
- @RequestMapping - defines the url /greeting is where our controller will be called under.
- @GetMapping - used for GET requests. Can retrieve the names by searching by ID (ex. /greeting/0) and return "Hello, <name>!".
- ResponseEntity - Controls what kind of response is returned based on the response (invalid input, missing new name, invalid command, success).
- PathVariable - sets the URL path to the ID - greeting/1 will go to ID 1.
- @PostMapping - used for POST requests. Requires a name with ID as optional under /greeting. If the ID value is available it will add to that ID; if the ID is taken or not provided, it will add to the next available value and inform the user if the requested ID was unavailable.
- @RequestBody - converts the incoming JSON of the name/ID into a Java object that will be used in the method to add to the list of names.
- @PutMapping - used for PUT requests. Requires a new name and ID under /greeting.
- @DeleteMapping - used for DELETE requests. Requires ID under /greeting/{id}.

Additionally created NameEntry.java to represent a name entry with id and name. The id field is now Integer to allow optional input for POST requests.

## Day 1
Added basic Spring Boot application with a Hello World at http://localhost:8080/hello when ran using @GetMapping.