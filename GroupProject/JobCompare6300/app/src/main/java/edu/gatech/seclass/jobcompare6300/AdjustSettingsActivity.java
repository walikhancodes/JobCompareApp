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
        EditText[] editFields = {
                salarySettingEditText,
                bonusSettingEditText,
                stockSettingEditText,
                fundSettingEditText,
                holidaySettingEditText,
                stipendSettingEditText
        };

        int[] settings = new int[editFields.length];
        boolean error = false;

        for (int i = 0; i < editFields.length; i++) {
            String text = editFields[i].getText().toString();
            if (text.isEmpty()) {
                editFields[i].setError("This field cannot be empty.");
                error = true;
            } else {
                try {
                    settings[i] = Integer.parseInt(text);
                    if (!isInteger(text)) {
                        editFields[i].setError("Invalid Entry. Please enter an integer.");
                        error = true;
                    }
                } catch (NumberFormatException e) {
                    editFields[i].setError("Invalid Entry. Please enter an integer.");
                    error = true;
                }
            }
        }

        if (!error) {
            Setting newSetting = new Setting(
                    settings[0], // salarySetting
                    settings[1], // bonusSetting
                    settings[2], // stockSetting
                    settings[3], // fundSetting
                    settings[4], // holidaySetting
                    settings[5]  // stipendSetting
            );
            sqLiteManager.saveUserSettings(newSetting);
            Intent i = new Intent(AdjustSettingsActivity.this, MainActivity.class);
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
}