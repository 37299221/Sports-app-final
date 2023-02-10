package com.example.sports_tournament_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signinjava extends AppCompatActivity {

    //Java buttons.
    EditText name, contact;
    Button login, home;
    dbhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Linked Xml
        setContentView(R.layout.sign_in_page);

        //Linked Xml buttons
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);

        home = findViewById(R.id.btnHome);
        login = findViewById(R.id.btnLogin);

        //Connected database with a word that can be used to do certain things.
        DB = new dbhelper(this);

        //If the login button is clicked, then stuff happens.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Gets text from 3 input text fields and stores them in a string for later.
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();

                Boolean checkdata = DB.loginuserdata(nameTXT, contactTXT);


                //If that relevant data exists, then:
                if (checkdata == true) {

                    //Text appears to say that login works.
                    Toast.makeText(signinjava.this, "Logging in...", Toast.LENGTH_SHORT).show();

                    //COMMENTED OUT AS THIS CRASHES THE PROGRAM. LOGIN DOES NOT WORK.
                    //if (checkdata == true) {
                        //openOrderingTickets();
                    //}

                    //Text appears to show login does not work.
                } else {
                    Toast.makeText(signinjava.this, "Unable to login. Check you entered the correct details", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //Home button again.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });

    }

    public void openHomepage() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    //Like the above, just opens orderingticketsjava.java
    public void openOrderingTickets() {
        Intent intent = new Intent (this, orderingticketsjava.class);
        startActivity(intent);
    }

}