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
public class UpdateListTest {
    @Rule
    public ActivityScenarioRule<MainActivity> tActivityRule = new ActivityScenarioRule<>(
            MainActivity.class);
    private void replaceTextHelper(int viewId, String stringToBeSet) {
        onView(withId(viewId)).perform(clearText(), replaceText(stringToBeSet), closeSoftKeyboard());
    }

    //List will update when user enters a new job offer
    @Test
    public void updateJobOfferList1() {
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

        onView(withId(R.id.compareJobsBtn)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.cellTitle)).check(matches(withText("SDE")));

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.cellCompany)).check(matches(withText("comp1")));

        onView(withId(R.id.backBtn)).perform(click());
    }

    //List will update when user enters their current job
    @Test
    public void updateJobOfferList2() {
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

        onView(withId(R.id.compareJobsBtn)).perform(click());


        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.cellTitle)).check(matches(withText("SDE")));

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(0)
                .onChildView(withId(R.id.cellCompany)).check(matches(withText("comp1")));

        onView(withId(R.id.backBtn)).perform(click());
    }

    //List will update when  user edits their current job

    @Test
    public void updateJobOfferList3() {
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

        onView(withId(R.id.enterEditJobBtn)).perform(click());

        replaceTextHelper(R.id.salaryEditText, "100");
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.compareJobsBtn)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.jobsListView))
                .atPosition(3)
                .onChildView(withId(R.id.cellTitle)).check(matches(withText("SDE")));

    }
}
