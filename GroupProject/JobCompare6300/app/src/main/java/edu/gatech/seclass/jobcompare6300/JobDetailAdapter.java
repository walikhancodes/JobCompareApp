package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class JobDetailAdapter extends ArrayAdapter<Job> {

    public JobDetailAdapter(Context context,List<Job> jobs)
    {
        super(context, 0, jobs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Job job = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.job_details_cell, parent, false);


        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView company = convertView.findViewById(R.id.cellCompany);
        TextView location = convertView.findViewById(R.id.cellLocation);
        TextView salary = convertView.findViewById(R.id.cellSalary);
        TextView bonus = convertView.findViewById(R.id.cellBonus);
        TextView stock = convertView.findViewById(R.id.cellStock);
        TextView fund = convertView.findViewById(R.id.cellFund);
        TextView holiday = convertView.findViewById(R.id.cellHoliday);
        TextView stipend = convertView.findViewById(R.id.cellStipend);

        title.setText(job.getTitle());
        company.setText(job.getCompany());
        location.setText(job.getLocation());
        salary.setText(String.valueOf(job.getSalary()));
        bonus.setText(String.valueOf(job.getStock()));
        stock.setText(String.valueOf(job.getStock()));
        fund.setText(String.valueOf(job.getFund()));
        holiday.setText(String.valueOf(job.getHolidays()));
        stipend.setText(String.valueOf(job.getStipend()));

        return convertView;
    }
}
