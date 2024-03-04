package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
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
        TextView score = convertView.findViewById(R.id.cellScore);

        title.setText(job.getTitle());
        company.setText(job.getCompany());
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedScore = df.format(job.getScore());
        score.setText(formattedScore);

        return convertView;
    }
}
