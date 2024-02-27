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

public class JobAdapter extends ArrayAdapter<Job> {
    public JobAdapter(Context context, List<Job> jobs)
    {
        super(context, 0, jobs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Job job = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.job_cell, parent, false);


        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView company = convertView.findViewById(R.id.cellCompany);

        title.setText(job.getTitle());
        System.out.println(job.getTitle() + "hello!");
        company.setText(job.getCompany());



        return convertView;
    }
}
