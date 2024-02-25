# Test Plan

**Author**: Jiakang Chen

## 1 Testing Strategy

### 1.1 Overall strategy
- Our testing strategy aims to validate the integrity and functionality of the developed software across unit, integration, system, and regression testing phases.
- Unit testing:
    - activities:
        - Make some tests for individual functions and methods
        - Ensure the units are isolated
    - Responsible person: Team 139
- Integration testing:
    - activities:
        - Testing the interactions between different modules
        - Ensure all components operated corrected when they are integrtaed
    - Responsible person: Team 139
- System testing:
    - activities:
        - Carry out comprehensive tests that simulate real usages
        - Test the perfromance of the applications
        - Ensure the completed application meet the the requirments in the assignments
    - Responsible person: Team 139
- Regression testing:
    - activities:
        - Will re-run the above testing when there are new updates to the applications
        - Verify that the application remains unaffected by the implementation of new changes or features.
    - Responsible person: Team 139

### 1.2 Test Selection
- We will test our application using both black-box and white-box techniques to identify both potential functional and structural issues.
- Unit Testing: will primarily use white box techniques. 
- Integration Testing: will use a mix of white- and black-box techniques.
- System Testing: will primarily use black box techniques.

### 1.3 Adequacy Criterion
- Use a mix of functional and structural coverage at different testing level
- Unit testing:
    - Will use both statement and branch converage to evaulate our unit testing
    - Criteria: Focus on the core functionality of the codebase
- Integration testing:
    - In integration testing, we will use functional coverage to verify the interactions between modules
    - Criteria: Each use case should have more than one test case
- System testing:
    - For system testing, functional coverage will be implemented to evaluate the overall system's performance and reliability
    - Criteria: Should cover all the requirments in the assignments and include the corner cases
- Regression testing:
    - Identify the segments of the software most susceptible to changes.
    - Criteria: Re-execute all previously mentioned tests to confirm that modifications do not compromise the application's functionality.

### 1.4 Bug Tracking
- GitHub: Use GitHub for tracking of potential changes, bugs, and enhancement requests
- Scheduled review sessions: Set up regular meetings to assess reported bugs and proposed enhancements
- Task assignment: Assign team members to deal with identified issues
- Collaborative review process: Other team members will periodically evaluate the status of bugs and enhancement requests

