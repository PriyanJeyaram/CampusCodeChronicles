package com.priyan.geocoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String lat, lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialize the components
        EditText ed1 = findViewById(R.id.editTextTextPersonName);
        TextView tv1 = findViewById(R.id.textView6);
        TextView tv2 = findViewById(R.id.textView7);
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);

        b1.setOnClickListener(view -> {
            String location = ed1.getText().toString();
//        Code for GeoCoder
            Geocoder geocoder = new Geocoder(this);
            List<Address> addressList;
            try {
                addressList = geocoder.getFromLocationName(location, 1);
                if(addressList != null){
                    Address addressLine = addressList.get(0);
                    lat = String.valueOf(addressLine.getLatitude());
                    lon = String.valueOf(addressLine.getLongitude());
                    tv1.setText(lat);
                    tv2.setText(lon);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        });
        b2.setOnClickListener(view -> {
            Uri loc = Uri.parse("geo:" + lat + "," + lon);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, loc);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }
}