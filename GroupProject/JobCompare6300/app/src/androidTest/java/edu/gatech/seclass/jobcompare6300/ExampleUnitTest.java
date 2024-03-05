package edu.gatech.seclass.jobcompare6300;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import android.widget.ListView;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Rule
    public ActivityScenarioRule<MainActivity> tActivityRule = new ActivityScenarioRule<>(
            MainActivity.class);


    private void replaceTextHelper(int viewId, String stringToBeSet) {
        onView(withId(viewId)).perform(clearText(), replaceText(stringToBeSet), closeSoftKeyboard());
    }

    /**
    This section checks the functionality of the enter/edit job page including
    enter/edit job with/without save and all exceptions
    **/
    // Screenshot of the enter or edit current job
    // enter current job, need to fill all required information
    @Test
    public void screenshotCurrentJob1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.companyEditText)).check(matches(hasErrorText("Cannot be empty")));
    }

    // enter the current job and save
    @Test
    public void screenshotCurrentJob2() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
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
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        onView(withId(R.id.titleEditText)).check(matches(withText("SDE")));
        onView(withId(R.id.companyEditText)).check(matches(withText("comp1")));
        onView(withId(R.id.locationEditText)).check(matches(withText("SF")));
        onView(withId(R.id.costEditText)).check(matches(withText("100")));
        onView(withId(R.id.salaryEditText)).check(matches(withText("10000.0")));
        onView(withId(R.id.bonusEditText)).check(matches(withText("1000.0")));
        onView(withId(R.id.stockEditText)).check(matches(withText("1000")));
        onView(withId(R.id.fundEditText)).check(matches(withText("10.0")));
        onView(withId(R.id.holidayEditText)).check(matches(withText("5")));
        onView(withId(R.id.stipendEditText)).check(matches(withText("50.0")));
        onView(withId(R.id.button)).perform(click());
    }

    // edit the current job and save
    @Test
    public void screenshotCurrentJob3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE");
        replaceTextHelper(R.id.companyEditText, "comp2");
        replaceTextHelper(R.id.locationEditText, "LA");
        replaceTextHelper(R.id.costEditText, "80");
        replaceTextHelper(R.id.salaryEditText, "20000");
        replaceTextHelper(R.id.bonusEditText, "2000");
        replaceTextHelper(R.id.stockEditText, "2000");
        replaceTextHelper(R.id.fundEditText, "5");
        replaceTextHelper(R.id.holidayEditText, "0");
        replaceTextHelper(R.id.stipendEditText, "0");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        onView(withId(R.id.titleEditText)).check(matches(withText("SWE")));
        onView(withId(R.id.companyEditText)).check(matches(withText("comp2")));
        onView(withId(R.id.locationEditText)).check(matches(withText("LA")));
        onView(withId(R.id.costEditText)).check(matches(withText("80")));
        onView(withId(R.id.salaryEditText)).check(matches(withText("20000.0")));
        onView(withId(R.id.bonusEditText)).check(matches(withText("2000.0")));
        onView(withId(R.id.stockEditText)).check(matches(withText("2000")));
        onView(withId(R.id.fundEditText)).check(matches(withText("5.0")));
        onView(withId(R.id.holidayEditText)).check(matches(withText("0")));
        onView(withId(R.id.stipendEditText)).check(matches(withText("0.0")));
        onView(withId(R.id.button)).perform(click());
    }

    // edit the current job and cancel
    @Test
    public void screenshotCurrentJob4() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE 2");
        onView(withId(R.id.cancelEnterBtn)).perform(click());
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        onView(withId(R.id.titleEditText)).check(matches(withText("SWE")));
        onView(withId(R.id.companyEditText)).check(matches(withText("comp2")));
        onView(withId(R.id.locationEditText)).check(matches(withText("LA")));
        onView(withId(R.id.costEditText)).check(matches(withText("80")));
        onView(withId(R.id.salaryEditText)).check(matches(withText("20000.0")));
        onView(withId(R.id.bonusEditText)).check(matches(withText("2000.0")));
        onView(withId(R.id.stockEditText)).check(matches(withText("2000")));
        onView(withId(R.id.fundEditText)).check(matches(withText("5.0")));
        onView(withId(R.id.holidayEditText)).check(matches(withText("0")));
        onView(withId(R.id.stipendEditText)).check(matches(withText("0.0")));
        onView(withId(R.id.button)).perform(click());
    }

    /* check all fields error when enter/editing current job*/
    @Test
    public void costCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.costEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.costEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void salaryCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.salaryEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.salaryEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void bonusCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.bonusEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.bonusEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void stockCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.stockEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stockEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void fundCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void fundCurrentJobError2() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.salaryEditText, "10000");
        replaceTextHelper(R.id.fundEditText, "10000");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value up to 15% of Yearly Salary.")));
    }

    @Test
    public void fundCurrentJobError3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a positive value.")));
    }

    @Test
    public void holidayCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void holidayCurrentJobError2() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "21");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-20.")));
    }

    @Test
    public void holidayCurrentJobError3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-20.")));
    }

    @Test
    public void stipendCurrentJobError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void stipendCurrentJobError2() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "76");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-75.")));
    }

    @Test
    public void stipendCurrentJobError3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-75.")));
    }

    /**
     This section checks the functionality of the enter job offer including
     enter job offer with/without save and all exceptions
     **/

    // Screenshot of the enter or edit current job
    // enter current job, need to fill all required information
    @Test
    public void screenshotJobOffer1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.titleEditText, "SWE");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.companyEditText)).check(matches(hasErrorText("Cannot be empty")));
    }

    // continue later on

    /* check all fields error when enter/editing current job*/
    @Test
    public void costCurrentOffer1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.costEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.costEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void salaryOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.salaryEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.salaryEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void bonusOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.bonusEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.bonusEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void stockOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.stockEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stockEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void fundJobOfferError1() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void fundJobOfferError2() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.salaryEditText, "10000");
        replaceTextHelper(R.id.fundEditText, "10000");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value up to 15% of Yearly Salary.")));
    }

    @Test
    public void fundJobOfferError3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a positive value.")));
    }

    @Test
    public void holidayOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void holidayOfferError2() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "21");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-20.")));
    }

    @Test
    public void holidayOfferError3() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.holidayEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.holidayEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-20.")));
    }

    @Test
    public void stipendOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void stipendOfferError2() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "76");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-75.")));
    }

    @Test
    public void stipendOfferError3() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.stipendEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.stipendEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-75.")));
    }

    /**
     This section checks the functionality of the comparison setting
     **/

    // check the default setting of the comparison setting
    @Test
    public void screenshotSettingCompare1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        onView(withId(R.id.salarySettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.bonusSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.stockSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.fundSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.holidaySettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.stipendSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.cancelAdjBtn)).perform(click());
    }

    // edit setting and save
    @Test
    public void screenshotSettingCompare2() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.salarySettingEditText, "2");
        replaceTextHelper(R.id.bonusSettingEditText, "3");
        replaceTextHelper(R.id.stockSettingEditText, "4");
        replaceTextHelper(R.id.fundSettingEditText, "5");
        replaceTextHelper(R.id.holidaySettingEditText, "6");
        replaceTextHelper(R.id.stipendSettingEditText, "7");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        onView(withId(R.id.salarySettingEditText)).check(matches(withText("2")));
        onView(withId(R.id.bonusSettingEditText)).check(matches(withText("3")));
        onView(withId(R.id.stockSettingEditText)).check(matches(withText("4")));
        onView(withId(R.id.fundSettingEditText)).check(matches(withText("5")));
        onView(withId(R.id.holidaySettingEditText)).check(matches(withText("6")));
        onView(withId(R.id.stipendSettingEditText)).check(matches(withText("7")));
        onView(withId(R.id.cancelAdjBtn)).perform(click());
    }

    // edit setting back to the default setting
    @Test
    public void screenshotSettingCompare3() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.salarySettingEditText, "1");
        replaceTextHelper(R.id.bonusSettingEditText, "1");
        replaceTextHelper(R.id.stockSettingEditText, "1");
        replaceTextHelper(R.id.fundSettingEditText, "1");
        replaceTextHelper(R.id.holidaySettingEditText, "1");
        replaceTextHelper(R.id.stipendSettingEditText, "1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        onView(withId(R.id.salarySettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.bonusSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.stockSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.fundSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.holidaySettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.stipendSettingEditText)).check(matches(withText("1")));
        onView(withId(R.id.cancelAdjBtn)).perform(click());
    }

    // check if any of the fields is null
    @Test
    public void screenshotSettingCompare4() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.salarySettingEditText, "");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.salarySettingEditText)).check(matches(hasErrorText("This field cannot be empty.")));
    }

    @Test
    public void screenshotSettingCompare5() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.holidaySettingEditText, "");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.holidaySettingEditText)).check(matches(hasErrorText("This field cannot be empty.")));
    }

    @Test
    public void salarySettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.salarySettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.salarySettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void bonusSettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.bonusSettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.bonusSettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void stockSettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.stockSettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.stockSettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void fundSettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.fundSettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.fundSettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void holidaySettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.holidaySettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.holidaySettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
    }

    @Test
    public void stipendSettingError1() {
        onView(withId(R.id.adjustSettingBtn)).perform(click());
        replaceTextHelper(R.id.stipendSettingEditText, "Test@1");
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.stipendSettingEditText)).check(matches(hasErrorText("Invalid Entry. Please enter an integer.")));
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
                .atPosition(2)
                .onChildView(withId(R.id.checkBox))
                .perform(click());

        // Click the compare button
        onView(withId(R.id.compareBtn)).perform(click());
        onView(withId(R.id.editTextText)).check(matches(withText("COMPARE")));
        onView(withId(R.id.backBtn)).perform(click());
        onView(withId(R.id.backBtn)).perform(click());
    }


}