package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button strat;
    Button history;
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strat =findViewById(R.id.start);
        history=findViewById(R.id.history);
        view =findViewById(R.id.tank1);

        strat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent( MainActivity.this, first_game.class);
                startActivity(intent);
            }
        }); //jump to the game


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });//jump to history
    }
}
