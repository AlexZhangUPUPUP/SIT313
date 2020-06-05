package com.example.save_money_game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
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

    MediaPlayer player;

    TextView textView;
    TextView textView2;
    Button   startbutton;
    Button   closeButton;

    ImageButton left;
    ImageButton right;

    ImageView bankView;
    ImageView carview;

    ImageView moneyView1;
    ImageView moneyView2;
    ImageView moneyView3;
    ImageView moneyView4;
    ImageView moneyView5;
    ImageView moneyView6;
    ImageView moneyView7;
    ImageView moneyView8;
    ImageView moneyView9;
    ImageView moneyView10;


    Money m1 =new Money(1 ,80);
    Money m2 =new Money( 1,80);
    Money m3 =new Money( 1,80);

    Money m4 =new Money( 2,90);
    Money m5 =new Money( 2,90);
    Money m6 =new Money( 2,90);

    Money m7 =new Money( 3,95);
    Money m8 =new Money( 3,95);
    Money m9 =new Money( 3,95);

    Money m10 =new Money( 5,99);





    Car shoppingCar  =new Car(1100);  // the original location of shoppingCar;


    int leftMargin =0 ; // the orignl leftMargin of bank, money is moving follow the bank

    int time=0;
    int core =0;     // the core of the plyer
    int limit_time = 26;


    Thread t;



    final int marginofaddview1 =10;  // the distance between money and the imageview
    final int marginofaddview2 =50;
    final int marginofaddview3 =80;
    final int marginofaddview4 =100;



    final int width_shoppingcar =240;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        textView =findViewById(R.id.textview);
        textView2 =findViewById(R.id.textview2);

        startbutton   =findViewById(R.id.button);
        bankView =findViewById(R.id.imageView);

        closeButton =findViewById(R.id.closeButton);
        carview =findViewById(R.id.carview);
        left =findViewById(R.id.leftButton);
        right =findViewById(R.id.rightButton);


        moneyView1 =findViewById(R.id.moneyView1);
        moneyView2 =findViewById(R.id.moneyView2);
        moneyView3 =findViewById(R.id.moneyView3);
        moneyView4 =findViewById(R.id.moneyView4);
        moneyView5 =findViewById(R.id.moneyView5);
        moneyView6 =findViewById(R.id.moneyView6);
        moneyView7 =findViewById(R.id.moneyView7);
        moneyView8 =findViewById(R.id.moneyView8);
        moneyView9 =findViewById(R.id.moneyView9);
        moneyView10 =findViewById(R.id.moneyView10);

        // moneyView7 =findViewById(R.id.moneyView7);
        // moneyView8 =findViewById(R.id.moneyView8);



        //shoppingCar =new Car(1100,20,300);  // the original location of shoppingCar

        textView2 .setText("core :"+ core);

         t =new Thread(){
            @Override
            public void run() {



                for (int i=0; i<28; i++) {




                        try {
                            Thread.sleep(700);  // 1000 ms = 1 second  每1秒冲运行一次 run every 500ms

                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {


                                    textView.setText("time:" +limit_time);

                                    time++;  // the time = second
                                    limit_time--;

                                    int random =GetRandom(1,10);
                                    leftMargin =20 + random*80;  // the left margin of imagine view

                                    change_bank_location(leftMargin);// change the location of bank



                                    if(time >=1){ // what happen when time is  1st second  , the money is start fall


                                        if ( time ==1){


                                            moneyView1.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview1;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =1;                              // the core of money

                                            m1 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView1, l, t+m1.getSpeed() );


                                        }
                                        if (time >= 1){


                                            int l =m1.getLeftMargin() ; // get the leftmargin of money

                                            int t =m1.getTopMargin();         // get the Topmargin of money
                                            t =t +80;
                                            m1.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView1, l, t );


                                            identify_money_drop( time,m1, moneyView1 );  // identify whether the money is drop to car


                                        }

                                    }// change the location of the first money




                                    if(time >=3){ // what happen when time is  3rd second  , the  money is start fall


                                        if ( time ==3){


                                            moneyView2.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview2;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =1;                              // the core of money

                                            m2 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView2, l, t+m2.getSpeed() );


                                        }
                                        if (time >= 3){


                                            int l =m2.getLeftMargin() ; // get the leftmargin of money

                                            int t =m2.getTopMargin();         // get the Topmargin of money
                                            t =t +80;
                                            m2.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView2, l, t );

                                            identify_money_drop( time,m2, moneyView2 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the second money



                                    if(time >=5){ // the  money is start fall


                                        if ( time ==5){


                                            moneyView3.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview3;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =1;                              // the core of money

                                            m3 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView3, l, t+ m3.getSpeed() );


                                        }
                                        if (time >= 5){


                                            int l =m3.getLeftMargin() ; // get the leftmargin of money

                                            int t =m3.getTopMargin();         // get the Topmargin of money
                                            t =t +80;
                                            m3.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView3, l, t );

                                            identify_money_drop( time,m3, moneyView3 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 3 money




                                    if(time >=7){ // the  money is start fall


                                        if ( time ==7){


                                            moneyView4.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview4;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =2;                              // the core of money

                                            m4 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView4, l, t+ m4.getSpeed() );


                                        }
                                        if (time >= 7){


                                            int l =m4.getLeftMargin() ; // get the leftmargin of money

                                            int t =m4.getTopMargin();         // get the Topmargin of money
                                            t =t +90;

                                            m4.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView4, l, t );

                                            identify_money_drop( time,m4, moneyView4 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 4 money



                                    if(time >=9){ // the  money is start fall


                                        if ( time ==9){


                                            moneyView5.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview1;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =2;                              // the core of money

                                            m5 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView5, l, t+ m5.getSpeed() );


                                        }
                                        if (time >= 9){


                                            int l =m5.getLeftMargin() ; // get the leftmargin of money

                                            int t =m5.getTopMargin();         // get the Topmargin of money
                                            t =t +90;

                                            m5.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView5, l, t );

                                            identify_money_drop( time,m5, moneyView5 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 5 money


                                    if(time >=11){ // the  money is start fall


                                        if ( time ==11){


                                            moneyView6.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview2;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =2;                              // the core of money

                                            m6 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView6, l, t+ m6.getSpeed() );


                                        }
                                        if (time >= 11){


                                            int l =m6.getLeftMargin() ; // get the leftmargin of money

                                            int t =m6.getTopMargin();         // get the Topmargin of money
                                            t =t +90;

                                            m6.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView6, l, t );

                                            identify_money_drop( time,m6, moneyView6 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 6 money



                                    if(time >=13){ // the  money is start fall


                                        if ( time ==13){


                                            moneyView7.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview3;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =3;                              // the core of money

                                            m7 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView7, l, t+ m7.getSpeed() );


                                        }
                                        if (time >= 13){


                                            int l =m7.getLeftMargin() ; // get the leftmargin of money

                                            int t =m7.getTopMargin();         // get the Topmargin of money
                                            t =t +95;

                                            m7.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView7, l, t );

                                            identify_money_drop( time,m7, moneyView7 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 7 money


                                    if(time >=15){ // the  money is start fall


                                        if ( time ==15){


                                            moneyView8.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview4;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =3;                              // the core of money

                                            m8 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView8, l, t+ m8.getSpeed() );


                                        }
                                        if (time >= 15){


                                            int l =m8.getLeftMargin() ; // get the leftmargin of money

                                            int t =m8.getTopMargin();         // get the Topmargin of money
                                            t =t +95;

                                            m8.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView8, l, t );

                                            identify_money_drop( time,m8, moneyView8 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 8 money


                                    if(time >=17){ // the  money is start fall


                                    if ( time ==17){


                                        moneyView9.setAlpha(1f);                     // set the transparency of the view

                                        int l = leftMargin +marginofaddview1;  //the left margin of money
                                        int t = 400  ;                          //the top margin of money
                                        int c =3;                              // the core of money

                                        m9 = new Money(l,t,c);                 // store the inforamation of money


                                        change_money_location( moneyView9, l, t+ m9.getSpeed() );


                                    }
                                    if (time >= 17){


                                        int l =m9.getLeftMargin() ; // get the leftmargin of money

                                        int t =m9.getTopMargin();         // get the Topmargin of money
                                        t =t +95;

                                        m9.setTopMargin(t);    // change the location of money


                                        change_money_location( moneyView9, l, t );

                                        identify_money_drop( time,m9, moneyView9 );  // identify whether the money is drop to car

                                    }

                                }// change the location of the 9 money



                                    if(time >=19){ // the  money is start fall


                                        if ( time ==19){


                                            moneyView10.setAlpha(1f);                     // set the transparency of the view

                                            int l = leftMargin +marginofaddview2;  //the left margin of money
                                            int t = 400  ;                          //the top margin of money
                                            int c =5;                              // the core of money

                                            m10 = new Money(l,t,c);                 // store the inforamation of money


                                            change_money_location( moneyView10, l, t+ m10.getSpeed() );


                                        }
                                        if (time >= 19){


                                            int l =m10.getLeftMargin() ; // get the leftmargin of money

                                            int t =m10.getTopMargin();         // get the Topmargin of money
                                            t =t +99;

                                            m10.setTopMargin(t);    // change the location of money


                                            change_money_location( moneyView10, l, t );

                                            identify_money_drop( time,m10, moneyView10 );  // identify whether the money is drop to car

                                        }

                                    }// change the location of the 9 money











                                    if ( time == 28){


                                        if (player != null){

                                            player.release();
                                            player =null;
                                        }//close the player

                                        textView.setText("Game over! Your core is  "+core);
                                        textView2.setText("");

                                        closeButton.setAlpha(1f);
                                        startbutton.setAlpha(0f);


                                    }// the last second of the game,






                                } // the function of the thread

                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                }
            }
        };

    }
    public void Start(View view){

        t.start(); //运行线程 run the thread

        if (player == null){

                player =MediaPlayer.create(this, R.raw.music);

        }

        player.start(); // play the music
        startbutton.setAlpha(0f);


    }




    public void closeButton(View view){


        finish(); // close the app

    }// the function of closeButton


    public int GetRandom(int min, int max){

        int random = new Random().nextInt((max - min) ) + min; //random
        return  random;
    } //get the randow between min and max



    public  void moveLeft(View view){



        int x =carview.getLeft();

        shoppingCar.setLeftMargin(x-100);

        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(carview.getLayoutParams());
        margin3.setMargins( x-100, 1100, 0, 0);  // set the location of view


        RelativeLayout.LayoutParams  layoutParams =new RelativeLayout.LayoutParams(margin3);
        layoutParams. width  =240;   // the height of the view
        layoutParams .height =200;   //the width of the view


        carview.setLayoutParams(layoutParams);  // set the layout of car view


    } // function of left button




    public  void moveRight(View view){


        int x =carview.getLeft();
        shoppingCar.setLeftMargin(x+100);

        ViewGroup.MarginLayoutParams margin3 =new ViewGroup.MarginLayoutParams(carview.getLayoutParams());
        margin3.setMargins( x+100, 1100, 0, 0);  // set the location of view


        RelativeLayout.LayoutParams  layoutParams =new RelativeLayout.LayoutParams(margin3);
        layoutParams. width  =240;   // the height of the view
        layoutParams .height =200;   //the width of the view


        carview.setLayoutParams(layoutParams);  // set the layout of car view

    }//function of right button




    public void  identify_money_drop( int time, Money m1, ImageView moneyView ){

        int downSide_money =m1.getTopMargin()+100;


        int leftSide_money =m1.getLeftMargin();
        int rightSide_money =m1.getLeftMargin()+100;


        // the scope of shopping car view
        int leftSide_car = shoppingCar.getLeftMargin();
        int rightSide_car =shoppingCar.getLeftMargin()+width_shoppingcar;


        if ( downSide_money<=1200 &&downSide_money >=1100    ){

            if ( rightSide_money<= rightSide_car && leftSide_money >= leftSide_car ){


                core =core +m1.getCore();
                textView2 .setText("core :"+ core);
                m1.valid =true;

                // the money is Drop to shopping car
            }else {

            }// the money not Drop to shopping car

            m1.setSecond(time);

        }// ifentify whether the money is drop to shopping car


        if (time == (m1.getNextSecond()+1) ){

            if ( m1.getvalia() == true){

                moneyView.setAlpha(0f);
            }else {

                moneyView.setImageResource(R.drawable.broken);
            }

        }// the 2 seconds later, the money will disappear or broken


        if( m1.getTopMargin() >= 1350 ){

            moneyView.setAlpha(0f);
        }// when the money is lower than shopping car, it will disappear


    } // the function to identify whether the money drops to shopping car and what happen in 2 seconds later



    public void  change_bank_location( int leftMargin){

        // change the location of the bank view
        ViewGroup.MarginLayoutParams margin =new ViewGroup.MarginLayoutParams(bankView.getLayoutParams());
        margin.setMargins(leftMargin, 0, 0, 0);  // set the location of view

        RelativeLayout.LayoutParams  layoutParams9 =new RelativeLayout.LayoutParams(margin);
        layoutParams9 .height =400;   //the width of the view
        layoutParams9. width  =400;   // the height of the view
        bankView.setLayoutParams(layoutParams9);  // set the layout of imagine view


    }


    public void change_money_location(ImageView View , int leftMargin, int topMargin ){


        ViewGroup.MarginLayoutParams margin2 =new ViewGroup.MarginLayoutParams(View.getLayoutParams());

        margin2.setMargins( leftMargin, topMargin, 0, 0);  // set the location of moneyview

        RelativeLayout.LayoutParams  layoutParams92 =new RelativeLayout.LayoutParams(margin2);
        layoutParams92 .height =100;   //the width of the view
        layoutParams92. width  =100;   // the height of the view

        View.setLayoutParams(layoutParams92);  // set the layout of imagine view

    }



}



