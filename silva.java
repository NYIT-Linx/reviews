package com.example.reviews;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reviews.DatabaseHelper;
import com.example.reviews.ListLayout;
import com.example.reviews.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class silva extends AppCompatActivity {




    private Button addbuttons, ViewDatabuttons;
    private EditText reviews;
    Firebase reference6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silva);
        reviews = (EditText) findViewById(R.id.reviewbuttons);
        addbuttons = (Button) findViewById(R.id.addbuttons);
        ViewDatabuttons = (Button) findViewById(R.id.ViewDatabuttons);

        Firebase.setAndroidContext(this);
        reference6 = new Firebase("https://linx-chat-a7f8c.firebaseio.com/silvareview/");

        addbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = reviews.getText().toString();
                if (reviews.length() != 0)
                {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("review", newEntry);
                    reference6.push().setValue(map);
                    toastMessage("Data Successfully Inserted!");

                }
                else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });
        reference6.addChildEventListener(new ChildEventListener() {
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


        ViewDatabuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(silva.this, ListLayout.class);
                startActivity(intent);
            }
        });

    }



    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}