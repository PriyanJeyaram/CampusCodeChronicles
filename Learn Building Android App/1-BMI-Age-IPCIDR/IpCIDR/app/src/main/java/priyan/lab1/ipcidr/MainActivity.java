package priyan.lab1.ipcidr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private TextView t1, t2, t3;
    private EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        e1 = findViewById(R.id.etUsername);
        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView3);
        t3 = findViewById(R.id.textView5);
        b.setOnClickListener(view -> {
            // First Address
            // Last Address
            // Total
            String inp = e1.getText().toString(); //Get Input
            String[] s = inp.split("/");
            int mask = Integer.parseInt(s[1]);
            int range = 32 - mask;
            int total = (int) Math.pow(2,range);
            String[] arr = s[0].split("\\.");
            String arr2[]=new String[arr.length];
            for(int i=0;i<arr.length;i++)
            {
                arr2[i]=arr[i];
            }
            int len = arr.length;
            int q = range/8;

            while (q != 0) {
                arr[len-1] = "0";
                arr2[len-1] = "255";
                len--;
                q--;
            }

            int rem = range % 8;
            String bin = Integer.toString(Integer.parseInt(arr[len-1]), 2);
            String bin2 = Integer.toString(Integer.parseInt(arr2[len-1]), 2);

            String tem ="";
            String tem2 ="";
            for(int i = 0; i < bin.length()-rem; i++) {
                tem += bin.charAt(i);
                tem2 += bin2.charAt(i);
            }

            for(int i = bin.length()- rem; i < bin.length(); i++) {
                tem += "0";
                tem2 += "1";
            }

//        Coverting to Decimal
            int first = Integer.parseInt(tem,2);
            int last = Integer.parseInt(tem2,2);

            arr[len-1] = Integer.toString(first);
            arr2[len-1] = Integer.toString(last);

            String firstAdd = String.join(".", arr);
            String lastAdd = String.join(".", arr2);

            t1.setText("Total number of Hosts: " + total);
            t2.setText(firstAdd);
            t3.setText(lastAdd);
        });
    }
}