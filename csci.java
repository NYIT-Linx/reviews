package com.example.reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class csci extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csci);

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinnerC);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(csci.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.csciprofessors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter);

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==2){
                    startActivity(new Intent(csci.this,
                            akhtar.class));

                }
                if(i==3){
                    startActivity(new Intent(csci.this,
                            balagani.class));
                }
                if(i==4) {
                    startActivity(new Intent(csci.this,
                            bhatt.class));
                }
                if(i==5) {
                    startActivity(new Intent(csci.this,
                            gass.class));
                }
                if(i==6) {
                    startActivity(new Intent(csci.this,
                            huang.class));
                }
                if(i==7) {
                    startActivity(new Intent(csci.this,
                            kopecky.class));
                }
                if(i==8) {
                    startActivity(new Intent(csci.this,
                            lee.class));
                }
                if(i==9) {
                    startActivity(new Intent(csci.this,
                            newman .class));
                }
                if(i==10) {
                    startActivity(new Intent(csci.this,
                            nizich.class));
                }if(i==11) {
                    startActivity(new Intent(csci.this,
                            silva.class));
                }if(i==12) {
                    startActivity(new Intent(csci.this,
                            zhang.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}