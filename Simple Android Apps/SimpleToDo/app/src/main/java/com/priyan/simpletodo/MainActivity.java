package com.priyan.simpletodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> todoList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    EditText taskText;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Init listView
        todoList.add("Add a new task by clicking on the option menu");
        todoList.add("Update a task");
        todoList.add("Delete a task after completion");

//        Link to XML
        listView = findViewById(R.id.listview);

//        Set the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, todoList);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                taskText = new EditText(this);
                new AlertDialog.Builder(this)
                        .setTitle("Add a TODO :)")
                        .setView(taskText)
                        .setPositiveButton("Add Task", ((dialogInterface, i) -> {
                            todoList.add(taskText.getText().toString());
                            adapter.notifyDataSetChanged();
                        }))
                        .setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.cancel()))
                        .show();
                return true;
            case R.id.delete:
                SparseBooleanArray checked=listView.getCheckedItemPositions();
                if(checked.size() < 1) {
                    Toast.makeText(this, "Kindly select 1 or more tasks to delete :)", Toast.LENGTH_SHORT).show();
                    checked.clear();
                }else {
                    ArrayList<String> selectedItems = new ArrayList<>();
                    for (int i = 0; i < checked.size(); i++) {
                        int position = checked.keyAt(i);
                        if (checked.valueAt(i)) {
                            selectedItems.add(adapter.getItem(position));
                        }
                    }
                    for (String k : selectedItems) {
                        todoList.remove(k);
                        adapter.notifyDataSetChanged();
                    }
                    checked.clear();
                }
                return true;
            case R.id.update:
                SparseBooleanArray check =listView.getCheckedItemPositions();
                if(check.size() > 1) {
                    Toast.makeText(this, "Kindly edit one at a time :)", Toast.LENGTH_SHORT).show();
                    check.clear();
                }else {
                    pos = check.keyAt(0);
                    taskText = new EditText(this);
                    new AlertDialog.Builder(this)
                            .setTitle("Update Task :)")
                            .setView(taskText)
                            .setPositiveButton("Update Task", ((dialogInterface, i) -> {
                                todoList.set(pos, taskText.getText().toString());
                                adapter.notifyDataSetChanged();
                            }))
                            .setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.cancel()))
                            .show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}