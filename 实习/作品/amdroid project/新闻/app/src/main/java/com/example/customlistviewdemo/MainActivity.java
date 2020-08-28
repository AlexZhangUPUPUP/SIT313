package com.example.customlistviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Property;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PropertyAdapter.OnNOtelistener {
    Integer[] imageList = { R.drawable.ninenews, R.drawable.abcnews , R.drawable.agenews ,R.drawable.sydenynews};
    String[] addressList = {"9News", "ABC News","The Age","Sydney Morning Herald"};

    Fragment fragment;
    Fragment fragment_two;


    RecyclerView propertyRecyclerView;
    PropertyAdapter propertyAdapter;
    List<com.example.customlistviewdemo.Property> propertyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment =new Empty_fragment();                //Empty_fragment, once recycler_view selected, the fraagmeng is replaced.
        FragmentManager fragmentManager =getSupportFragmentManager();  //create the fragment manager

        final FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.myfragment,fragment); //add to fragment   添加到fragment

        fragmentTransaction.commit();


        propertyRecyclerView = findViewById(R.id.propertyRecyclerView);
        // Create adapter passing in the sample user data
        propertyAdapter = new PropertyAdapter(propertyList, MainActivity.this,this );
        // Attach the adapter to the recyclerview to populate items
        propertyRecyclerView.setAdapter(propertyAdapter);
        // Set layout manager to position the items
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        propertyRecyclerView.setLayoutManager(layoutManager);

        propertyRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {

            }
        });

        //Filling our recycler view list
        for (int i= 0; i< imageList.length; i++ )
        {

          int image = imageList[i];
          String address = addressList[i];

          com.example.customlistviewdemo.Property property = new com.example.customlistviewdemo.Property ( image, address);
          propertyList.add(property);

          }
        } //add recycler view

    @Override
    public void OnNoteClick(int position) {

        Toast.makeText(MainActivity.this,"hello you find the position of ----"+ position ,Toast.LENGTH_SHORT).show();
         propertyList.get(position);


        if (position ==0){

            fragment =new News9_fragment();
            //Empty_fragment, once recycler_view selected, the fraagmeng is replaced.
            FragmentManager fragmentManager =getSupportFragmentManager();  //create the fragment manager

            final FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.myfragment,fragment); //add to myfragment   添加到fragment
            fragmentTransaction.commit();
        }


        else if (position ==1){

            fragment =new ABC_fragment();
            //Empty_fragment, once recycler_view selected, the fraagmeng is replaced.
            FragmentManager fragmentManager =getSupportFragmentManager();  //create the fragment manager

            final FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.myfragment,fragment); //add to myfragment   添加到fragment
            fragmentTransaction.commit();

        }
        else if (position == 2){

            fragment =new The_Age_fragmrnt();
            //Empty_fragment, once recycler_view selected, the fraagmeng is replaced.
            FragmentManager fragmentManager =getSupportFragmentManager();  //create the fragment manager

            final FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.myfragment,fragment); //add to fragment   添加到fragment
            fragmentTransaction.commit();

        }else {

            fragment =new Sydeny_fragment();
            //Empty_fragment, once recycler_view selected, the fraagmeng is replaced.
            FragmentManager fragmentManager =getSupportFragmentManager();  //create the fragment manager

            final FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.myfragment,fragment); //add to fragment   添加到fragment
            fragmentTransaction.commit();

        }

    } //get the position of Recycler view and what happen when touch recycler_view button
      // the position of arry is same as the recycler view
}

