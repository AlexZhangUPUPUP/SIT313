package com.example.save_money_game;

public class Car {

    int leftMargin;


    int core =0;


    public Car( int left){

        leftMargin =left;

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









}
