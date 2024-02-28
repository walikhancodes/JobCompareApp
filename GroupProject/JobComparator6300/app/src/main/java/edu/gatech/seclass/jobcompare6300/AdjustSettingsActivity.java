package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdjustSettingsActivity extends AppCompatActivity {

    private EditText salarySettingEditText, bonusSettingEditText, stockSettingEditText, fundSettingEditText, holidaySettingEditText, stipendSettingEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_settings);
        initWidgets();
        checkForCurrentSetting();
    }


    private void initWidgets() {
        salarySettingEditText = findViewById(R.id.salarySettingEditText);
        bonusSettingEditText = findViewById(R.id.bonusSettingEditText);
        stockSettingEditText = findViewById(R.id.stockSettingEditText);
        fundSettingEditText = findViewById(R.id.fundSettingEditText);
        holidaySettingEditText = findViewById(R.id.holidaySettingEditText);
        stipendSettingEditText = findViewById(R.id.stipendSettingEditText);
    }

    private void checkForCurrentSetting() {

        Intent previousIntent = getIntent();

        int passedSal = previousIntent.getIntExtra(Setting.SAL_EXTRA, -1);
        int passedBon = previousIntent.getIntExtra(Setting.BON_EXTRA, -1);
        int passedStock = previousIntent.getIntExtra(Setting.STO_EXTRA, -1);
        int passedFund = previousIntent.getIntExtra(Setting.FUN_EXTRA, -1);
        int passedHoliday = previousIntent.getIntExtra(Setting.HOL_EXTRA, -1);
        int passedStipend = previousIntent.getIntExtra(Setting.STIP_EXTRA, -1);

        salarySettingEditText.setText(String.valueOf(passedSal));
        bonusSettingEditText.setText(String.valueOf(passedBon));
        stockSettingEditText.setText(String.valueOf(passedStock));
        fundSettingEditText.setText(String.valueOf(passedFund));
        holidaySettingEditText.setText(String.valueOf(passedHoliday));
        stipendSettingEditText.setText(String.valueOf(passedStipend));

    }


    public void returnToMain(View view) {
        System.out.println(R.id.cancelAdjBtn);
        if (R.id.cancelAdjBtn == view.getId()) {
            Intent i = new Intent(AdjustSettingsActivity.this, MainActivity.class);
            finish();
            startActivity(i);
        }
    }

    public void saveSetting(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        int salarySetting = Integer.parseInt(salarySettingEditText.getText().toString());
        int bonusSetting = Integer.parseInt(bonusSettingEditText.getText().toString());
        int stockSetting = Integer.parseInt(stockSettingEditText.getText().toString());
        int fundSetting = Integer.parseInt(fundSettingEditText.getText().toString());
        int holidaySetting = Integer.parseInt(holidaySettingEditText.getText().toString());
        int stipendSetting = Integer.parseInt(stipendSettingEditText.getText().toString());

        Setting newSetting = new Setting(salarySetting, bonusSetting, stockSetting, fundSetting, holidaySetting, stipendSetting);

        sqLiteManager.saveUserSettings(newSetting);
        Intent i = new Intent(AdjustSettingsActivity.this, MainActivity.class);
        finish();
        startActivity(i);

    }
}