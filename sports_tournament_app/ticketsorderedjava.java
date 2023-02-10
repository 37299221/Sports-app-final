package com.example.sports_tournament_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//Just a aregular page with a button and some text, shownig teh user that they have ordered a ticket.
public class ticketsorderedjava extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tickets_ordered_page);
        home = findViewById(R.id.Homebutton);

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
}