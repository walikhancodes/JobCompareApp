package edu.gatech.seclass.jobcompare6300;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
        replaceTextHelper(R.id.fundEditText, "16");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-15.")));
    }

    @Test
    public void fundCurrentJobError3() {
        onView(withId(R.id.enterEditJobBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-15.")));
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
    // edit the current job and cancel
    @Test
    public void screenshotOffer4() {
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
    public void fundOfferError1() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "Test@1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Invalid Entry. Please enter a number.")));
    }

    @Test
    public void fundOfferError2() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "16");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-15.")));
    }

    @Test
    public void fundOfferError3() {
        onView(withId(R.id.enterOfferBtn)).perform(click());
        replaceTextHelper(R.id.fundEditText, "-1");
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.fundEditText)).check(matches(hasErrorText("Out of range. Please enter a value between 0-15.")));
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


}