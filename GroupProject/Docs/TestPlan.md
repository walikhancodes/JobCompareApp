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

## 2 Test Cases
| Purpose              | Steps               | Expected Result     | Actual Result | Pass/Fail | Additional Information |
|----------------------|---------------------|---------------------|---------------|-----------|------------------------|
| User could not save without filling all required information when entering current job detail| 1.  Click on enter current job <br> 2. Fill out the title with "SWE" and leave others blank <br> 3. Click on save button | Show error message: Cannot be empty | Show error message: Cannot be empty               | Pass          |   |
| User could enter their current job details and save| 1. Click on enter current job detail <br> 2. Fill in the fiels as followed: SDE, comp1, SF, 100, 10000, 1000, 1000, 10, 5, 50 <br> 3. Click on save button and click on enter current job again | Entered results are saved | Entered results are saved               | Pass          |   |
| User could edit their current job details and save| 1. Click on enter current job detail <br> 2. Fill in the fiels as followed: SWE, comp2, LA, 80, 20000, 2000, 2000, 5, 0, 0 <br> 3. Click on save button and click on enter current job again | Edited results are saved | Edited results are saved               | Pass          |   |
| User could edit their current job details without saving| 1. Click on enter current job detail <br> 2. Change the title to "SWE 2" <br> 3. Click on cancel button and click on enter current job again | Title is not "SWE 2" | Title is not "SWE 2"               | Pass          |   |
| User inputs a non-numeric value in the cost field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the cost field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs a non-numeric value in the salary field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the salary field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs a non-numeric value in the bonus field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the bonus field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs a non-numeric value in the stock field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the stock field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs a non-numeric value in the fund field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the fund field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs an out of range value in the fund field for the current job| 1. Click on enter current job details <br> 2. Input "16" in the fund field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-15. | Show error message: Out of range. Please enter a value between 0-15.              | Pass          |   |
| User inputs an out of range value in the fund field for the current job| 1. Click on enter current job details <br> 2. Input "-1" in the fund field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-15. | Show error message: Out of range. Please enter a value between 0-15.              | Pass          |   |
| User inputs a non-numeric value in the holiday field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the holiday field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs an out of range value in the holiday field for the current job| 1. Click on enter current job details <br> 2. Input "21" in the holiday field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-20. | Show error message: Out of range. Please enter a value between 0-20.              | Pass          |   |
| User inputs an out of range value in the holiday field for the current job| 1. Click on enter current job details <br> 2. Input "-1" in the holiday field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-20. | Show error message: Out of range. Please enter a value between 0-20.              | Pass          |   |
| User inputs a non-numeric value in the stipend field for the current job| 1. Click on enter current job details <br> 2. Input "Test@1" in the stipend field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs an out of range value in the stipend field for the current job| 1. Click on enter current job details <br> 2. Input "76" in the stipend field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-75. | Show error message: Out of range. Please enter a value between 0-75.              | Pass          |   |
| User inputs an out of range value in the stipend field for the current job| 1. Click on enter current job details <br> 2. Input "-1" in the stipend field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-75. | Show error message: Out of range. Please enter a value between 0-75.              | Pass          |   |
| User could not save without filling all required information when entering job offer detail| 1. Click on enter job offer <br> 2. Fill out the title with "SWE" and leave others blank <br> 3. Click on save button | Show error message: Cannot be empty | Show error message: Cannot be empty               | Pass          |   |
| User inputs a non-numeric value in the cost field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the cost field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs a non-numeric value in the salary field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the salary field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs a non-numeric value in the bonus field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the bonus field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs a non-numeric value in the stock field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the stock field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs a non-numeric value in the fund field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the fund field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs an out of range value in the fund field for the job offer| 1. Click on enter job offer <br> 2. Input "16" in the fund field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-15. | Show error message: Out of range. Please enter a value between 0-15.              | Pass          |   |
| User inputs an out of range value in the fund field for the job offer| 1. Click on enter job offer <br> 2. Input "-1" in the fund field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-15. | Show error message: Out of range. Please enter a value between 0-15.              | Pass          |   |
| User inputs a non-numeric value in the holiday field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the holiday field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.              | Pass          |   |
| User inputs an out of range value in the holiday field for the job offer| 1. Click on enter job offer <br> 2. Input "21" in the holiday field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-20. | Show error message: Out of range. Please enter a value between 0-20.              | Pass          |   |
| User inputs an out of range value in the holiday field for the job offer| 1. Click on enter job offer <br> 2. Input "-1" in the holiday field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-20. | Show error message: Out of range. Please enter a value between 0-20.              | Pass          |   |
| User inputs a non-numeric value in the stipend field for the job offer| 1. Click on enter job offer <br> 2. Input "Test@1" in the stipend field <br> 3. Click on save button | Show error message: Invalid Entry. Please enter an number. | Show error message: Invalid Entry. Please enter an number.              | Pass          |   |
| User inputs an out of range value in the stipend field for the job offer| 1. Click on enter job offer <br> 2. Input "76" in the stipend field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-75. | Show error message: Out of range. Please enter a value between 0-75.              | Pass          |   |
| User inputs an out of range value in the stipend field for the job offer| 1. Click on enter job offer <br> 2. Input "-1" in the stipend field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-75. | Show error message: Out of range. Please enter a value between 0-75.              | Pass          |   |
| User inputs an out of range value in the stipend field for the job offer| 1. Click on enter job offer <br> 2. Input "-1" in the stipend field <br> 3. Click on save button | Show error message: Out of range. Please enter a value between 0-75. | Show error message: Out of range. Please enter a value between 0-75.              | Pass          |   |
| Check user's default comparison setting| 1. Click on adjust comparison setting <br> | All weight should be 1| All weights are 1            | Pass          |   |
| Edit user's comparison setting| 1. Click on adjust comparison setting <br> 2. Change the weights as followed: 2, 3, 4, 5, 6, 7 <br> 3. Click on save button and adjust comparison setting again| Entered weights are saved| Entered weights are saved            | Pass          |   |
| Edit user's comparison setting again| 1. Click on adjust comparison setting <br> 2. Change the weights as followed: 1, 1, 1, 1, 1, 1 <br> 3. Click on save button and adjust comparison setting again| Entered weights are saved| Entered weights are saved            | Pass          |   |
| None of the comparison setting should be null| 1. Click on adjust comparison setting <br> 2. Remove salary weight setting <br> 3. Click on save button | Error message: This field cannot be empty.| EError message: This field cannot be empty.            | Pass          |   |
| None of the comparison setting should be null| 1. Click on adjust comparison setting <br> 2. Remove holiday weight setting <br> 3. Click on save button | Error message: This field cannot be empty.| EError message: This field cannot be empty.            | Pass          |   |
| User inputs a non-numeric value in the salary setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the salary field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| User inputs a non-numeric value in the bonus setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the bonus field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| User inputs a non-numeric value in the stock setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the stock field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| User inputs a non-numeric value in the fund setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the fund field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| User inputs a non-numeric value in the holiday setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the holiday field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| User inputs a non-numeric value in the stipend setting field | 1.  Click on adjust comparison setting <br> 2. Input "test @!" in the holistipendday field| Show error message: Invalid Entry. Please enter an integer. | Show error message: Invalid Entry. Please enter an integer.             |           |   |
| In the job offer page, user could enter another job offers| 1.  Click on enter job offers in the main menu <br> 2. Fill the salary with 1000 <br> 3. Click on enter another job offer button|  User stays in the same page but all info are cleared|               |           |   |
| In the job offer page, user could return to new menu| 1.  Click on enter job offers in the main menu <br> 2. Click on return to main menu button|  User return to main menu page|               |           |   |
| In the job offer page, user could compare offer after saving| 1.  Click enter job offers in the main menu <br> 2. Fill all info <br> 3. Click on save button <br> 4. Click compare job offer button|  User could go to compare job page|               |           |   |
| In the job offer page, user could not compare offer before saving| 1.  Click enter job offers in the main menu <br> 2. Fill all info <br> 3. Click compare job offer button|  Show error message indicating that current job offer is not saved|               |           |   |
| User could not compare job offers if he only has one offer/current job| 1. Select the job <br> 2. Click on compare job offers| Error message: select two jobs |               |           |   |
| User could compare job offers| 1. Select two jobs <br> 2. Click on compare job offers| Show the details of these two jobs |               |           |   |
| User could compare job offers if he select 3 jobs| 1. Select three jobs <br> 2. Click on compare job offers| Show the details of these two jobs |               |           |   |
| User could compare job offers if there is no job| 1. Click on compare job offers| Error message: select two jobs |               |           |   |
| User could perform another comparison| 1. Click another comparison in the comparison page| User navigates back to the job list and could select two job offers |               |           |   |
| System calcualtes the job score correctly| 1. Print the job scores and compare them with those calculated by hand| The results are the same |               |           |   |
| System updates the job score correctly when user changes the job details| 1. Change salary to 1 for one job offer <br> 2. Click compare job offers <br> 3. Check job scores| System updates job scores |               |           |   |
| System updates the job score correctly when user changes the weight| 1. Change weight of salary to 2 <br> 2. Click compare job offers <br> 3. Check job scores| System updates job scores |               |           |   |
| If two job offers have the same job scores, the ranking is based on the alphabetical order of the job title| 1.Create two job offers which have the same job scores but different titles <br> 2. Click compare job offers <br> 3. Check the rank of these two job offers| System updates job list correctly |               |           |   |
| The job offer list will update when user enters a new job offer| 1.Create one job offer and save <br> 2. Click compare job offers <br> 3. Check the new job offer| The offer list updates the new offer correctly |               |           |   |
| The job offer list will update when user enters the current job| 1.Enter current job and save <br> 2. Click compare job offers <br> 3. Check the current job| The offer list updates the current job correctly |               |           |   |
| The job offer list will update when user edits the current job| 1.Edit current job and save, change salary to 100 <br> 2. Click compare job offers <br> 3. Check the current job| The offer list updates the current job correctly |               |           |   |