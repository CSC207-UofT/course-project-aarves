Specification
=============

We are building an app like Yelp but tailored to UofT students that can recommend restaurants or study spots on the St. George campus. Starting the application gives the user the option to either log in, create an account, or continue as a guest (no account).  A registered user can be identified by their username and password and will have access to signed-on only functionality such as bookmarking favourite locations and leaving a review and rating. Through the app, all users can search for either a food or study location, specified for through filters. Users can read reviews, view the average rating for each result and hours of service. Each food location includes the food type, dine-in/take out options and the price range. Each study location includes whether it is indoors or outdoors and if there are study rooms available. Within the food or study location filter, users can narrow their search through filters for certain food types, dine-in/take out and price ranges for food locations. For study locations, users can also specify for indoor/outdoor study spaces or study room availability.

CRC Model
=========

From the Model, we can see that there are the entity classes (Map, Users), the use case classes (AccountCreator, filters based on Location's child classes) and the controller (see scenario.java). Each class has its own responsibility, the abstract classes are open for extension but cannot be modified, and the subclasses are shown to extend from the parent classes and not modify the original attributes [look at the User and Location classes and its respective child classes].

Scenario Walkthrough
====================

Using the CRC cards from previous discussion, the scenario presented flows from card to card. On one hand, an entire section dedicated to accessing the app in the first place is covered by the CRC cards specified. App access is brought about by the interactions of AccountCreator, AccountManager, and the User (along with its subclasses) objects. On the other hand, we've got the bulk of the program being interacted with by User and RegisteredUser (seeing as we've passed the app access section) who interact with Location (and its subclasses) to return relevant information. Any and every thing the user inputs is passed through a class which bridges the back end to the front end, and these "bridges" are covered in the CRC.

Skeleton Program
================

The skeleton program can be found on the course project GitHub, in src/main.java and every class/interface has their own file. The skeleton program consists of the following files: AccountCreator.java, Account Manager.java, FoodLocation.java, FoodMap.java, GuestUser.java, Location.java, Map.java, RegisteredUser.java, Review.java, ReviewManager.java, Scenario.java, StudyLocation.java, StudyMap.java, and User.java. Moreover, we have tested the code in IntelliJ using Scenario.java to check if our code compiles by using the Scenario Walkthrough as inspiration. Also, we have created unit test for class AccountManager and tested whether if all methods in the AccountManager class work as expected or not.

Individual Progress
===================

Each group member contributed to the Specification and CRC Cards. For the skeleton program, this is a list of what each group member has worked on. Other group members have touched into other classes to fix bugs, but this is a list of the classes we developed and added docstrings for:

Vaishnavi: Abstract class Location and it's children classes FoodLocation and StudyLocation.

Erica: AccountManager and added docstrings for AccountCreator.

Syed: Abstract class User and its' child GuestUser. Worked on FoodLocation as well.

Ash: Review class and ReviewManager, and also testing our scenario walkthrough in Scenario.java.

Anthony: Git stuff, fixed reviewId issue, and worked on Map, Point, FoodMap, and StudyMap.

Rebecca: AccountCreator to create accounts, RegisteredUser to store reviews and information about a user, worked a bit on ReviewManager to add and delete reviews. Unit test for AccountManager.

What each group member plans to work on next:

Vaishnavi: Package organization within our project.

Erica: Considering how we can develop more controllers.

Syed: Work on the UI and more on the Account classes.

Ash: Implementation of MapBox API.

Anthony: A controller for map information, MapController.

Rebecca: Storage (currently use cases are storing entities), so work on figuring out how where to store objects and implementing.

Benefits to the design/progress with code
=========================================

By adhering to Clean Architecture, we can test business rules (I.e., entities and use cases) for our skeleton program without worrying about needing to implement the outer layers, rather we can implement a temporary Command Line Interface in its place. By having classes separated with single responsibilities, this allows group members to easily modify and test each class without any conflict.

Questions we are Struggling with
================================

- How and where to get map data

- Where should all objects be stored in the program? Some sort of software class outside any of the clean architecture layers or should objects be stored by objects of the adjacent outer class? (Currently it is the latter where use cases are storing entities, etc.)
