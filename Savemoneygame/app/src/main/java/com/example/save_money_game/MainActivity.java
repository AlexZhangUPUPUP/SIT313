package com.example.save_money_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button   button;
    int count;
    Thread t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView =findViewById(R.id.textview);
        button   =findViewById(R.id.button);

         t =new Thread(){
            @Override
            public void run() {


                for (int i=0; i<100; i++){

                    try {
                        Thread.sleep(10);  // 1000 ms = 1 second  每1秒冲运行一次

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                textView.setText(String.valueOf(count));
                            }

                        });

                    }catch (InterruptedException e){

                        e.printStackTrace();
                    }

                }


            }
        };



    }
    public void StartTimer(View view){

        t.start(); //运行线程 run the thread
    }


}
