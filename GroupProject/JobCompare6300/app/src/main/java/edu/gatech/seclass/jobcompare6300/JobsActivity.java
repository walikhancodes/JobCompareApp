package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
        if (R.id.backBtn == view.getId()) {
            startActivity(new Intent(JobsActivity.this, MainActivity.class));
        }

    }

    public void compareJobs(View view) {
        if (R.id.compareBtn == view.getId()) {

            int checkedCount = 0;
            ArrayList<Job> selectedJobs = new ArrayList<>();

            int itemCount = jobListView.getCount();

            for (int i = 0; i < itemCount; i++) {
                View itemView = jobListView.getChildAt(i);
                CheckBox checkBox = itemView.findViewById(R.id.checkBox);
                if (checkBox.isChecked()) {
                    Job sel = (Job) jobListView.getItemAtPosition(i);
                    selectedJobs.add(sel);
                    checkedCount++;
                }
            }

            if (checkedCount == 2) {
                Job.setSelectedJobs(selectedJobs);
                startActivity(new Intent(JobsActivity.this, ViewJobsActivity.class));
            } else {
                Toast.makeText(getApplicationContext(),"Select 2 Jobs",Toast.LENGTH_SHORT).show();
            }
        }
    }
}