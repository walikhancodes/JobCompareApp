1. Requirement: "When the app is started, the user is presented with the main menu, which allows the user to..."

This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation.
All entries for entering or editing data will also be handled in the GUI implementation. 

2. "When chosing to enter current job details, a user will:"
	A. "Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:"
	Part of this requirement is not reflected in the UML diagram and will be fulfilled within the GUI implementation. 
	To represent the details of the person's current job, a 'User' class was created to contain all the details of their current job as various attributes. A 'Title' attribute was added to the class to represent the Title of that person's job. 'Company' attribute was added to represent the Company of that person's job. 'Cost_of_living' attribute was added to reflect the Cost of living in the location. 'Yearly_salary' attribute was added to reflect the yearly_salary of the user. 'Yearly_bonus' attribute was added to reflect the yearly_bonus of the user. 'Number_of_stock' attribute was added to reflect the number of stock option shares offered to the user. 'HBPF' attribute represents the Home Buying Program fund. 'PCH' attribute represents the personal choice holidays. 'MIS' represesnts the Monthly Internet Stipend. 

	All attribute values in the 'User' class are defaulted to 'None', this will be used to indicate whether or not it is the user's first time entering in details. 

3. "When choosing to enter job offers, a user will:"
	A. "Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job"

	This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation.

	B. "Be able to either save the job offer details of cancel"

	The cancellation of the job offer details will be handled by the GUI implementation. Within the 'Job' class there is a method called 'saveDetails' that saves the details for that particular job offer. The attributes within the 'User' class have mostly been reflected to be the same within the 'Job' class. 

	C. "Be able to (1) enter another offer, (2) return to main menu or (3) compare the offer (if they saved it) with the current job details (if present)"

	This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation.

4. "When adjusting the comparison settings, the user can assign integer weights to:"

This requirement is satisfied within the 'Job' class method called 'saveWeights(weights).' This method has a default initialization of equal weights to all six attributes. When the user decides to change weight values within the GUI, the values are stored as a private variable called 'weights' within the 'Job' class. 

5. "When choosing to compare job offers, a user will: "
	A. "Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated"

	A 'Job Ranking Algorithm' will handle how to sort and display the jobs based on the 'job_score' attribute with in the 'Job' class. 

	B. "Select two jobs to compare and trigger the comparison"

	This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation. The comparison part can be done on the frontend side of things.

	C. "Be shown a table comparing the two jobs, displaying, for each job: "

	This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation. 

	D. "Be offered to perform another comparison or go back to the main menu"

	This requirement is currently not reflected in the UML diagram and will be fulfilled within the GUI implementation. 


6. Requirement: "When ranking jobs, a job's score is computed as the weighted average of ...."

Within the 'Job' class there is an operation/method named 'computejobScore()' that will compute the job score from 6 attributes within its class.

7. Requirement: "The user interface must be intuitive and responsive"

This requirement is currently not reflected in the UMlL diagram and will be fulfilled within the GUI implementation.

8. Requirement: "For Simplicity, you may assume there is a single system running the app"

This requirement is satisfied in the UML diagram by NOT having a separate class to store all the user data between different devices or systems. 