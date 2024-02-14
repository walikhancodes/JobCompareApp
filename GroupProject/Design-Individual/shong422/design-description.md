**1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).**

This is not represented in my design, as it will be handled entirely within the GUI implementation.

**2. When choosing to enter current job details, a user will:
Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
Title
Company
Location (entered as city and state)
Cost of living in the location (expressed as an index)
Yearly salary
Yearly bonus
Number of stock option shares offered
Home Buying Program fund (one-time dollar amount up to 15% of Yearly Salary)
Personal Choice Holidays (A single overall number of days from 0 to 20)
Monthly Internet Stipend ($0 to $75 inclusive)
Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.**

To realize this requirement, I added a 'isFirstTimeUser' boolean to the User class to identify if a user is a first time user or not and implemented
a 'enterOreditCurrentJob' which will prompt the user to enter the values required for the JobDetail.
I have created an 'CurrentJob' class which IS A 'JobDetail' and the class defaults 'isCurrentJob' attribute to true when 'enterOreditCurrentJob' is triggered.
If 'firstTimeUser' is true, user will be able to enter new details for the current job details, if it's false, user will be able to update the current job details.
User will be able to save the job details or cancel and exit without saving, return to the main menu within the GUI implementation.

**3. When choosing to enter job offers, a user will:
Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
Be able to either save the job offer details or cancel.
Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).**

To realize this requirement, I implemented a 'enterJobOffer' method which will trigger the user to enter new details for the job offer details.
I have created a 'JobOffer' class which IS A 'JobDetail' and the class defaults 'isCurrentJob' attribute to false when 'enterJobOffer' is triggered.
Once done entering details or user decides to cancel, user should be able to save and cancel, enter another offer upon save, return to the main menu at any time, and be able to compare the offer through the GUI.

**4. When adjusting the comparison settings, the user can assign integer weights to:
Yearly salary
Yearly bonus
Number of Stock Option Shares Offered
Home Buying Program Fund
Personal Choice Holidays
Monthly Internet Stipend
If no weights are assigned, all factors are considered equal.**

To realize this requirement, I have implemented a 'adjustComparisonSettings' to the User class which is associated with the 'ComparisonSettings' class to track the listed attributes as integer. 
The 'adjustComparisonSettings' method will prompt the users to enter values within the GUI.
The default values for each attribute are set to 1.

**5. When choosing to compare job offers, a user will:
Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
Select two jobs to compare and trigger the comparison.
Be shown a table comparing the two jobs, displaying, for each job:
Title
Company
Location
Yearly salary adjusted for cost of living
Yearly bonus adjusted for cost of living
Number of Stock Option Shares Offered
Home Buying Program fund (one-time up to 15% of Yearly Salary)
Personal Choice Holidays (A single overall number of days from 0 to 20)
Monthly Internet Stipend ($0 to $75 inclusive monthly)
Be offered to perform another comparison or go back to the main menu.**

To realize this requirement, I have added a 'JobDetail' list to the User class to be able to grab a list of JobsDetails for the user. 
The compareJobOffers(JobDetail[1], JobDetail[2]) method then executes the JobComparison class which includes calculateJobScore(JobDetail, ComparisonSettings).
Job Detail was passed as a parameter from ther User class and ComparisonSettings is used by the JobComparison class. 
It then ranks the job with the 'rankJobs(jobScore)' method from the best to worst.
Then I have added a method 'compareJobs(JobDetail[1], JobDetail[2])' to the 'JobComparison' class that takes two parameters 
which was passed from the User object to the JobComparison class and perform the comparison of two different jobs. 
The actual viewing of the ranked jobs, selecting the two jobs to compare, and viewing of the comparison are triggered by the compareJobs() method from the User class and the prompts will be handled through the GUI.

**6. When ranking jobs, a job’s score is computed as the weighted average of:
AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)
where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
CSO = Company shares offered (assuming a 3-year vesting schedule and a price-per-share of $1)
HBP = Home Buying Program
PCH = Personal Choice Holidays
MIS= Monthly Internet Stipend
For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for Internet Stipend, and 1 for all other factors, the score would be computed as:
2/9 * AYS + 2/9 * AYB + 1/9 * (CSO/3) + 1/9 * HBP + 1/9 * (PCH * AYS / 260) + 2/9 * (MIS*12)**

To realize this requirement, I have implemented a 'calculateJobScore(JobDetail, ComparisonSettings)' method on the 'JobComparison' class where the method takes in two parameters, JobsDetail and ComparisonSettings as parameters. It then sets the jobScore as an integer to the JobComparison class as a derived attribute.
The JobComparison class has a rankJobs() method which then uses the 'JobDetail[0..*]' as a parameter to rank the jobs for the user
which will rank from the best to worst based on the jobScore.

**7. The user interface must be intuitive and responsive.**

This is not represented in my design, as it will be handled entirely within the GUI implementation.

**8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).**

This is not represented in my design, as it will be handled entirely within the GUI implementation.
