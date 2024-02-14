1.  **When the app is started, the user is presented with the main menu,
    which allows the user to (1) enter or edit current job details, (2)
    enter job offers, (3) adjust the comparison settings, or (4) compare
    job offers (disabled if no job offers were entered yet1).**

To address the requirement, the `MainMenu` class in our UML diagram is
designed with functionalities for user registration and login, enhancing
user interaction. This class provides a navigational framework that
allows users to access key features: registering/logging in,
entering/editing current job details, submitting job offers, adjusting
comparison settings, and comparing job offers. The `User` class,
equipped with methods like `enterCurJob()`, `editCurJob()`,
`enterJobOffer()`, `adjustComparisonSet()`, and `compareJob()`,
directly implements the operations as described.

2.  **When choosing to enter current job details, a user will be shown a
    user interface to enter (if it is the first time) or edit all the
    details of their current job: title, company, etc**

To fulfill this requirement, the `User` class is linked with the
`curJob` class while the `curJob` is associated with `Job**`**
class. This design allows for the encapsulation of current job details
within a Job object, which the User can enter or edit. The `User`
class methods, potentially including `enterCurJob()` and
`editCurJob()`, facilitate interaction with the job details, such as
title, company, and other specified attributes.

3.  **Be able to either save the job details or cancel and exit without
    saving, returning in both cases to the main menu.**

The design employs a `curJob` class as an intermediary between the
`User` and the `Job` class for enhanced data management. If the user
saves the results, the system will save the current job information in
the `curJob` class and also update the `curJob` attributes in
`User` class. It is also equipped with a `cancelExit()` method,
enabling users to opt out of saving edits and exit without affecting
existing data. Furthermore, it includes a `returnToMenu()` function,
allowing for a smooth transition back to the `MainMenu` after editing
or cancelling.

4.  **When choosing to enter job offers, a user will be shown a user
    interface to enter all the details of the offer, which are the same
    ones listed above for the current job.**

To better align with this requirement, the design incorporates the
`JobOffer` class, similar to the `curJob` class and linked with the
`Job` class. This setup allows users to input details for job offers,
paralleling the information structure for `curJob`. Additionally,
within the `User` class, an attribute is designated to store all
entered job offers, thereby ensuring a seamless user experience in
managing both current and prospective job details.

5.  **When choosing to enter job offers, a user will be able to either
    save the job offer details or cancel.**

To fulfill this requirement, the design introduces a mechanism within
the JobOffer class that allows users to input details for job offers and
then decide whether to save these details or cancel the operation. This
is achieved through the implementation of methods for saving and
canceling within the `JobOffer` class. Specifically, a
`saveJobOffer()` method can be used to store the entered details and
update the attribute `jobOfferTree` in `User` class, and a
`cancelJobOffer()` method allows users to abort the process and the
attributes `jobOffer` will not save the changes.

6.  **When choosing to enter job offers, a user will be able to (1)
    enter another offer, (2) return to the main menu, or (3) compare the
    offer (if they saved it) with the current job details (if present)**

The `jobOffer` class has included these methods:

Entering another offer: Through a method named `enterAnotherJob()`,
enabling users to input details for additional job offers.

Returning to the main menu: Via a method called `returnToMenu()`,
allowing users to navigate back to the application\'s main interface.

Comparing offers with current Job: Through a method `compareJob()`,
activated after an offer is saved, facilitating comparison with current
job details if available.

7.  **When adjusting the comparison settings, the user can assign
    integer weights to yearly salary, yearly bonus and etc.**

In this UML diagram, I assume each User has a compareSetting attribute
linked to the `comparisonSet` class. This class provides methods like
adjustSalaryWeight(int), adjustBonusWeight(int), and others for setting
integer weights on job attributes such as yearly salary and bonus. These
functionalities allow users to personalize how job offers are compared
according to their preferences. The User could call the function
`adjustComparisonSet()` to update the setting for attribute `
compareSetting`.

8.  **When choosing to compare job offers, a user will be shown a list
    of job offers, displayed as Title and Company, ranked from best to
    worst (see below for details), and including the current job (if
    present), clearly indicated.**

A `compareJob` class is created to store the `jobList` including all
job offers and the current job. The jobList could be updated based on
the attributes `curJob` and `jobOfferTree` in `User` class. The
job list is sorted based on the `jobScore`. For practical application,
the sorted job offers could be displayed in a table format, highlighting
only the job title and company.

9.  **When choosing to compare job offers, a user could select two jobs
    to compare and trigger the comparison.**

A `compareJob` class maintains a list `jobTocompare`, which could
allow users to select to two jobs from the `jobList` to make the
comparison.

10. **When choosing to compare job offers, a user could be shown a table
    comparing the two jobs, displaying, for each job including title,
    company and etc.**

`compareJob` class maintains a list `jobTocompare`, which includes
two selected jobs for detailed comparison. holding a jobToCompare list
that includes two selected jobs for detailed comparison. And therefore
we don't need to show explicitly in this design.

11. **When choosing to compare job offers, a user could be offered to
    perform another comparison or go back to the main menu.**

The `compareJob` class is designed with functionality to facilitate
job offer comparisons. It includes a method named
`enterAnotherCompare`, allowing users to initiate a new comparison.
Additionally, navigating back to the application\'s main interface is
facilitated by the `returnToMenu` method**.**

12. **When ranking jobs, a job's score is computed as the weighted
    average of: AYS + AYB + (CSO/3) + HBP + (PCH \* AYS / 260) +
    (MIS\*12)**

The `calJobScores` method within the `User` class is designed to
calculate job scores using job details and user-specific comparison
settings. These scores are then stored as `jobScore` attributes in the
`Job` class for easy access and utility. The `CompareJob` class\'s
`jobList` uses these scores to automatically sort jobs.

13. **The user interface must be intuitive and responsive.**

As said in the assignment documents, it is not represented by the design
and will be dealt with in later GUI implementation.

14. **For simplicity, you may assume there is a single system running
    the app (no communication or saving between devices is necessary).**

This requirement is not explicitly indicated in the UML diagram. But
this design uses local data storage and centralizes all operational
logic within the application itself, ensuring a self-contained system
architecture. Additionally, we won't develop some features that require
external data exchange, such as sync mechanisms.
