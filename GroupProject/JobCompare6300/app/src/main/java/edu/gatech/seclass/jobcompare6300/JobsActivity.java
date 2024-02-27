package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class JobsActivity extends AppCompatActivity {

    private ListView jobListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        initWidgets();
        setJobAdapter();
    }

    private void initWidgets() {
        jobListView = findViewById(R.id.jobsListView);
    }

    private void setJobAdapter() {
        JobAdapter jobAdapter = new JobAdapter(getApplicationContext(), Job.jobArrayList);
        jobListView.setAdapter(jobAdapter);
    }

    public void returnToMain(View view) {
        System.out.println(R.id.cancelEnterBtn);
        if (R.id.backBtn == view.getId()) {
            startActivity(new Intent(JobsActivity.this, MainActivity.class));
        }

    }
}