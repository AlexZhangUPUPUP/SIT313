package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class first_game extends AppCompatActivity {

    Button backButton;

    ImageView tankView;


    ImageButton upButton;
    ImageView  downButton;
    ImageView  leftButton;
    ImageView  rightButton;

    int direction; //  1 up ,2 down ,3 left ,4 right


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);

        backButton =findViewById(R.id.backbutton);

        tankView =findViewById(R.id.tankView);


        upButton =findViewById(R.id.upButton);
        downButton=findViewById(R.id.downButton);
        leftButton=findViewById(R.id.leftButton);
        rightButton=findViewById(R.id.rightButton);

        direction =2;// the original direction is up


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_game.this,MainActivity.class);
                startActivity(intent);

            }
        });// back to the mainActivity


        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tankView.setPivotX(tankView.getWidth()/2);
                tankView.setPivotY(tankView.getHeight()/2);




                    tankView.setPivotX(tankView.getWidth()/2);
                    tankView.setPivotY(tankView.getHeight()/2);
                    Toast.makeText(getApplicationContext(),"the direction is down" ,Toast.LENGTH_SHORT).show();
                    tankView.setRotation(180);




                //direction =2; //set new direction

                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) tankView.getLayoutParams();


                if(par.topMargin - 30 > 0){

                    par.topMargin = par.topMargin - 30;
                    par.bottomMargin = par.bottomMargin + 30;

                    tankView.setLayoutParams(par);
                }
                else {

                    Toast.makeText(getApplicationContext(),"the topMargin is not enough:" ,Toast.LENGTH_SHORT).show();
                }


            }
        });//Move the tank up


        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                tankView.setPivotX(tankView.getWidth()/2);
                tankView.setPivotY(tankView.getHeight()/2);






                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) tankView.getLayoutParams();

                if(par.bottomMargin - 30 > 0){

                    par.bottomMargin = par.bottomMargin - 30;
                    par.topMargin = par.topMargin + 30;

                    tankView.setLayoutParams(par);
                }
                else {

                    Toast.makeText(getApplicationContext(),"the bottomMargin is not enough:" ,Toast.LENGTH_SHORT).show();
                }


            }
        });//move the tank down




        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) tankView.getLayoutParams();

                if(par.leftMargin - 30 > 0){

                    par.leftMargin = par.leftMargin - 30;
                    par.rightMargin  =par.rightMargin+30;

                    //int i =par.leftMargin;

                    //Toast.makeText(getApplicationContext(),"the leftMargin is:  "+i+"  ",Toast.LENGTH_SHORT).show();
                    tankView.setLayoutParams(par);
                }
                else {

                    Toast.makeText(getApplicationContext(),"the leftMargin is not enough:" ,Toast.LENGTH_SHORT).show();
                }

            }
        });// Move the tank left


        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) tankView.getLayoutParams();

                if(par.rightMargin - 30 > 0){

                    par.rightMargin = par.rightMargin - 30;
                    par.leftMargin  =par.leftMargin   + 30;

                    tankView.setLayoutParams(par);

                    int i =par.rightMargin;
                    Toast.makeText(getApplicationContext(),"the rightMargin is:  "+i+"  ",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(),"the rightMargin is not enough:" ,Toast.LENGTH_SHORT).show();

                    //int i =par.rightMargin;
                    //Toast.makeText(getApplicationContext(),"the rightMargin is:  "+i+"  ",Toast.LENGTH_SHORT).show();
                }

            }
        });// move the tant right




    }
}