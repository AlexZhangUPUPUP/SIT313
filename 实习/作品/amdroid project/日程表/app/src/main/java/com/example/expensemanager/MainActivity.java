package com.example.expensemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.ActivityChooserModel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    ListView mylistview ;

    TextView mytextiew;

    int total ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total =0;

        mytextiew =findViewById(R.id.textView);
        int total =0; //the total number of money

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Shopping");
        arrayList.add("Eatting");   // add some listview items to listview

        mylistview =(ListView) findViewById(R.id.mylistview); // find listview in xml
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList); // arryAdapter
        mylistview.setAdapter(arrayAdapter);//set adapter 设置适配器


        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //arrayList.get(position) 得到的是listview 上面的 get the string  shopping
                // position 得到的是listview上的数字  just get the 0 and 1

               //getmessage(mylistview);//   request the message from activity2

                if(position == 0){
                    Intent intent1 =new Intent();
                    intent1.setClass(getApplicationContext(),List1viewactivity.class);// jump to another activity
                    startActivityForResult(intent1,1);                   //start

                }
                else if(position ==1){

                    Intent intent2 =new Intent();
                    intent2.setClass(getApplicationContext(),List3viewActivity.class);// jump to another activity
                    startActivityForResult(intent2,1);                   //start

                }
                else {

                }

            }
        }); // function of hold on the listview


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if ( requestCode==1) {        //requescode =上面的 requestcode

            if (resultCode == RESULT_OK) {

                String message ;

                message =data.getStringExtra("returnmessage"); //get the message from activity2
                int add = Integer.parseInt(message);
                total =total+add;

               //Toast.makeText(MainActivity.this,"   lalla" + message+"    yes",Toast.LENGTH_SHORT).show();
                mytextiew.setText("Total Spend:  "+total+"  $");

            }
        }
    }


}
