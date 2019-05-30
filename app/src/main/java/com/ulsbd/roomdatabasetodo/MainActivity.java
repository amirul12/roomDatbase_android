package com.ulsbd.roomdatabasetodo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addButton;
    private RecyclerView recyclerView;
    private FrameLayout fragmentNoData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentNoData = (FrameLayout) findViewById(R.id.fragmentNoData);
        fragmentNoData.setVisibility(View.GONE);

        recyclerView = (RecyclerView) findViewById(R.id.recyTodoList);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addButton = (FloatingActionButton) findViewById(R.id.fbtnAdd);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AddTaskActivity.class));

            }
        });

        getTask();


    }

    private void getTask() {

        class GetTask extends AsyncTask<Void, Void, List<Task>>{


            @Override
            protected List<Task> doInBackground(Void... voids) {

                List<Task> taskList = DatabaseClient.getInstance(getApplicationContext())
                        .getAppDatabase()
                        .taskDao()
                        .getAll();

                return taskList;
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                super.onPostExecute(tasks);

                if (tasks.isEmpty()){

                    recyclerView.setVisibility(View.GONE);
                    fragmentNoData.setVisibility(View.VISIBLE);

                }

                TasksAdapter adapter = new TasksAdapter(MainActivity.this, tasks);
                recyclerView.setAdapter(adapter);
            }
        }

        GetTask getTask = new GetTask();
        getTask.execute();


    }



}
