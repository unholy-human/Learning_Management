package com.example.learningmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        // spinner item initialization
        Spinner spinner = findViewById(R.id.spinner);

        ArrayList<String> categories = new ArrayList<>();
        categories.add("---");
        categories.add("Front-end");
        categories.add("Back-end");

//        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //spinner handler
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 -> displayNOTHING();
                    case 1 -> displayFrontEnd();
                    case 2 -> displayBackEnd();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void displayFrontEnd(){
        tv.setText("Front-end");
    }
    void displayNOTHING(){
        tv.setText("NOTHING");
    }
     void displayBackEnd(){
        tv.setText("Back-end");
    }
}