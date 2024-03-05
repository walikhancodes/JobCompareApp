package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {
    private static SQLiteManager sqLiteManager;
    private static final String DATABASE_NAME = "JobDB";
    private static final int DATABASE_VERSION = 1;
    private static final String JOB_TABLE_NAME = "Job";
    private static final String COUNTER = "Counter";

    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String COMPANY_FIELD = "company";
    private static final String LOCATION_FIELD = "location";

    private static final String COST_FIELD = "cost";
    private static final String SALARY_FIELD = "salary";
    private static final String BONUS_FIELD = "bonus";
    private static final String STOCK_FIELD = "stock";
    private static final String FUND_FIELD = "fund";

    private static final String HOLIDAY_FIELD = "holiday";

    private static final String STIPEND_FIELD = "stipend";
    private static final String JOBSCORE_FIELD = "jobscore";
    private static final String ISCURRENT_FIELD = "is_current";

    private static final String SETTING_TABLE_NAME = "Setting";
    private static final String SETTING_ID_FIELD = "id";
    private static final String SETTING_SALARY_FIELD = "salary";

    private static final String SETTING_BONUS_FIELD = "bonus";
    private static final String SETTING_STOCK_FIELD = "stock";
    private static final String SETTING_FUND_FIELD = "fund";
    private static final String SETTING_HOLIDAY_FIELD = "holiday";
    private static final String SETTING_STIPEND_FIELD = "stipend";


    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteManager instanceOfDatabase(Context context) {
        if (sqLiteManager == null) {
            sqLiteManager = new SQLiteManager(context);
        }

        return sqLiteManager;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(JOB_TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(TITLE_FIELD)
                .append(" TEXT, ")
                .append(COMPANY_FIELD)
                .append(" TEXT, ")
                .append(LOCATION_FIELD)
                .append(" TEXT, ")
                .append(COST_FIELD)
                .append(" INT, ")
                .append(SALARY_FIELD)
                .append(" DOUBLE, ")
                .append(BONUS_FIELD)
                .append(" DOUBLE, ")
                .append(STOCK_FIELD)
                .append(" INT, ")
                .append(FUND_FIELD)
                .append(" DOUBLE, ")
                .append(HOLIDAY_FIELD)
                .append(" INT, ")
                .append(STIPEND_FIELD)
                .append(" DOUBLE, ")
                .append(ISCURRENT_FIELD)
                .append(" BOOLEAN, ")
                .append(JOBSCORE_FIELD)
                .append(" DOUBLE); ");

        db.execSQL(sql.toString());

        StringBuilder userSettingsTableSql;
        userSettingsTableSql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(SETTING_TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(SETTING_ID_FIELD)
                .append(" INT, ")
                .append(SETTING_SALARY_FIELD)
                .append(" INT, ")
                .append(SETTING_BONUS_FIELD)
                .append(" INT, ")
                .append(SETTING_STOCK_FIELD)
                .append(" INT, ")
                .append(SETTING_FUND_FIELD)
                .append(" INT, ")
                .append(SETTING_HOLIDAY_FIELD)
                .append(" INT, ")
                .append(SETTING_STIPEND_FIELD)
                .append(" INT); ");

        db.execSQL(userSettingsTableSql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + JOB_TABLE_NAME);
        onCreate(db);
    }

    public void addJobToDatabase(Job job) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, job.getId());
        contentValues.put(TITLE_FIELD, job.getTitle());
        contentValues.put(COMPANY_FIELD, job.getCompany());
        contentValues.put(LOCATION_FIELD, job.getLocation());
        contentValues.put(COST_FIELD, job.getCost());
        contentValues.put(SALARY_FIELD, job.getSalary());
        contentValues.put(BONUS_FIELD, job.getBonus());
        contentValues.put(STOCK_FIELD, job.getStock());
        contentValues.put(FUND_FIELD, job.getFund());
        contentValues.put(HOLIDAY_FIELD, job.getHolidays());
        contentValues.put(STIPEND_FIELD, job.getStipend());
        contentValues.put(ISCURRENT_FIELD, job.isCurrent());
        sqLiteDatabase.insert(JOB_TABLE_NAME, null, contentValues);
    }

    public void populateJobListArray() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + JOB_TABLE_NAME, null)) {
            if(result.getCount() != 0) {
                while (result.moveToNext()) {
                    int id = result.getInt(1);
                    String title = result.getString(2);
                    String company = result.getString(3);
                    String location = result.getString(4);
                    int cost = result.getInt(5);
                    float salary = result.getFloat(6);
                    float bonus = result.getFloat(7);
                    int stock = result.getInt(8);
                    float fund = result.getFloat(9);
                    int holiday = result.getInt(10);
                    float stipend = result.getFloat(11);
                    int isCurrentInt = result.getInt(12);
                    boolean isCurrent = (isCurrentInt == 1);
                    Job job = new Job(id, title, company, location, cost, salary, bonus, stock, fund, holiday, stipend, isCurrent);
                    Setting userSetting = getUserSetting();
                    job.calculateScore(userSetting.getSalary(), userSetting.getBonus(), userSetting.getStock(), userSetting.getFund(), userSetting.getHoliday(), userSetting.getStipend());
                    Job.jobArrayList.add(job);
                }
            }
        }
    }

    public void updateCurrentJob(Job job) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, job.getId());
        contentValues.put(TITLE_FIELD, job.getTitle());
        contentValues.put(COMPANY_FIELD, job.getCompany());
        contentValues.put(LOCATION_FIELD, job.getLocation());
        contentValues.put(COST_FIELD, job.getCost());
        contentValues.put(SALARY_FIELD, job.getSalary());
        contentValues.put(BONUS_FIELD, job.getBonus());
        contentValues.put(STOCK_FIELD, job.getStock());
        contentValues.put(FUND_FIELD, job.getFund());
        contentValues.put(HOLIDAY_FIELD, job.getHolidays());
        contentValues.put(STIPEND_FIELD, job.getStipend());
        contentValues.put(ISCURRENT_FIELD, job.isCurrent());

        sqLiteDatabase.update(JOB_TABLE_NAME, contentValues, ID_FIELD + " =? ", new String[]{String.valueOf(job.getId())});

    }

    public void saveUserSettings(Setting setting) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SETTING_SALARY_FIELD, setting.getSalary());
        contentValues.put(SETTING_BONUS_FIELD, setting.getBonus());
        contentValues.put(SETTING_STOCK_FIELD, setting.getStock());
        contentValues.put(SETTING_FUND_FIELD, setting.getFund());
        contentValues.put(SETTING_HOLIDAY_FIELD, setting.getHoliday());
        contentValues.put(SETTING_STIPEND_FIELD, setting.getStipend());

        sqLiteDatabase.update(SETTING_TABLE_NAME, contentValues, SETTING_ID_FIELD + " =? ", new String[]{String.valueOf(setting.getId())});
    }

    public Setting getUserSetting() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Setting setting = null;
        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + SETTING_TABLE_NAME, null)) {
            if (result.getCount() != 0) {
                // Move the cursor to the first row to get the first record
                result.moveToFirst();
                int salary = result.getInt(2);
                int bonus = result.getInt(3);
                int stock = result.getInt(4);
                int fund = result.getInt(5);
                int holiday = result.getInt(6);
                int stipend = result.getInt(7);

                setting = new Setting(salary, bonus, stock, fund, holiday, stipend);
                return setting;
            } else {
                setting = new Setting();

                sqLiteDatabase = this.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put(SETTING_ID_FIELD, setting.getId());
                contentValues.put(SETTING_SALARY_FIELD, setting.getSalary());
                contentValues.put(SETTING_BONUS_FIELD, setting.getBonus());
                contentValues.put(SETTING_STOCK_FIELD, setting.getStock());
                contentValues.put(SETTING_FUND_FIELD, setting.getFund());
                contentValues.put(SETTING_HOLIDAY_FIELD, setting.getHoliday());
                contentValues.put(SETTING_STIPEND_FIELD, setting.getStipend());

                sqLiteDatabase.insert(SETTING_TABLE_NAME, null, contentValues);
                return setting;
            }
        }
    }
}
