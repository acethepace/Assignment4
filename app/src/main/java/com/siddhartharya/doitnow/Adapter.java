package com.siddhartharya.doitnow;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Siddharth Arya on 07-Nov-16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    ArrayList<Task> tasks;
    MainActivity activity;

    public Adapter(ArrayList<Task> tasks, MainActivity activity) {
        this.tasks = tasks;
        this.activity = activity;
    }

    @Override

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(activity)
                .inflate(R.layout.list_child, parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        Task task = tasks.get(position);
        holder.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 07-Nov-16 remove task
                DataSupplier.tasks.remove(position);
                DataSupplier.writeData(activity);

                activity.refreshRecyclerView();
            }
        });
        holder.title.setText(task.title);
        holder.description.setText(task.description);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, TaskDetail.class);
                i.putExtra("task", position);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView checkButton;
        TextView title, description;
        public Holder(View itemView) {
            super(itemView);
            checkButton = (ImageView) itemView.findViewById(R.id.check_button);
            title = (TextView) itemView.findViewById(R.id.titleText);
            description = (TextView) itemView.findViewById(R.id.descriptionText);

        }
    }

}
