# project2-DT
Backend repo for project2 created by Andrew, Yasmine, Gray, Gerardo, Cory.

## What Is Barker?
Barker is a full stack web application that enables shelters to input dogs available for adoption. These dogs can be viewed, ‘liked’, and ‘disliked’ by users interested in adopting a dog. Users can create an account, input their dog preferences, view a series of dogs that match their preferences, and view all previously ‘liked’ dogs. They can also view a series of dogs one at a time, and, if one chooses to ‘swipe’ left, that dog will not be shown again. If they ‘swipe’ right, that dog will be added to the list of ‘liked’ dogs that are viewable on a separate ‘liked dogs’ page. Users can also request adoption of a particular dog which will put them in contact with the applicable shelter. Through this app, shelters can create an account and create dog profiles that are viewable by a user. If a dog gets adopted, the shelter can modify the dog profile to show that the dog is now adopted.

## Technologies Used
    - Spring Boot v2.4.1
    - Postgresql v13.1
    - Maven v4.0.0
    - Tomcat v9.0.39
    - AWS EC2
    - Jenkins
    - Git

## Features
- As a shelter, I can upload dogs available for adoption, increasing the chances of getting that dog adopted.
- As a user, I can browse dogs that I am interested in adopting.
- As a user, I can add dogs to my liked list for later viewing.
- As a user, I can add dogs to my disliked list so that I will not be shown them again.
- As a user, I can  insert dog preferences to be shown dogs that are relevant to their desired adoption preferences.

#### Fabulous Future Features
- When a user decides to adopt a dog, we will send the application directly to the shelter for the user.
- Login in with Facebook, Google, and Apple.
- The ability for shelters to add animals other than just dogs, i.e. reptiles, cats, birds etc.
- The ability for users to be able to select additional animals as preferences.
- Implement machine learning to better provide users with the animals that they like best.
- Geolocation so users are seeing shelters that are near them.

## Getting Started
#### Command Line
- Make sure you have a local tomcat server running
- ```git clone https://github.com/2011JavaReact/project2-DT.git```
- ```cd project2-DT```
- ```mvn clean package```
- ```cp target/Barker-api.war ~/path/to/tomcat/instance/webapps```
- I like to restart the tomcat server after a copy, but that should not be necessary...
- I suggest making an alias that includes steps 3,4 and the restart into one command like ```mvn_build```
- For example: ```alias mvn_build='mvn clean package && cp target/Barker-api.war ~/path/to/tomcat/webapps && ~/path/to/tomcat/bin/./shutdown.sh && .~/path/to/tomcat/bin/./startup.sh'```
- The easiest way to run the application though is through an IDE.

#### IDE
- ```git clone https://github.com/2011JavaReact/project2-DT.git```
- Open your IDE to the proper directory/workspace
- Use your IDE to run the program with an embedded tomcat server.

## Usage
- If you started the application on a local tomcat server like in the command line section above, you can hit the api at localhost:8080/Barker-api/{endpoint}. 
- If you started the application via an IDE then you can hit the api at localhost:8080/{endpoint}
- In the endpoint examples, ```{url}``` is either the localhost:8080/Barker-api or localhost:8080 depending on how you started the application
#### Endpoints that are available to be hit are below
##### Login Endpoints
    - {url}/login (POST) - authentictes a user.
    - {url}/shelterLogin (POST) - authenticates a shelter user.
##### User Endpoints
    - {url}/users (GET) - gets all the users
    - {url}/users/{id} (GET) - gets a user by id
    - {url}/users/{userId}/dogs/{dogId}/like (GET) - likes a dog with an id of dogId and and associates the like with a user that has an id of userId
    - {url}/users/{userId}/dogs/{dogId}/unlike (GET) - removes a dog from a users liked list. 
    - {url}/users/{userId}/dogs/{dogId}/dislike (GET) - adds a dog to a user's disliked dogs list.
    - {url}/users/{userId}/dogs (GET) - returns the dogs that are not adopted, not liked, and not disliked by the user with an id of userId.
    - {url}/update (PUT) - updates a user's preferences as well as username and email.
##### Shelter Endpoints
    - {url}/shelters (GET) - returns a List of all the shelters in the DB
    - {url}/shelters/{id} (GET) - returns a shelter with the id of id.
    - {url}/shelters (POST) - create a new shelter.
    - {url}/shelters/{shelterId}/dogs (POST) - creates a new dog associated with the shelter with an id of shelterId.
    - {url}/shelters/update (PUT) - updates a shelters attributes.
##### Dog Endpoints
    - {url}/dogs (GET) - returns a list of all the dogs in the database regardless of liked/disliked status.
    - {url}/dogs/{id} (GET) - returns a dog with the id of id.
    - {url}/dogs/breeds (GET) - returns a List of dog breeds in the database.
    - {url}/dogs/update (PUT) - updates a dog's attributes.


# Contributors
#### - Andrew, Yasmine, Gray, Gerardo, Cory

# License
This project uses the following license: MIT License<br>
Copyright (c) 2020 2011JavaReact
