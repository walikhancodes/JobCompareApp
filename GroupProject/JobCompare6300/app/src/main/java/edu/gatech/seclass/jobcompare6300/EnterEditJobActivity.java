package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterEditJobActivity extends AppCompatActivity {

    private EditText titleEditText, companyEditText, locationEditText, costEditText, salaryEditText, bonusEditText, stockEditText, fundEditText, holidayEditText, stipendEditText;
    private Job currentJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_edit_job);
        initWidgets();
        checkForCurrentJob();
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


    public void returnToMain(View view) {
        if (R.id.cancelEnterBtn == view.getId()) {
            startActivity(new Intent(EnterEditJobActivity.this, MainActivity.class));
        }

    }

    public void saveJob(View view) {
        EditText[] editFields = {titleEditText, companyEditText, locationEditText, costEditText, salaryEditText, bonusEditText, stockEditText, fundEditText, holidayEditText, stipendEditText};
        boolean error = false;

        for (EditText field : editFields) {
            if (field.getText().toString().length() == 0) {
                field.setError("Cannot be empty");
                error = true;
            }
        }

        if (!isInteger(costEditText.getText().toString())) {
            costEditText.setError("Invalid Entry. Please enter an integer.");
            error = true;
        }
        if (!isDouble(salaryEditText.getText().toString())) {
            salaryEditText.setError("Invalid Entry. Please enter a number.");
            error = true;
        }
        if (!isDouble(bonusEditText.getText().toString())) {
            bonusEditText.setError("Invalid Entry. Please enter a number.");
            error = true;
        }
        if (!isInteger(stockEditText.getText().toString())) {
            stockEditText.setError("Invalid Entry. Please enter an integer.");
            error = true;
        }

        try {
            // Validation for fundEditText within 0-15% of Yearly Salary
            double fundValue = Double.parseDouble(fundEditText.getText().toString());
            double salaryValue = Double.parseDouble(salaryEditText.getText().toString());
            double allowedFundValue = salaryValue * 0.15;

            if (fundValue < 0) {
                fundEditText.setError("Invalid Entry. Please enter a positive value.");
                error = true;
            } else if (fundValue > allowedFundValue) {
                fundEditText.setError("Out of range. Please enter a value up to 15% of Yearly Salary.");
                error = true;
            }
        } catch (NumberFormatException e) {
            fundEditText.setError("Invalid Entry. Please enter a number.");
            error = true;
        }

        try {
            // Validation for holidayEditText within 0-20
            int holidayValue = Integer.parseInt(holidayEditText.getText().toString());
            if (holidayValue < 0 || holidayValue > 20) {
                holidayEditText.setError("Out of range. Please enter a value between 0-20.");
                error = true;
            }
        } catch (NumberFormatException e) {
            holidayEditText.setError("Invalid Entry. Please enter an integer.");
            error = true;
        }
        try {
            // Validation for stipendEditText within 0-75
            double stipendValue = Double.parseDouble(stipendEditText.getText().toString());
            if (stipendValue < 0 || stipendValue > 75) {
                stipendEditText.setError("Out of range. Please enter a value between 0-75.");
                error = true;
            }
        } catch (NumberFormatException e) {
            stipendEditText.setError("Invalid Entry. Please enter a number.");
            error = true;
        }

        if (!error) {
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
            Intent i = new Intent(EnterEditJobActivity.this, MainActivity.class);
            finish();
            startActivity(i);
        }

    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}