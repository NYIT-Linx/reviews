package com.example.reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class nag extends AppCompatActivity {


    private Button addbuttonnag, ViewDatabuttonnag;
    private EditText reviewnag;
    Firebase reference14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nag);
        reviewnag = (EditText) findViewById(R.id.reviewbuttonha);
        addbuttonnag = (Button) findViewById(R.id.addbuttonha);
        ViewDatabuttonnag = (Button) findViewById(R.id.ViewDatabuttonha);

        Firebase.setAndroidContext(this);
        reference14 = new Firebase("https://linx-chat-a7f8c.firebaseio.com/nagreview/");

        addbuttonnag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = reviewnag.getText().toString();
                if (reviewnag.length() != 0) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("review", newEntry);
                    reference14.push().setValue(map);
                    toastMessage("Data Successfully Inserted!");

                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });
        reference14.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String review = map.get("review").toString();


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        ViewDatabuttonnag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nag.this, ListLayout.class);
                startActivity(intent);
            }
        });

    }


    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}