package com.example.save_money_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button   button;
    Button   addButton;

    ImageView imageView;

    ImageView addView;
    ImageView addView3;

    ImageView addView2;
    ImageView addView4;


    int leftMargin ;
    int top=0;

    int count=0;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView =findViewById(R.id.textview);
        button   =findViewById(R.id.button);
        imageView =findViewById(R.id.imageView);
        addButton =findViewById(R.id.addButton);

        addView =findViewById(R.id.addView);
        addView3 =findViewById(R.id.addview3);
        addView2 =findViewById(R.id.addview2);
        addView4 =findViewById(R.id.addview4);



         t =new Thread(){
            @Override
            public void run() {

                for (int i=0; i<15; i++) {

                    count ++;


                        try {
                            Thread.sleep(500);  // 1000 ms = 1 second  每1秒冲运行一次

                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {

                                    top++;

                                    int random =GetRandom(1,10);
                                    leftMargin =250 + random*20;

                                    // change the location of the imagine view
                                    ViewGroup.MarginLayoutParams margin =new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());
                                    margin.setMargins(leftMargin, 60, 0, 0);  // set the location of view

                                    RelativeLayout.LayoutParams  layoutParams9 =new RelativeLayout.LayoutParams(margin);
                                    layoutParams9 .height =400;   //the width of the view
                                    layoutParams9. width  =400;   // the height of the view
                                    imageView.setLayoutParams(layoutParams9);  // set the layout of imagine view

                                    // change the location of first money
                                    ViewGroup.MarginLayoutParams margin2 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                    margin.setMargins(addView.getLeft(), 400+top*50, 0, 0);  // set the location of view

                                    RelativeLayout.LayoutParams  layoutParams92 =new RelativeLayout.LayoutParams(margin);

                                    layoutParams92 .height =70;   //the width of the view
                                    layoutParams92. width  =70;   // the height of the view

                                    addView.setLayoutParams(layoutParams92);  // set the layout of imagine view
                                    addView.setAlpha(1f);

                                    // chenge the location of third view
                                    if (top >= 5){

                                        // change the location of secnd money
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                        margin.setMargins(addView3.getLeft(), 400+(top -5)*100, 0, 0);  // set the location of view

                                        RelativeLayout.LayoutParams  layoutParams93 =new RelativeLayout.LayoutParams(margin);

                                        layoutParams93 .height =70;   //the width of the view
                                        layoutParams93. width  =70;   // the height of the view

                                        addView3.setLayoutParams(layoutParams93);  // set the layout of imagine view
                                        addView3.setAlpha(1f);
                                    }
                                    //chang the location of 2nd money
                                    if (top >= 2){

                                        // change the location of secnd money
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                        margin.setMargins(addView2.getLeft(), 400+(top -2)*80, 0, 0);  // set the location of view

                                        RelativeLayout.LayoutParams  layoutParams93 =new RelativeLayout.LayoutParams(margin);

                                        layoutParams93 .height =70;   //the width of the view
                                        layoutParams93. width  =70;   // the height of the view

                                        addView2.setLayoutParams(layoutParams93);  // set the layout of imagine view
                                        addView2.setAlpha(1f);
                                    }
                                    //chang the location of 2rd money
                                    if (top >= 3){

                                        // change the location of secnd money
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                        margin.setMargins(addView4.getLeft(), 400+(top -3)* 90, 0, 0);  // set the location of view

                                        RelativeLayout.LayoutParams  layoutParams93 =new RelativeLayout.LayoutParams(margin);

                                        layoutParams93 .height =70;   //the width of the view
                                        layoutParams93. width  =70;   // the height of the view

                                        addView4.setLayoutParams(layoutParams93);  // set the layout of imagine view
                                        addView4.setAlpha(1f);
                                    }



                                } // the function of the thread

                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }



                }
            }
        };

    }
    public void StartTimer(View view){

        t.start(); //运行线程 run the thread

    }

    public int GetRandom(int min, int max){

        int random = new Random().nextInt((max - min) ) + min; //random
        return  random;
    } //get the randow between min and max


    public void addviewButton(View view){


        int topMargin = addView.getTop();

        textView.setText("the top maigin of the addview is "+ topMargin +" px");


        int leftMargin = addView3.getTop();
        textView.setText("the left maigin of the addview2 is "+ leftMargin +" px");

    }// the function of addbutton


}


   /*
        addView = new ImageView(MainActivity.this);

        addView.setImageResource(R.drawable.dollor);   // add image 之前找的方法

        RelativeLayout.LayoutParams params =new RelativeLayout.LayoutParams(400,400);
        addView.setLayoutParams(params);               // add params

        addView.setAlpha(1f);

    */
