# Design Document #

## Specification ##

Our goal is to create an app that is tailored to UofT students, allowing them to browse restaurants and study spots on the St. George Campus. The app allows students to leave reviews and view the reviews of other students for each location.

-   To browse the app, users can either create an account, login, or continue as a guest (no account).

### All users should be able to: ###

-   View a list of study and food locations recommended to them.

-   Search locations, and use the provided filter to narrow their search for a location.

-   Use the interactable map to browse locations near them.

### All users with an account should be able to: ###

-   Bookmark a location for future viewing

-   Leave a review and rating for each location

### Locations ###

-   Each location displays information regarding the location (address, name of location).

-   Food location includes the food type, dine-in/take out options and the price range

-   Study location includes whether it is indoors or outdoors and if there are study rooms available

## Functionality added between phase 0 and phase 1 ##

The app now has an Android UI. The user is now able to use the interactable map to  browse locations at the St. George campus.

## UML Diagram ##

TO DO, if we want to add this in.

## Major decisions made by our group: ##

### Clean Architecture
**_How does our project adhere to Clean Architecture?_**
- The code is independent of the Android UI, and external agency and of the database (?)

**Scenario walk-through:**
    Upon opening the app, a client interacts with the software through an Android UI. When a client signs-in...

### Solid Principles
_**How is our project consistent with the SOLID design principles?**_

- Single-Responsibility Principle:
- Open- Closed Principle:
- Liskov Substitution Principle:
- Interface Segregation Principle:
  - Our Serializer interface is kept small, only defining the two crucial methods 
  for serialization 
- Dependency Inversion Principle:
  - In general, our entities such as a RegisteredUser do not know about for example the Android UI, any use cases
  or controllers. Instead, the CommandLine generates an instance of the InputController and InputGateway. 
  The InputController and InputGateways then generate instances of an AccountManager and an AccountManager is able to 
  instantiate a new RegisteredUser. This flow illustrates how our code only points inwards, consistent with the 
  dependency rule
  

## Packaging ##

(Which packaging strategies did we consider? Which did we end up using, and why?)

During our refactoring process, we first considered packaging by feature. However, 
this proved to be difficult since there were a lot of files that shared similar attributes.
We ended up packaging by the layers of clean archetecture(enities, use cases, controllers) because it was more efficient
(used the crc cards and report from phase 0 for reference), and it can keep us all in check of fulfilling the clean 
architecture model.
## Design Patterns ##

(Which design patterns did we implement?)

## Use of Github Features ## 

During our implementation of Phase 1, our team made better use of branching in Github. Instead of each team member
working off of their own branch like we did during Phase 0, our team instead branched by feature. For example, we had a 
branch dedicated to Serialization and upon second thought, the Serialization branch could have had two other branches 
for each entity that was serialized. We also used the issues feature in Github which made it easy to highlight what 
needed our attention.

## Progress Report ##

(open questions we are struggling with)

(what worked well so far)

(what each group member has been working on and plans to work on next)