package com.priyan.carspecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView brandName, modelName;
    Button backButton;
    ImageView specView;
    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

//        Link to XML
        brandName = findViewById(R.id.textView4);
        modelName = findViewById(R.id.textView5);
        backButton = findViewById(R.id.button2);
        specView = findViewById(R.id.imageView);

        Bundle b = getIntent().getExtras();
        brandName.append(b.getString("BrandName"));
        String modelNameStr = b.getString("ModelName");

        modelName.append(modelNameStr);
        switch (modelNameStr) {
            case "Honda Accord":
                uri = "@drawable/honacc";
                break;
            case "Honda Civic":
                uri = "@drawable/honciv";
                break;
            case "Toyota Corolla":
                uri = "@drawable/toy";
                break;
            case "Chevrolet Corvette":
                uri = "@drawable/chev";
                break;
            default:
                uri = "@drawable/ford";
                break;
        }

        int imageRes = getResources().getIdentifier(uri, null, getPackageName());
        specView.setImageDrawable(getResources().getDrawable(imageRes));


        backButton.setOnClickListener(view -> {
            startActivity(new Intent(DisplayActivity.this, MainActivity.class));
        });

    }
}