package Priyan.Lab1.BMICalculator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText ht;
    private SeekBar wt;
    String age = "";

    String[] ageArr = {"0-18", "19-60"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wt = findViewById(R.id.seekBar);
        ht = findViewById(R.id.editTextNumber);
        ImageButton b1 = findViewById(R.id.imageButton);
        Spinner s = findViewById(R.id.spinner);

        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ageArr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        s.setOnItemSelectedListener(this);

        wt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(), "Weight: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        b1.setOnClickListener(view -> {
            double height = Double.parseDouble(String.valueOf(ht.getText()));
            height /= 100.0;
            double weight = (double) wt.getProgress();
            double bmi = weight/(height* height);
            bmi = Math.round((bmi*100.0)/100.0);

            if(age.equals("0-18")){
                Toast.makeText(getApplicationContext(), "BMI can't be calculated!", Toast.LENGTH_SHORT).show();
            }else if (bmi < 18) {
                Toast.makeText(getApplicationContext(), "Under Weight", Toast.LENGTH_SHORT).show();
            }else if (bmi > 25) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setMessage("You are endangered! Your BMI is: " + bmi);
                b.setTitle("DEATH SENTENCE");
                b.setCancelable(true);
                b.setPositiveButton("Proceed to deathbed", (dialogInterface, i) -> dialogInterface.cancel());
                AlertDialog ad = b.create();
                ad.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), ageArr[i], Toast.LENGTH_LONG).show();
        age=ageArr[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}