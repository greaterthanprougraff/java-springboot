# Latest Updates
## Day 2
Added CRUD operations in a new controller file (GreetingController.java). The controller uses the below Spring annotations:
- @RestController - indicates GreetingController is a REST controller.
- @RequestMapping - defines the url /greeting is where our controller will be called under.
- @GetMapping - used for GET requests. Can retrieve the names by searching by ID (ex. /greeting/0) and return "Hello, <name>!".
- ResponseEntity - Controls what kind of response is returned based on the response (invalid input, missing new name, invalid command, success).
- @PostMapping - used for POST requests. Requires a name with ID as optional under /greeting. If the ID value is available it will add to that ID; if the ID is taken or not provided, it will add to the next available value and inform the user if the requested ID was unavailable.
- @PutMapping - used for PUT requests. Requires a new name and ID under /greeting.
- @DeleteMapping - used for DELETE requests. Requires ID under /greeting/{id}.

Additionally created NameEntry.java to represent a name entry with id and name. The id field is now Integer to allow optional input for POST requests.

## Day 1
Added basic Spring Boot application with a Hello World at http://localhost:8080/hello when ran using @GetMapping.