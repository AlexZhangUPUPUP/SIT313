package com.example.save_money_game;

public class Car {
    int topMaigin; // the top has no change
    int leftMargin;
    int width;

    int core =0;

    public Car( int t, int left, int w){

        topMaigin =t;
        leftMargin =left;
        width =w;
    }



    public void addcore(int a){

        core = core +a;

    }
    public int getCore(){

        return  core;
    }


    public void setLeftMargin( int  number){

        leftMargin = number;

    }

    public void addLeftMargin( int  number){

        leftMargin = leftMargin+number;

    }


    public int getLeftMargin (){

        return  leftMargin;
    }


    public int getWidth(){

        return  width;
    }






}
