package com.example.sports_tournament_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class helpjava extends AppCompatActivity {

    //Button for home
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout name
        setContentView(R.layout.help_page);

        home = findViewById(R.id.btnHome);

        //Calling button method
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

    }

    //Method puts user on MainActivity (homepage).
    public void openHome() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}
