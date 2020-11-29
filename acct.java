package com.example.reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class acct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acct);

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinnerC);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(acct.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.acctprofessors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter);

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==2){
                    startActivity(new Intent(acct.this,
                            nag.class));

                }
                if(i==3){
                    startActivity(new Intent(acct.this,
                            nam.class));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}