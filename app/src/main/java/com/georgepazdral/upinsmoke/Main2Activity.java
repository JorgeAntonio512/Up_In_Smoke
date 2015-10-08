package com.georgepazdral.upinsmoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {

    private int i;
    private TextView totCigs;
    private TextView mTextView;
    private long ageWantInMilli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        String age = bundle.getString("ages");
        TextView agez = (TextView)findViewById(R.id.agez);
        agez.setText("Your wish is to live to be " + age + " years old.");
        Button cigsPlus = (Button) findViewById(R.id.plusOneCig);
        totCigs = (TextView) findViewById(R.id.totalCigs);
        mTextView = (TextView) findViewById(R.id.textView);
        i = 0;

        //int ageWant = Integer.parseInt(age);
        //long yearInMilli = 31536000000L;
        ageWantInMilli = 0;
        //LocalDate dt = new LocalDate();
        //LocalDate added = dt.plusYears(ageWant);


        cigsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i +1;
                ageWantInMilli = ageWantInMilli + 11;
            totCigs.setText("You have smoked " + i + " total cigarettes.");
                Calendar c = Calendar.getInstance();
                mTextView.setText("After that cigarette, you have now lost " + ageWantInMilli + " minutes off your life.");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
