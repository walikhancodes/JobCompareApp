package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class jobCompareTest {
    @Rule
    public ActivityScenarioRule<MainActivity> tActivityRule = new ActivityScenarioRule<>(
            MainActivity.class);


    private void replaceTextHelper(int viewId, String stringToBeSet) {
        onView(withId(viewId)).perform(clearText(), replaceText(stringToBeSet), closeSoftKeyboard());
    }

    // check the job scores
    @Test
    public void jobScoreIsCorrect1() {
        // Create a Job instance with predefined values
        Job job = new Job(0, "Software Engineer", "Company", "Atlanta", 100, 70000, 5000, 1000, 500, 15, 5, true);

        // Calculate the score with equal weights
        job.calculateScore(1, 1 ,1, 1, 1, 1);

        // Access the jobScore directly since calculateScore doesn't return a value
        double calculatedScore = job.getScore();

        // Define the expected score based on the attributes and settings
        double expectedScore = 13321 ; // Manually compute this based on the provided attributes and equal weights

        // Assert that the calculated score matches the expected score
        assertEquals("The job score should be calculated correctly.", expectedScore, calculatedScore, 1);
    }

    // change the job details
    @Test
    public void jobScoreIsCorrect2() {
        // Create a Job instance with predefined values
        Job job = new Job(0, "Software Engineer", "Company", "Atlanta", 200, 7000, 500, 100, 50, 0, 50, true);

        // Calculate the score with equal weights
        job.calculateScore(1, 1 ,1, 1, 1, 1);

        // Access the jobScore directly since calculateScore doesn't return a value
        double calculatedScore = job.getScore();

        // Define the expected score based on the attributes and settings
        double expectedScore = 738 ; // Manually compute this based on the provided attributes and equal weights

        // Assert that the calculated score matches the expected score
        assertEquals("The job score should be calculated correctly.", expectedScore, calculatedScore, 1);
    }

    // change the job details
    @Test
    public void jobScoreIsCorrect3() {
        // Create a Job instance with predefined values
        Job job = new Job(0, "Software Engineer", "Company", "Atlanta", 200, 7000, 500, 100, 50, 0, 50, true);

        // Calculate the score with equal weights
        job.calculateScore(3, 1 ,10, 1, 1, 1);

        // Access the jobScore directly since calculateScore doesn't return a value
        double calculatedScore = job.getScore();

        // Define the expected score based on the attributes and settings
        double expectedScore = 690 ; // Manually compute this based on the provided attributes and equal weights

        // Assert that the calculated score matches the expected score
        assertEquals("The job score should be calculated correctly.", expectedScore, calculatedScore, 1);
    }

    // compare jobs: no jobs available
    @Test
    public void selectJobError1() {
        onView(withId(R.id.compareJobsBtn)).perform(click());
        onView(withId(R.id.compareBtn)).perform(click());
        // Check that the Toast with the expected text is displayed
        onView(withText("Select 2 Jobs")).check(matches(isDisplayed()));
        onView(withId(R.id.backBtn)).perform(click());
    }

    // compare jobs: select 3 jobs
    @Test
    public void selectJobError2() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SDE");
        replaceTextHelper(R.id.companyEditText, "comp1");
        replaceTextHelper(R.id.locationEditText, "SF");
        replaceTextHelper(R.id.costEditText, "100");
        replaceTextHelper(R.id.salaryEditText, "10000");
        replaceTextHelper(R.id.bonusEditText, "1000");
        replaceTextHelper(R.id.stockEditText, "1000");
        replaceTextHelper(R.id.fundEditText, "10");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "50");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE");
        replaceTextHelper(R.id.companyEditText, "comp2");
        replaceTextHelper(R.id.locationEditText, "LA");
        replaceTextHelper(R.id.costEditText, "120");
        replaceTextHelper(R.id.salaryEditText, "11000");
        replaceTextHelper(R.id.bonusEditText, "1100");
        replaceTextHelper(R.id.stockEditText, "1100");
        replaceTextHelper(R.id.fundEditText, "11");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "50");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "Engineer");
        replaceTextHelper(R.id.companyEditText, "comp3");
        replaceTextHelper(R.id.locationEditText, "Austin");
        replaceTextHelper(R.id.costEditText, "1000");
        replaceTextHelper(R.id.salaryEditText, "50000");
        replaceTextHelper(R.id.bonusEditText, "5000");
        replaceTextHelper(R.id.stockEditText, "5000");
        replaceTextHelper(R.id.fundEditText, "10");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "0");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.compareJobsBtn)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(1)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(2)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        // Click the compare button
        onView(withId(R.id.compareBtn)).perform(click());
        onView(withText("Select 2 Jobs")).check(matches(isDisplayed()));
        onView(withId(R.id.backBtn)).perform(click());
    }

    // compare jobs: select 2 jobs and will show the results
    @Test
    public void selectJobIsCorrect() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SDE");
        replaceTextHelper(R.id.companyEditText, "comp1");
        replaceTextHelper(R.id.locationEditText, "SF");
        replaceTextHelper(R.id.costEditText, "100");
        replaceTextHelper(R.id.salaryEditText, "10000");
        replaceTextHelper(R.id.bonusEditText, "1000");
        replaceTextHelper(R.id.stockEditText, "1000");
        replaceTextHelper(R.id.fundEditText, "10");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "50");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE");
        replaceTextHelper(R.id.companyEditText, "comp2");
        replaceTextHelper(R.id.locationEditText, "LA");
        replaceTextHelper(R.id.costEditText, "120");
        replaceTextHelper(R.id.salaryEditText, "11000");
        replaceTextHelper(R.id.bonusEditText, "1100");
        replaceTextHelper(R.id.stockEditText, "1100");
        replaceTextHelper(R.id.fundEditText, "11");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "50");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "Engineer");
        replaceTextHelper(R.id.companyEditText, "comp3");
        replaceTextHelper(R.id.locationEditText, "Austin");
        replaceTextHelper(R.id.costEditText, "1000");
        replaceTextHelper(R.id.salaryEditText, "50000");
        replaceTextHelper(R.id.bonusEditText, "5000");
        replaceTextHelper(R.id.stockEditText, "5000");
        replaceTextHelper(R.id.fundEditText, "10");
        replaceTextHelper(R.id.holidayEditText, "5");
        replaceTextHelper(R.id.stipendEditText, "0");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.compareJobsBtn)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(1)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        // Click the compare button
        onView(withId(R.id.compareBtn)).perform(click());
        onView(withId(R.id.editTextText)).check(matches(withText("COMPARE")));
        onView(withId(R.id.backBtn)).perform(click());
        onView(withId(R.id.backBtn)).perform(click());
    }


}