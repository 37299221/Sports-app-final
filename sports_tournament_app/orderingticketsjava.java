package com.example.sports_tournament_app;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class orderingticketsjava extends AppCompatActivity {

    Button football, tennis, tabletennis, addons, tickets;

    dbhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordering_tickets_page);

        football = findViewById(R.id.football);
        tennis = findViewById(R.id.tennis);
        tabletennis = findViewById(R.id.tabletennis);
        addons = findViewById(R.id.addons);
        tickets = findViewById(R.id.ticket);

        DB = new dbhelper(this);



        //Below does not work. The plan was to use several buttons to add values to the database alongside user information. I did not have enough time or experience to attempt this.
        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(orderingticketsjava.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Football ordered " + "\n");
                    buffer.append("Tennis ordered " + res.getString(1) + "\n");
                    buffer.append("Table Tennis ordered " + res.getString(2) + "\n");

                    //Other decorator class bits to add on if necessary. One button would go to other buttons to allow mor options to appear. Could be used several times if needed.
                    buffer.append("Addon (food) ordered " + res.getString(3) + "\n");
                    buffer.append("Addon (drink) ordered " + res.getString(4) + "\n");
                    buffer.append("Addon (raffle ticket) " + res.getString(5) + "\n\n");
                }

                //A small box structure would appear with the above. Would display a 'ticket' with the ordered extras and stuff.
                AlertDialog.Builder builder = new AlertDialog.Builder(orderingticketsjava.this);
                builder.setCancelable(true);
                builder.setTitle("Tickets Ordered");
                builder.setMessage(buffer.toString());
                builder.show();

    }
    });
    }}
