package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;

public class Setting implements Serializable {
    public static String SAL_EXTRA = "salExtra";
    public static String BON_EXTRA = "bonExtra";
    public static String STO_EXTRA = "stoExtra";
    public static String FUN_EXTRA = "funExtra";
    public static String HOL_EXTRA = "holExtra";
    public static String STIP_EXTRA = "stipExtra";
    int id, salary, bonus, stock, fund, holiday, stipend;
    public Setting() {
        this.id = 1;
        this.salary = 1;
        this.bonus = 1;
        this.stock = 1;
        this.fund = 1;
        this.holiday = 1;
        this.stipend = 1;
    }

    public Setting(int salary, int bonus, int stock, int fund, int holiday, int stipend) {
        this.id = 1;
        this.salary = salary;
        this.bonus = bonus;
        this.stock = stock;
        this.fund = fund;
        this.holiday = holiday;
        this.stipend = stipend;
    }

    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public int getStipend() {
        return stipend;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }
}
