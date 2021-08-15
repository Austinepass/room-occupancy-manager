# Room Occupancy Optimization Manager

A Spring Boot application for allocating rooms to customers based on the amount they are willing to pay.
High paying customers will be allocated to premium rooms while low paying ones will be allocated to the economy rooms.

### Guide
This guide illustrates how to run the project and tests:

* Download or clone this project to your favourite IDE. Intellij and NetBeans are recommended.
* Ensure your IDE has [maven](https://maven.apache.org/download.cgi) installed.
* Run the project with the green run button or via the terminal with the command `./mvnw clean install`, which installs the `.jar` file 
  in the `target` directory of this repository. Cd into the `target` directory and run `java -jar room-occupancy-manager-0.0.1-SNAPSHOT.jar`.
  The app should start running locally on port 8080 ie `localhost:8080`.
* To run the test cases, navigate to the test directory and open the test classes. Click on the green play button by the left of the class or method names.

Note: `./mvnw clean install` will run all the test cases as well as install or generate the `.jar` file. 
##### Making a request
The endpoint for optimizing the rooms is `/api/v1/rooms/optimize` and expects a JSON body like so:

`{
  "potentialGuests": [],
  "freePremiumRooms": 3,
  "freeEconomyRooms": 3 
}`

Where `potentialGuests` is an array of numbers, `freePremiumRooms` and `freeEconomyRooms` are both integers.

The above endpoint can be consumed by any rest api client. For testing purposes, Postman is recommended.

Finally, the response will be in this format:

`{  
  "occupiedPremiumRooms":  3,  
  "occupiedEconomyRooms":  3,  
  "revenuePremium":  738,  
  "revenueEconomy":  167.99  
}`
### Cheers!!!







