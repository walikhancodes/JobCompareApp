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
        System.out.println(R.id.cancelEnterBtn);
        if (R.id.cancelEnterBtn == view.getId()) {
            startActivity(new Intent(EnterOfferActivity.this, MainActivity.class));
        }

    }

    public void saveJob(View view) {
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
        finish();
    }
}