package com.siddhartharya.doitnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TaskAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void addTask(View view) {
        EditText et1 = (EditText) findViewById(R.id.titleET);
        EditText et2 = (EditText) findViewById(R.id.descriptionET);
        Task task = new Task();
        task.title = et1.getText().toString();
        task.description = et2.getText().toString();
        DataSupplier.tasks.add(task);
        DataSupplier.writeData(this);
        finish();
     }
}
