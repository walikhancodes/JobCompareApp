package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;

public class Job {
    public static ArrayList<Job> jobArrayList = new ArrayList<>();

    public static ArrayList<Job> selectedJobs = new ArrayList<>();
    private int id;
    private String title, company, location;
    private int cost, stock, holidays;
    private double salary, bonus, fund, stipend;
    private boolean isCurrent;
    private double jobScore;


    public Job(int id, String title, String company, String location, int cost, double salary, double bonus, int stock, double fund, int holidays, double stipend, boolean isCurrent, double jobScore) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.cost = cost;
        this.salary = salary;
        this.bonus = bonus;
        this.stock = stock;
        this.fund = fund;
        this.holidays = holidays;
        this.stipend = stipend;
        this.isCurrent = isCurrent;
    }

    public static ArrayList<Job> getJobArrayList() {
        return jobArrayList;
    }

    public static void setJobArrayList(ArrayList<Job> jobArrayList) {
        Job.jobArrayList = jobArrayList;
    }

    public static void setSelectedJobs(ArrayList<Job> selectedJobs) {
        Job.selectedJobs = selectedJobs;
    }

    public static Job getCurrentJob() {
        for (Job job : jobArrayList) {
            System.out.println(job.salary);
            if (job.isCurrent) {
                return job;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public int getHolidays() {
        return holidays;
    }

    public void setHolidays(int holidays) {
        this.holidays = holidays;
    }

    public double getStipend() {
        return stipend;
    }

    public void setStipend(double stipend) {
        this.stipend = stipend;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public double getScore() {
        return jobScore;
    }

    public void setScore(double score) { this.jobScore = score; }
}
