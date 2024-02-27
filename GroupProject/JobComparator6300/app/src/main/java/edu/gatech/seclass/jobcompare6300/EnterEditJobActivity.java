package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterEditJobActivity extends AppCompatActivity {

    private EditText titleEditText, companyEditText, locationEditText, costEditText, salaryEditText, bonusEditText, stockEditText, fundEditText, holidayEditText, stipendEditText;

    private Job currentJob;

    private static Intent previousIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_edit_job);
        initWidgets();
        checkForCurrentJob();
        checkForCurrentSetting();
    }

    private void initWidgets() {
        titleEditText = findViewById(R.id.titleEditText);
        companyEditText = findViewById(R.id.companyEditText);
        locationEditText = findViewById(R.id.locationEditText);
        costEditText = findViewById(R.id.costEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        bonusEditText = findViewById(R.id.bonusEditText);
        stockEditText = findViewById(R.id.stockEditText);
        fundEditText = findViewById(R.id.fundEditText);
        holidayEditText = findViewById(R.id.holidayEditText);
        stipendEditText = findViewById(R.id.stipendEditText);
    }

    private void checkForCurrentJob() {
        currentJob = Job.getCurrentJob();

        if (currentJob != null) {
            titleEditText.setText(currentJob.getTitle());
            companyEditText.setText(currentJob.getCompany());
            locationEditText.setText(currentJob.getLocation());
            costEditText.setText(String.valueOf(currentJob.getCost()));
            salaryEditText.setText(String.valueOf(currentJob.getSalary()));
            bonusEditText.setText(String.valueOf(currentJob.getBonus()));
            stockEditText.setText(String.valueOf(currentJob.getStock()));
            fundEditText.setText(String.valueOf(currentJob.getFund()));
            holidayEditText.setText(String.valueOf(currentJob.getHolidays()));
            stipendEditText.setText(String.valueOf(currentJob.getStipend()));
        }
    }

    private void checkForCurrentSetting() {
        previousIntent = getIntent();
    }

    public void returnToMain(View view) {
        System.out.println(R.id.cancelEnterBtn);
        if (R.id.cancelEnterBtn == view.getId()) {
            startActivity(new Intent(EnterEditJobActivity.this, MainActivity.class));
        }

    }


    public void saveJob(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String title = titleEditText.getText().toString();
        String company = companyEditText.getText().toString();
        String location = locationEditText.getText().toString();
        int cost = Integer.parseInt(costEditText.getText().toString());
        double salary = Double.parseDouble(salaryEditText.getText().toString());
        double bonus = Double.parseDouble(bonusEditText.getText().toString());
        int stock = Integer.parseInt(stockEditText.getText().toString());
        double fund = Float.parseFloat(fundEditText.getText().toString());
        int holiday = Integer.parseInt(holidayEditText.getText().toString());
        double stipend = Float.parseFloat(stipendEditText.getText().toString());
        boolean isCurrent = true;

        if (currentJob == null) {
            int id = Job.jobArrayList.size();
            Job newJob = new Job(id, title, company, location, cost, salary, bonus, stock, fund, holiday, stipend, isCurrent);
            Job.jobArrayList.add(newJob);
            sqLiteManager.addJobToDatabase(newJob);
        } else {
            currentJob.setTitle(title);
            currentJob.setCompany(company);
            currentJob.setLocation(location);
            currentJob.setCost(cost);
            currentJob.setSalary(salary);
            currentJob.setBonus(bonus);
            currentJob.setStock(stock);
            currentJob.setFund(fund);
            currentJob.setHolidays(holiday);
            currentJob.setStipend(stipend);
            sqLiteManager.updateCurrentJob(currentJob);
        }
        finish();

    }

}