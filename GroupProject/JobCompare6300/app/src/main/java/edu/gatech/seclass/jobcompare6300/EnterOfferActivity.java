package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterOfferActivity extends AppCompatActivity {

    private EditText titleEditText, companyEditText, locationEditText, costEditText, salaryEditText, bonusEditText, stockEditText, fundEditText, holidayEditText, stipendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_offer);
        initWidgets();
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

    public void returnToMain(View view) {
        if (R.id.cancelEnterBtn == view.getId()) {
            startActivity(new Intent(EnterOfferActivity.this, MainActivity.class));
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
            // Validation for fundEditText within 0-15
            double fundValue = Double.parseDouble(fundEditText.getText().toString());
            if (fundValue < 0 || fundValue > 15) {
                fundEditText.setError("Out of range. Please enter a value between 0-15.");
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
            float salary = Float.parseFloat(salaryEditText.getText().toString());
            float bonus = Float.parseFloat(bonusEditText.getText().toString());
            int stock = Integer.parseInt(stockEditText.getText().toString());
            float fund = Float.parseFloat(fundEditText.getText().toString());
            int holiday = Integer.parseInt(holidayEditText.getText().toString());
            float stipend = Float.parseFloat(stipendEditText.getText().toString());
            boolean isCurrent = false;

            int id = Job.jobArrayList.size();

            Job newJob = new Job(id, title, company, location, cost, salary, bonus, stock, fund, holiday, stipend, isCurrent);
            Job.jobArrayList.add(newJob);
            sqLiteManager.addJobToDatabase(newJob);
            Intent i = new Intent(EnterOfferActivity.this, MainActivity.class);
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