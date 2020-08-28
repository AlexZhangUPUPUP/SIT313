package com.example.timer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ImageButton button_Start;
    ImageButton button_Pause;
    ImageButton button_Stop;

    private Chronometer chronometer;

    //the time from start to pause
    private long Timer_after_pause;   String TIMER_AFTER_PAUSE;

    private boolean running;          String RUNNING;

    private String Last_Time;   //the text of text_view last time

    TextView textView;

    String minutes;
    String seconds;
    String hours;
    String text_string;

    Long endtime;

    /*
    There are two ways to show time,One is use getText.toString (First one).
    Another one is use hours/minuses and seconds (need to mang paramater) (Second one)
    When you use Stop button, it uses the second one
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        textView = (TextView)findViewById(R.id.textView);


        button_Start =findViewById(R.id.Start_Button);
        button_Pause =findViewById(R.id.Pause_Button);
        button_Stop  =findViewById(R.id.Stop_Button);


        button_Start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (running ==false) {

                    chronometer.setBase(SystemClock.elapsedRealtime() - Timer_after_pause);

                    chronometer.start();
                    running = true;
                }

                return false;
            }
        });

        //I try to use SetOnclickListener, but it  always have some trouble, whenI touch the Stop button, the time I spend will apprel only 1 second

        if(savedInstanceState != null) {
            //receive data

            Timer_after_pause = savedInstanceState.getLong("TIMER_AFTER_PAUSE");
            running = savedInstanceState.getBoolean("TIME-RUNNING");

            String time = savedInstanceState.getString("time");  // the text of textview


            textView.setText("You spent " + time + " on studying last time");


            if (running == true) {

                chronometer.setBase(SystemClock.elapsedRealtime());

                chronometer.start();
                running = true;
            }// if it is running,
            else
            {
                chronometer.setBase(SystemClock.elapsedRealtime() - Timer_after_pause); //the time of pasue, it is same as pause
                chronometer.stop();
                running = false;
            }//if it is stopping
        }
    }


    public void Start_Chronometer(View v){

            if (running ==false) {
                chronometer.setBase(SystemClock.elapsedRealtime() - Timer_after_pause);
                chronometer.start();
                running = true;
            }

    }

    public void Pause_Chronometer(View v) {
        if (running) {
            chronometer.stop();

            Timer_after_pause = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void Stop_Chronometer(View v) {
        chronometer.stop();
        String time = chronometer.getText().toString();

        textView.setText(("You spent  " + time + " on studying the last time"));
        /*
        endtime = SystemClock.elapsedRealtime() -chronometer.getBase(); // save the last endtime of chronometer
        hours =(endtime/1000)/3600>9?(endtime/1000)/3600+":":"0"+(endtime/1000)/3600+":";                     //hour
        minutes =  ((endtime/1000)%3600)/60>9?((endtime/1000)%3600)/60+ ":":"0"+((endtime/1000)%3600)/60+":"; //minute
        seconds =  ((endtime/1000)%3600)%60>9?((endtime/1000)%3600)%60+ ":":"0"+((endtime/1000)%3600)%60+":"; //seconds
        // another way, tramslate elements of time one by one, but there are too many peremeters need to save,so just show it.

        String temporary = "You spent "+hours +minutes +seconds+" on studying last time";
        textView.setText(temporary);

        */

        Last_Time =  String.format("%02d:%02d:%02d",  TimeUnit.MILLISECONDS.toHours(Timer_after_pause),
                TimeUnit.MILLISECONDS.toMinutes(Timer_after_pause) -  TimeUnit.MILLISECONDS.toMinutes( TimeUnit.MILLISECONDS.toHours(Timer_after_pause)),
                TimeUnit.MILLISECONDS.toSeconds(Timer_after_pause) -  TimeUnit.MINUTES.toSeconds( TimeUnit.MILLISECONDS.toMinutes(Timer_after_pause)));
        // The really time to save

        chronometer.setBase(SystemClock.elapsedRealtime()); //Timer becomes Zero
        Timer_after_pause = 0;
        running = false;
    }


    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences sh = getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);

        String time = sh.getString("time", ""); //get the last time imformation

        textView.setText("You spent " + time + " on studying last time");
    }
    @Override
    protected void onPause(){

        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("time", textView.getText().toString().substring(9, 18));
        editor.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle LastState) {

        super.onSaveInstanceState(LastState);
        //pass time and boolean value
        LastState.putLong("TIMER_AFTER_PAUSE", Timer_after_pause); //time from start to pause
        LastState.putBoolean("TIME-RUNNING", running);             //state of timer


        LastState.putString("time", Last_Time);                    // the textt of textview
    }

    // the last code is Oncreate method after orientation change
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        running =savedInstanceState.getBoolean(RUNNING);
        Timer_after_pause = savedInstanceState.getLong(TIMER_AFTER_PAUSE);
        Last_Time =savedInstanceState.getString(Last_Time);

       if (running ==true){

           chronometer.setBase(SystemClock.elapsedRealtime() );

           chronometer.start();

       }

    }





}
