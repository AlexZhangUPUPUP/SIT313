package com.example.save_money_game;

public class Money {

    int leftMargin;
    int TopMargin;

    int core;

    public Money( int i){

        leftMargin =i;
    }

    public Money( int left, int Top){

        leftMargin =left;
        TopMargin  = Top;
    }

    public Money( int left, int Top, int Core){

        leftMargin =left;
        TopMargin  = Top;
        core       = Core;
    }

    public int ReturnLeftMargin(){


        return leftMargin;

    }

    public int ReturnCore(){


        return core;

    }

    public int ReturnTop(){


        return TopMargin;

    }
}


