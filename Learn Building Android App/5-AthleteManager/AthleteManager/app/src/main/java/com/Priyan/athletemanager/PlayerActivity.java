package com.Priyan.athletemanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    CustomDbHandler handler;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList = new ArrayList<>();
    int tempId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        handler = new CustomDbHandler(this);
        Cursor cursor = handler.getAllAthletes();
        if (cursor.moveToFirst()) {
            do {
                String player = new StringBuilder()
                        .append("ID: ").append(cursor.getString(0)).append("    \t")
                        .append("Name: ").append(cursor.getString(1)).append("\n")
                        .append("Age: ").append(cursor.getString(2)).append("    \t")
                        .append("Height: ").append(cursor.getString(3)).append("\n")
                        .toString();
                arrayList.add(player);
                tempId = Integer.parseInt(cursor.getString(0));
            } while (cursor.moveToNext());
            cursor.close();
        }

//        Configuring the listView
        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, arrayList);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // Enables user to select multiple values
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit) {
            SparseBooleanArray chosenItem = listView.getCheckedItemPositions();
            if (chosenItem.size() == 0) {
                Toast.makeText(this, "Nothing Chosen to Edit!!", Toast.LENGTH_SHORT).show();
            } else if (chosenItem.size() > 1) {
                Toast.makeText(this, "Kindly choose one time at a time to edit", Toast.LENGTH_SHORT).show();
            } else {
                int pos = chosenItem.keyAt(0);
                String line = adapter.getItem(pos);
                int id = Integer.parseInt(String.valueOf(line.charAt(4)));
                Intent i = new Intent(getApplicationContext(),UpdatePlayer.class);
                i.putExtra("id", id);
                startActivity(i);
                adapter.notifyDataSetChanged();
            }
        } else if (item.getItemId() == R.id.purge) {
            SparseBooleanArray chosenItem = listView.getCheckedItemPositions();
            if (chosenItem.size() == 0) {
                Toast.makeText(this, "Choose something to delete!!", Toast.LENGTH_SHORT).show();
            }else {
                for (int i = chosenItem.size(); i >= 0; i--) {
                    if(chosenItem.valueAt(i)) {
                        int pos = chosenItem.keyAt(i);
                        String line = adapter.getItem(pos);
                        Toast.makeText(this, " " + line.charAt(4), Toast.LENGTH_SHORT).show();
                        handler.deleteAthlete(Integer.parseInt(String.valueOf(line.charAt(4))));
                        arrayList.remove(chosenItem.keyAt(i));
                    }
                }
                adapter.notifyDataSetChanged();
                chosenItem.clear();
            }
        }
        return true;
    }

}