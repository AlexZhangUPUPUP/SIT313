package com.example.save_money_game;

public class Money {

    int leftMargin;
    int TopMargin;
    int core;
    int speed;

    boolean  valid = false;         // true--- the money is drop to shopping car //  false------ the money is not

    int nextSecond  =100 ;   // the one second before the money is broken


    public Money( int Core){

        core =  Core;
    }

    public Money( int Core, int Speed){

        core =Core;
        speed =Speed;

    }

    public Money( int left, int Top, int Core){

        leftMargin =left;
        TopMargin  = Top;
        core       = Core;
    }


    public Money( int left, int Top, int Core, int Speed){

        leftMargin =left;
        TopMargin  = Top;
        core       = Core;
        speed  =Speed;
    }



    public int getLeftMargin(){


        return leftMargin;

    }

    public int getCore(){


        return core;

    }

    public void setCore( int a){

        core =a;
    }

    public int getTopMargin(){


        return TopMargin;

    }

    public void setTopMargin(int t) {

        TopMargin =t;
    }


    public int getNextSecond(){

        return nextSecond;
    }

    public  void  setSecond( int a){


        nextSecond =a;
    }

    public  int getSpeed(){

        return  speed;

    }



    public void setValia( boolean a ){

        valid =a;
    }

    public boolean getvalia(  ){

        return  valid;
    }



}