### 1.5 Technology
- JUnit will be use as our technology for unit testing
- Selenium will be deployed for integration and system testing phases.

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*
| Purpose              | Steps               | Expected Result     | Actual Result | Pass/Fail | Additional Information |
|----------------------|---------------------|---------------------|---------------|-----------|------------------------|
| User registrations    | 1.  Navigate to the sign-up page<br>2. Enter name: user1， pd: 123 <br>3. Submit the registration form | User creates an account |              |           |            |
| User fails to register| 1.  Navigate to the sign-up page<br>2. User enter name: user1, pd: 123 <br>3. Submit the registration form | Show error message indicating that the user already exists|              |           |            |
| User log in with correct registration info| 1. Navigate to the login page.<br>2. Enter name: user1， pd: 123<br>3. Click the login button | User enters in the main menu |               |           |   |
| User log in with wrong name| 1. Navigate to the login page.<br>2. Enter name: user2， pd: 123<br>3. Click the login button | Show sign up message|               |           |   |
| User log in with wrong password| 1. Navigate to the login page.<br>2. Enter name: user1， pd: 124<br>3. Click the login button | Show error message indicating that the password is wrong|               |           |   |
| User could enter their current job details| 1. Click enter current job detail in the main menu <br>2. Fill in all the job details fields | User could enter the job details in the new page |               |           |   |
| User could edit their current job details| 1. Click edit current job detail in the main menu <br>2. Make some changes | User could see the current job details and then can make some changes |               |           |   |
| User could not edit their current job details if it is not entered before| 1. Do not have current job detail <br> 2. Click edit current job detail in the main menu | Show error message indicating that no current job|               |           |   |
| User could enter and save the current job details | 1.  After entering the current job details <br> 2.Click save button | User's current job details are saved and displayed correctly when viewing  |               |           |   |
| User could edit and save the current job details | 1.  After editing the current job details <br> 2. Click save button | User's current job details are saved and displayed correctly when viewing  |               |           |   |
| User could enter and exit without saving | 1.  After entering the current job details <br> 2. Click exit button | User's current job details are not saved  |               |           |   |
| User could edit and exit without saving | 1.  After editing the current job details <br> 2. Click exit button | User's edits are not saved  |               |           |   |
| User could not save without filling all required information when entering current job detail| 1.  Do not fill all information, leave salary blank <br> 2. Click save button | Show error message indicating that missing information |               |           |   |
| User inputs locations in the job details page| 1.  Enter/Edit job details <br> 2. Input city: Dallas, state: Texas| No error message |               |           |   |
| User inputs incorrect locations in the job details page| 1.  Enter/Edit job details <br> 2. Input city: test, state: test| Show error message within location field |               |           |   |
| User inputs a numeric value in the yearly salary field | 1.  Enter/Edit job details <br> 2. Input 10000 in the yearly salary field| No error message within yearly salary field |               |           |   |
| User inputs a non-numeric value in the yearly salary field | 1.  Enter/Edit job details <br> 2. Input "test @!" in the yearly salary field| Show error message within yearly salary field |               |           |   |
| User inputs a numeric value in the yearly bonus field | 1.  Enter/Edit job details <br> 2. Input 1000 in the yearly bonus field| No error message within yearly bonus field |               |           |   |
| User inputs a non-numeric value in the yearly bonus field | 1.  Enter/Edit job details <br> 2. Input "test @!" in the yearly bonus field| Show error message within yearly bonus field |               |           |   |
| User inputs a numeric value in the number of stocks field | 1.  Enter/Edit job details <br> 2. Input 1000 in the number of stocks field| No error message within number of stocks field |               |           |   |
| User inputs a non-numeric value in the number of stocks field | 1.  Enter/Edit job details <br> 2. Input "test @!" in the number of stocks field| Show error message within number of stocks field |               |           |   |
| User inputs a numeric value in the Home Buying Program field | 1.  Enter/Edit job details <br> 2. Input 5 in the Home Buying Program field| No error message within Home Buying Program field |               |           |   |
| User inputs a non-numeric value in the Home Buying Program field | 1.  Enter/Edit job details <br> 2. Input "test @!" in the Home Buying Program field| Show error message within Home Buying Program field |               |           |   |
| User inputs out of range value in the Home Buying Program field | 1.  Enter/Edit job details <br> 2. Input -120/20 in the Home Buying Program field| Show error message indicating that out of range within Home Buying Program field|               |           |   |
| User inputs a numeric value in the holiday field | 1.  Enter/Edit job details <br> 2. Input 5 in the holiday field| No error message within holiday field |               |           |   |
| User inputs a non-numeric value in the holiday field | 1.  Enter/Edit job details <br> 2. Input "test @!" in the holiday field| Show error message within holiday field |               |           |   |
| User inputs out of range value in the holiday field | 1.  Enter/Edit job details <br> 2. Input -2/22 in the holiday field| Show error message indicating that out of range within the holiday field|               |           |   |
| User inputs a numeric value in the internet stipend field | 1.  Enter/Edit job details <br> 2. Input 30 in the internet stipend field| No error message within internet stipend field |               |           |   |
| User inputs a non-numeric value in the internet stipend field | 1.  Enter/Edit job details <br> 2. Input "test @!" value in the internet stipend field| Show error message within internet stipend field |               |           |   |
| User inputs out of range value in the internet stipend field | 1.  Enter/Edit job details <br> 2. Input -2/100 in the internet stipend field| Show error message indicating that out of range within the internet stipend field|               |           |   |
| User could enter job offers | 1.  Click enter job offers in the main menu|  User could enter job offer details in the new page|               |           |   |
| User could enter job offers and save | 1.  Click enter job offers in the main menu <br> 2. Click save button|  User's job offers are saved and displayed correctly when viewing|               |           |   |
| User could not save without filling all required information when entering job offers | 1.  Enter job offers in the main menu <br> 2.Leave salary blank <br>3. Click save button|  Show error message indicating that missing information|               |           |   |
| User could enter job offers and exit without saving | 1.  Click enter job offers in the main menu <br> 2. change salary <br> 3. Click exit button|  Job offer is not saved|               |           |   |
| In the job offer page, user could enter another job offers| 1.  Click enter job offers in the main menu <br> 2. Click enter another job offer button|  User stays in the same page but all info are cleared|               |           |   |
| In the job offer page, user could return to new menu| 1.  Click enter job offers in the main menu <br> 2. Click return to main menu button|  User return to main menu page|               |           |   |
| In the job offer page, user could compare offer after saving| 1.  Click enter job offers in the main menu <br> 2. Click save button <br> 3. Click compare job offer button|  User could go to compare job page|               |           |   |
| In the job offer page, user could not compare offer before saving| 1.  Enter job offers in the main menu <br> 2. Click compare job offer button|  Show error message indicating that current job offer is not saved|               |           |   |
| User could adjusting comparison setting| 1.  Click adjust comparison setting <br> | User navigates to the comparison setting page |               |           |   |
| User inputs a non-numeric value in the yearly salary field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the yearly salary field| Show error message within yearly salary field |               |           |   |
| User inputs a non-numeric value in the yearly bonus field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the yearly bonus field| Show error message within yearly bonus field |               |           |   |
| User inputs a non-numeric value in the number of stock field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the number of stock field| Show error message within number of stock field |               |           |   |
| User inputs a non-numeric value in the home buying program field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the home buying program field| Show error message within home buying program field |               |           |   |
| User inputs a non-numeric value in the holiday field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the holiday field| Show error message within holiday field |               |           |   |
| User inputs a non-numeric value in the internet stipend field when adjusting comparison setting| 1.  Click adjust comparison setting <br> 2. Input "test @!" in the internet stipend field| Show error message within internet stipend field |               |           |   |
| User could compare job offers | 1.  User at least has one job offer <br> 2. Click compare job offers| User could see a list of job offers including the current job if presents |               |           |   |
| User could not compare job offers if there is no job offers| 1. No job offer <br> 2. Click compare jobs| Show error message indicating that missing job offers |               |           |   |
| User could trigger comparison if there are more than 2 job offers| 1. Select two job offers <br> 2. Click compare select jobs| User could see the  comparison of two job offers |               |           |   |
| User could perform another comparison| 1. Click another comparison in the comparison page| User navigates back to the job list and could select two job offers |               |           |   |
| User could could return to the main menu| 1. Click return to main menu in the comparison page| User navigates to the main menu |               |           |   |
| System calcualtes the job score correctly| 1. Print the job scores and compare them with those calculated by hand| The results are the same |               |           |   |
| System updates the job score correctly when user changes the job details| 1. Change salary to 1 for one job offer <br> 2. Click compare job offers <br> 3. Check job scores| System updates job scores |               |           |   |
| System updates the job score correctly when user changes the weight| 1. Change weight of salary to 2 <br> 2. Click compare job offers <br> 3. Check job scores| System updates job scores |               |           |   |
| If two job offers have the same job scores, the ranking is based on the alphabetical order of the job title| 1.Create two job offers which have the same job scores but different titles <br> 2. Click compare job offers <br> 3. Check the rank of these two job offers| System updates job list correctly |               |           |   |
| The job offer list will update when user enters a new job offer| 1.Create one job offer and save <br> 2. Click compare job offers <br> 3. Check the new job offer| The offer list updates the new offer correctly |               |           |   |
| The job offer list will update when user enters the current job| 1.Enter current job and save <br> 2. Click compare job offers <br> 3. Check the current job| The offer list updates the current job correctly |               |           |   |
| The job offer list will update when user edits the current job| 1.Edit current job and save, change salary to 1 <br> 2. Click compare job offers <br> 3. Check the current job| The offer list updates the current job correctly |               |           |   |