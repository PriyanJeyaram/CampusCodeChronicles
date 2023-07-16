package priyan.lab1.agecalculator;

import android.app.DatePickerDialog;
import org.joda.time.Days;
import org.joda.time.Months;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    final Calendar myCalendar=Calendar.getInstance();
    EditText e1,e3;
    Button b;
    Date date1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextDate);
        e3 = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.button);
        b.setOnClickListener(view -> {
            String db=String.valueOf(e1.getText());
            try {
                date1=new SimpleDateFormat("MM/dd/yyyy").parse(db);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date dt=new Date();
            int year=dt.getYear() + 1900;
            String z=e1.getText().toString().substring(6);
            int y2=Integer.parseInt(z);

            Toast.makeText(getApplicationContext(),z,Toast.LENGTH_SHORT).show();
            int age=Math.abs(year-y2);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate= formatter.format(date);
            String str2Date=formatter.format(date1);
            strDate=strDate.replace("/","-");
            str2Date=str2Date.replace("/","-");
            String first=strDate.substring(6)+"-"+strDate.substring(0,2)+"-"+strDate.substring(3,5);
            String second;
            if(age<22) {
                second = "20" + str2Date.substring(8) + "-" + str2Date.substring(0, 2) + "-" + str2Date.substring(3, 5);
            }
            else
            {
                second = "19" + str2Date.substring(8) + "-" + str2Date.substring(0, 2) + "-" + str2Date.substring(3, 5);
            }
            String y="";
            for(int i=0;i<4;i++)
            {
                y+=second.charAt(i);
            }
            int yr=Integer.parseInt(y);
            yr=yr+age;
            System.out.println(yr);
            String rep=Integer.toString(yr);
            second=second.replace(y,rep);


            org.joda.time.LocalDate datebef=org.joda.time.LocalDate.parse(first);
            org.joda.time.LocalDate dateAft=org.joda.time.LocalDate.parse(second);


            long mdiff=Math.abs(Months.monthsBetween(datebef,dateAft).getMonths());
            long daysdiff=Math.abs(Days.daysBetween(datebef,dateAft).getDays());
            daysdiff=daysdiff%30;

            String agediff=age+"years"+" "+mdiff+"months"+" "+daysdiff+"days";
            e3.setText(agediff);

        });
        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };
        e1.setOnClickListener(view -> new DatePickerDialog(MainActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
    }


    private void updateLabel()
    {
        String myFormat="MM/dd/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        e1.setText(dateFormat.format(myCalendar.getTime()));
    }

}

