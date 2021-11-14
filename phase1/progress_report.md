# Design Document #

## Specification ##

[App name] is a location-browser app tailored to UofT students looking for places nearby the St. George Campus to grab food from, or study at. Users can share their opinions on places in the form of a review, and can also view what others think as well, thus helping them decide whether it's a place they'd like to visit.

- To browse the app, users can either create an account, login, or continue as a guest (no account).

[IMAGE OF MAIN MENU]

### Permissions based off login-type

| User-type  | Permissions |
|------------|-------------|
| Guest users can...     | <ul><li>View a randomly selected food and study spot of the day.</li><li>Search for locations, and further tune their search using filters.</li><li>Use the interactive map to browse locations in their vicinity.</li></ul>            |
| Registered users can... | <ul><li>Do everything a guest user can do.</li><li>Bookmark locations for easy access in the future.</li><li>Leave reviews and a rating for locations.</li></ul>            |

[IMAGE OF FOTD/SOTD]

[IMAGE OF MAP]

[IMAGE OF A REVIEW]

### Locations ###

Across both types of locations, general information such as name, address, and hours are provided.

| Location-type | Information-shown |
|---------------|-------------------|
| Food          | <ul><li>Food type (i.e. Japanese).</li><li>Whether it's dine-in or takeout.</li><li>Price range.</li></ul>                  |
| Study         | <ul><li>Whether it's indoors or outdoors.</li><li>Study room availability (if indoors).</li></ul>                  |

[IMAGE OF A LOCATION]

## Changes From Phase0 ##

From phase 0 to phase 1, we took the command-line interface and built upon it to have an Android app complete with a GUI. With this addition, the user can now use an interactive map to browse locations. Below are demonstrations of the benefits this move to Android has conveyed:

| Being Shown  | Demonstration |
|--------------|---------------|
| Login        | INSERT GIF    |
| Registration | INSERT GIF    |
| Map browsing | INSERT GIF    |

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

| SOLID Principle       | Example |
|-----------------------|---------|
| Single responsibility |         |
| Open/closed           |         |
| Liskov substitution   |         |
| Interface segregation | Our Serializer interface is kept small, only defining the two crucial methods for serialization         |
| Dependency inversion  | In general, our entities such as a RegisteredUser do not know about for example the Android UI, any use cases or controllers. Instead, the CommandLine generates an instance of the InputController and InputGateway. The InputController and InputGateways then generate instances of an AccountManager and an AccountManager is able to instantiate a new RegisteredUser. This flow illustrates how our code only points inwards, consistent with the dependency rule        |

## Packaging ##

_**Which packaging strategies did we consider? Which did we end up using, and why?**_

During our refactoring process, we first considered packaging by feature. However, 
this proved to be difficult since there were a lot of files that shared similar attributes.
We ended up packaging by the layers of clean architecture(enities, use cases, controllers) because it was more efficient
(used the crc cards and report from phase 0 for reference), and it can keep us all in check of fulfilling the clean 
architecture model. We are currently unsure about how to organize our serializer files(the Interface, AccountSerializer, 
ReviewSerializer), because it does not cleanly meet any of the actual layers of clean architecture without a violation.
## Design Patterns ##

- Template Method Design Pattern:
  - Since RegisteredUser and GuestUser classes have a bunch of similarities between them, we decided to implement the
  Template Method Design Pattern to demonstrate Clean Architecture. The abstract class User contains a Template Method
  called Features and inside the Template Method are the variant and invariant steps. The invariant steps are the
  common methods between the two subclasses such as; addBookmark(), deleteBookmark(), viewBookmarks(), viewReviews()
  and they are implemented in the abstract class User. Whereas, the variant steps; getUsername(), getReviews(), 
  addReview(), deleteReview() are left unimplemented in the abstract class User and are then implemented by 
  RegisteredUser.


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
