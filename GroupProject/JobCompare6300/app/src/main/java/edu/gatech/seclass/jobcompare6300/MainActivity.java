package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Setting userSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearJobArrayList();
        loadFromDBToMemory();
    }

    private void clearJobArrayList() {
        Job.jobArrayList.clear();
    }

    private void loadFromDBToMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateJobListArray();
        userSetting = sqLiteManager.getUserSetting();
    }

    public void handleClick(View view) {
        if (R.id.enterEditJobBtn == view.getId()) {
            if (userSetting != null) {
                Intent intent = new Intent(MainActivity.this, EnterEditJobActivity.class);
                intent.putExtra(Setting.SAL_EXTRA, userSetting.getSalary());
                intent.putExtra(Setting.BON_EXTRA, userSetting.getBonus());
                intent.putExtra(Setting.STO_EXTRA, userSetting.getStock());
                intent.putExtra(Setting.FUN_EXTRA, userSetting.getFund());
                intent.putExtra(Setting.HOL_EXTRA, userSetting.getHoliday());
                intent.putExtra(Setting.STIP_EXTRA, userSetting.getStipend());
                startActivity(intent);
            }
        }

        if (R.id.enterOfferBtn == view.getId()) {
            if (userSetting != null) {
                Intent intent = new Intent(MainActivity.this, EnterOfferActivity.class);
                intent.putExtra(Setting.SAL_EXTRA, userSetting.getSalary());
                intent.putExtra(Setting.BON_EXTRA, userSetting.getBonus());
                intent.putExtra(Setting.STO_EXTRA, userSetting.getStock());
                intent.putExtra(Setting.FUN_EXTRA, userSetting.getFund());
                intent.putExtra(Setting.HOL_EXTRA, userSetting.getHoliday());
                intent.putExtra(Setting.STIP_EXTRA, userSetting.getStipend());
                startActivity(intent);
            }
        }

        if (R.id.adjustSettingBtn == view.getId()) {
            if (userSetting != null) {
                Intent intent = new Intent(MainActivity.this, AdjustSettingsActivity.class);
                intent.putExtra(Setting.SAL_EXTRA, userSetting.getSalary());
                intent.putExtra(Setting.BON_EXTRA, userSetting.getBonus());
                intent.putExtra(Setting.STO_EXTRA, userSetting.getStock());
                intent.putExtra(Setting.FUN_EXTRA, userSetting.getFund());
                intent.putExtra(Setting.HOL_EXTRA, userSetting.getHoliday());
                intent.putExtra(Setting.STIP_EXTRA, userSetting.getStipend());
                startActivity(intent);
            }
        }

        if (R.id.compareJobsBtn == view.getId()) {
            startActivity(new Intent(MainActivity.this, JobsActivity.class));
        }

    }
}