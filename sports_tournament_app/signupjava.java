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

public class signupjava extends AppCompatActivity {

    //Buttons and other input text fields
    EditText name, contact;
    Button insert, home;
    dbhelper DB;


    //Xml things are linked to this file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        insert = findViewById(R.id.btnInsert);
        home = findViewById(R.id.btnHome);

        DB = new dbhelper(this);

        //Insert button allows user to create an account. Stores anything that is inputted into the text fields into the database.
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT);

                if (checkinsertdata == true) {
                    Toast.makeText(signupjava.this,"New Entry Inserted", Toast.LENGTH_SHORT).show();
                    openOrderingTickets();

                } else {
                    Toast.makeText(signupjava.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Button click-thing for home.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });

    }

    //Methods for opening relevant pages.
    public void openHomepage() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void openOrderingTickets() {
        Intent intent = new Intent (this, orderingticketsjava.class);
        startActivity(intent);
    }

}