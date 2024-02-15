### Design 1
![](images/jchen3115-design.png)
## Pros
- This design successfully meets all the criteria outlined for Assignment 5.
- The `Location` class is effectively designed to retrieve the cost of living information from the database.
- It also facilitates user authentication, allowing them to log in and save their data.

## Cons
- As discussed, we may not need separate classes for current job (`curJob`) and job offers (`jobOffer`). It might be more efficient to merge these into a single `JobOffer` class, which could include both `curJob` and a list of `jobOffer` attributes. This consolidation could be managed within a `JobOfferManager` class, streamlining the architecture and reducing redundancy.
-  We could introduce an additional class, `JobOfferManager`, to serve as an intermediary between `User` and `JobOffer`. This class would be responsible for facilitating the entry and editing of both current job positions and job offers.

### Design 2
![](images/shong422-design.png)
## Pros
- This design meets all the criteria outlined for Assignment 5.
- The design has all the necessary classes that interacts with each other to meet the requirements.
- The design is concise and does not unnecessary classes that would have made the UML Class Diagram more complex than it should be.

## Cons
- The association classes JobOffer and CurrentJob could have been a boolean in the JobDetail class instead.
- The 'Location' could have been implemented to effectively retrieve the cost of living information.

### Design 3

### Design 4

### Team Design

### Summary
