package com.example.customlistviewdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class Sydeny_fragment extends Fragment {

    View ImageView;
    String[] name_messages = {"National", "World", "Sports", "Health"};
    Integer[] image_messages ={R.drawable.newaus, R.drawable.newworld,R.drawable.newsport,R.drawable.newheart};
    RecyclerView propertyRecyclerView;
    ArrayList<Property> propertyArrayList =new ArrayList<Property>();

    PropertyAdapter propertyAdapter;
    Button backbutton;


    public Sydeny_fragment() {

    }
    private void InitProperList() {
        for (int i = 0; i < image_messages.length; i++) {
            int image = image_messages[i];
            String name = name_messages[i];
            propertyArrayList.add(new Property( image, name));
        }
    } //add iamges and texts to List


    private void inintRecyclerView() {

        propertyRecyclerView = ImageView.findViewById(R.id.Message_recyclerview); //find the imageview


        propertyAdapter = new PropertyAdapter( propertyArrayList, getActivity());


        propertyRecyclerView.setAdapter(propertyAdapter);               // set the adapter

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        propertyRecyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageView =inflater.inflate(R.layout.fragment_a_b_c_fragment, container, false);

        InitProperList();

        inintRecyclerView();

        return ImageView;
    }
}
