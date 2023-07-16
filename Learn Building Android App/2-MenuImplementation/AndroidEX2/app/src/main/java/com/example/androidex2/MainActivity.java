package com.example.androidex2;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String contacts[]={"Ram","Krishna","Hari","Vittal","Arjun"};
    String numbers[]={"9942715224","9597672617","7339192579","7010129936","9965889887"};
    List<String> cncts=new ArrayList<>(Arrays.asList(contacts));
    List<String> nos=new ArrayList<>(Arrays.asList(numbers));
    ArrayAdapter<String> adapter;
    int itemValue;
    private String m_Text = "";
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listview);

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, cncts);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            itemValue= i;
            return false;
        });

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        menu.setHeaderTitle("User Actions");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.call){
            String con=nos.get(itemValue);
            Uri u=Uri.parse("tel:"+con);
            Intent i=new Intent(Intent.ACTION_DIAL,u);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.add:
                // do your code
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setTitle("New Name");

// Set up the input
                final EditText inp = new EditText(this);
                final EditText no=new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                inp.setInputType(InputType.TYPE_CLASS_TEXT );
                no.setInputType(InputType.TYPE_CLASS_PHONE);
                build.setView(inp);

// Set up the buttons
                build.setPositiveButton("OK", (dialog, which) -> {
                    m_Text = inp.getText().toString();
                    cncts.add(m_Text);
                    adapter.notifyDataSetChanged();
                    AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                    b.setTitle("Enter no");
                    b.setView(no);
                    b.setPositiveButton("Enter", (dialog1, which1) -> {
                        String n_text=no.getText().toString();
                        nos.add(n_text);
                    });
                   b.show();

                });
                build.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                build.show();
                return true;
            case R.id .edit:
                // do your code
                SparseBooleanArray check=listView.getCheckedItemPositions();
                ArrayList<String> selected=new ArrayList<String>();
                for (int i = 0; i < check.size(); i++) {
                    // Item position in adapter
                    int position = check.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (check.valueAt(i))
                        selected.add(adapter.getItem(position));
                }
                for(String k:selected)
                {
                      pos=cncts.indexOf(k);

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("New Name");

// Set up the input
                final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", (dialog, which) -> {
                    m_Text = input.getText().toString();
                    cncts.set(pos,m_Text);
                    adapter.notifyDataSetChanged();

                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
                selected.clear();
                return true;
            case R.id.delete:
                // do your code
                SparseBooleanArray checked=listView.getCheckedItemPositions();

                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    // Item position in adapter
                    int position = checked.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))
                        selectedItems.add(adapter.getItem(position));
                }
                for(String k:selectedItems)
                {
                    int sop=cncts.indexOf(k);
                    cncts.remove(sop);
                    nos.remove(sop);
                     adapter.notifyDataSetChanged();
                }
                checked.clear();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }

}