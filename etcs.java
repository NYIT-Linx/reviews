package com.example.reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class etcs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etcs);

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinnerC);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(etcs.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.etcsprofessors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter);

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==2){
                    startActivity(new Intent(etcs.this,
                            artan.class));

                }
                if(i==3){
                    startActivity(new Intent(etcs.this,
                            baghaie.class));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}