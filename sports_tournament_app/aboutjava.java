package com.example.sports_tournament_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class aboutjava extends AppCompatActivity {


    //Java buttons here.
    Button home, help;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Xml page
        setContentView(R.layout.about_page);
        //Assigning buttons
        home = findViewById(R.id.btnHome);
        help =findViewById(R.id.btnHelp);

        //When each button is clicked, it uses the relevant method (created below) to open another java file / xml file.
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });

    }

    //Created methods to open up other files.
    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openHelp() {
        Intent intent = new Intent(this, helpjava.class);
        startActivity(intent);

    }

}
