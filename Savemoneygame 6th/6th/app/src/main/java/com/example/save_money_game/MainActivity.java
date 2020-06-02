package com.example.save_money_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button   button;
    Button   addButton;

    ImageButton left;
    ImageButton right;

    ImageView imageView;
    ImageView carview;

    ImageView addView;
    ImageView addView3;

    ImageView addView2;
    ImageView addView4;


    Money m1;

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
        carview =findViewById(R.id.carview);
        left =findViewById(R.id.leftButton);
        right =findViewById(R.id.rightButton);


        addView = findViewById(R.id.addView);
        addView3 =findViewById(R.id.addview3);
        addView2 =findViewById(R.id.addview2);
        addView4 =findViewById(R.id.addview4);

        final int marginofaddview1 =10;
        final int marginofaddview2 =20;
        final int marginofaddview3 =30;
        final int marginofaddview4 =40;

         int dddRandom ;  // store the odd randomn number
         final int evenRandom;  // store the even random number

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

                                    if (  IsOddNumber( top) ==true ){

                                       // evenRandom = random;
                                    }


                                    // change the location of the imagine view
                                    ViewGroup.MarginLayoutParams margin =new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());
                                    margin.setMargins(leftMargin, 60, 0, 0);  // set the location of view

                                    RelativeLayout.LayoutParams  layoutParams9 =new RelativeLayout.LayoutParams(margin);
                                    layoutParams9 .height =400;   //the width of the view
                                    layoutParams9. width  =400;   // the height of the view
                                    imageView.setLayoutParams(layoutParams9);  // set the layout of imagine view






                                    if(top >=1){


                                        if ( top ==1){

                                            int i = leftMargin +marginofaddview1; //set  the left margin of money
                                            m1 = new Money(i);


                                            ViewGroup.MarginLayoutParams margin2 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                            margin.setMargins( i, 400+top*50, 0, 0);  // set the location of view

                                            RelativeLayout.LayoutParams  layoutParams92 =new RelativeLayout.LayoutParams(margin);

                                            layoutParams92 .height =100;   //the width of the view
                                            layoutParams92. width  =100;   // the height of the view

                                            addView.setLayoutParams(layoutParams92);  // set the layout of imagine view
                                            addView.setAlpha(1f);



                                        }
                                        if (top >1){



                                            int s =m1.ReturnLeftMargin() ; // get the leftmargin of money

                                            int hight =400+top*80;
                                            ViewGroup.MarginLayoutParams margin2 =new ViewGroup.MarginLayoutParams(addView.getLayoutParams());
                                            margin.setMargins( s, hight, 0, 0);  // set the location of view

                                            RelativeLayout.LayoutParams  layoutParams92 =new RelativeLayout.LayoutParams(margin);

                                            layoutParams92 .height =100;   //the width of the view
                                            layoutParams92. width  =100;   // the height of the view

                                            addView.setLayoutParams(layoutParams92);  // set the layout of imagine view
                                            addView.setAlpha(1f);

                                            textView.setText("the left maigin of the Money1 is "+ s +" px  time:" + top +"---the right is "+ hight);

                                            //imageView.setImageResource(R.drawable.dollor2);
                                            if (top ==15){

                                                addView.setImageResource(R.drawable.broken);
                                                imageView.setImageResource(R.drawable.broken);
                                            }




                                        }// change the location of the first money






                                    }


                                    // chenge the location of third money

                                    /*
                                    if (top >= 5){

                                        // change the location of secnd money
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView3.getLayoutParams());
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
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView2.getLayoutParams());
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
                                        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(addView4.getLayoutParams());
                                        margin.setMargins(addView4.getLeft(), 400+(top -3)* 90, 0, 0);  // set the location of view

                                        RelativeLayout.LayoutParams  layoutParams93 =new RelativeLayout.LayoutParams(margin);

                                        layoutParams93 .height =70;   //the width of the view
                                        layoutParams93. width  =70;   // the height of the view

                                        addView4.setLayoutParams(layoutParams93);  // set the layout of imagine view
                                        addView4.setAlpha(1f);
                                    }
                                    */




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




    public void addviewButton(View view){


        //int topMargin = addView.getTop();

        //textView.setText("the top maigin of the addview is "+ topMargin +" px");



    }// the function of addbutton


    public int GetRandom(int min, int max){

        int random = new Random().nextInt((max - min) ) + min; //random
        return  random;
    } //get the randow between min and max


    public boolean IsOddNumber( int number){
       if ( number %2 ==1){

           return true;
       }
       else{
           return  false;
       }

    }// whether the number is odd number. odd--true  even---false


}


   /*
        addView = new ImageView(MainActivity.this);

        addView.setImageResource(R.drawable.dollor);   // add image 之前找的方法

        RelativeLayout.LayoutParams params =new RelativeLayout.LayoutParams(400,400);
        addView.setLayoutParams(params);               // add params

        addView.setAlpha(1f);

    */
