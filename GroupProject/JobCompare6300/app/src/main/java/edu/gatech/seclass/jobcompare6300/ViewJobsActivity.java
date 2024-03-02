package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ViewJobsActivity extends AppCompatActivity {

    private ListView jobListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);
        initWidgets();
        setJobAdapter();
    }

    private void initWidgets() {
        jobListView = findViewById(R.id.jobsListView);
    }

    private void setJobAdapter() {
        JobDetailAdapter jobDetailAdapter = new JobDetailAdapter(getApplicationContext(), Job.selectedJobs);
        jobListView.setAdapter(jobDetailAdapter);
    }

    public void returnToMain(View view) {
        if (R.id.backBtn == view.getId()) {
            startActivity(new Intent(ViewJobsActivity.this, JobsActivity.class));
        }

    }

}