package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView mytextview;
    TextView mytextview2;
    TextView mytextview3;
    TextView mytextview4;
    TextView mytextview5;
    TextView mytextview6;
    EditText myedittext;
    ImageButton mybutton;
    ImageButton mybutton2;
    ImageButton mybutton3;

    Spinner myspinner;
    List<CharSequence> eduList = null;  //list of Units
    ArrayAdapter<CharSequence> eduAdapter = null; // adapter of spinner



    DecimalFormat form = new DecimalFormat("0.00"); // a kind of format Keep two decimal places

    public  double TwoDecimalD(double i) {

        BigDecimal bg = new BigDecimal(i);
        double s = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return s;
    }// function of Keep two decimal places returnDouble


    public  String TwoDecimalS(double i) {

        BigDecimal bg = new BigDecimal(i);
        double ss = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String s = Double.toString(ss);
        return s;
    }// function of Keep two decimal places returnString


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mybutton=findViewById(R.id.mybutton); //找到界面中的button了
        mybutton2=findViewById(R.id.mybutton2);
        mybutton3=findViewById(R.id.mybutton3);

        myedittext= findViewById(R.id.myedittext);
        mytextview =findViewById(R.id.mytextview);
        mytextview2 =findViewById(R.id.mytextView2);
        mytextview3 =findViewById(R.id.mytextView3);
        mytextview4 =findViewById(R.id.mytextView4);
        mytextview5 =findViewById(R.id.mytextView5);
        mytextview6 =findViewById(R.id.mytextView6);

        myspinner =(Spinner) findViewById(R.id.myspinner);
        myspinner.setPrompt("");


        eduList = new ArrayList<CharSequence>();
        eduList.add("Metre");
        eduList.add("Celsius");
        eduList.add("Kilograms");

        eduAdapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,eduList);
        eduAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(eduAdapter);


        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.layout.activity_main,list1);


        class Mybuttonlistener1 implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String getnumberstring =new String(); //原来的输入
                String CMstring =new String();  //厘米的string
                String INstring =new String();
                String FTstring = new String();

                getnumberstring =myedittext.getText().toString();
                int originalnumber = Integer.parseInt(getnumberstring);//原始的整数
                double ss = (double)originalnumber; //小数


                int CentiMetre =originalnumber*100; //厘米cm
                double inch = CentiMetre/2.54; //英寸in
                double foot =inch/12;//英尺ft

                CMstring = Integer.toString(CentiMetre);
                INstring = TwoDecimalS(inch);
                FTstring = TwoDecimalS(foot);


                mytextview.setText(CMstring);
                mytextview2.setText( FTstring);
                mytextview3.setText(INstring);

                mytextview4.setText("Centimetre");
                mytextview5.setText("Foot");
                mytextview6.setText("Inch");

            }

        }//按住button1发生的事情 the function of button1


        class Mybuttonlistener2 implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String getnumberstring =new String(); //原来的输入
                String CMstring =new String();  //厘米的string
                String INstring =new String();
                String FTstring = new String();

                getnumberstring =myedittext.getText().toString();
                int originalnumber = Integer.parseInt(getnumberstring);//原始的整数  original number
                double ss = (double)originalnumber; //转化为小数 translate to decimal


                int gram =originalnumber*1000; //克  g
                double pound = gram/28.35;     //盎司 ounce
                double ounce =pound/16;        //磅 Pound

                CMstring = Integer.toString(gram);
                INstring = TwoDecimalS(ounce);
                FTstring = TwoDecimalS(pound);

                mytextview.setText(CMstring);
                mytextview2.setText( FTstring);
                mytextview3.setText(INstring);
                mytextview4.setText("Gram");
                mytextview5.setText("Ounce(OZ)");
                mytextview6.setText("Pound(IB)");

            }

        }//按住button2发生的事情 the function of button2




        class Mybuttonlistener3 implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                String getnumberstring =new String(); //原来的输入
                String CMstring =new String();  //厘米的string
                String INstring =new String();
                String FTstring = new String();

                getnumberstring =myedittext.getText().toString();
                int originalnumber = Integer.parseInt(getnumberstring);//原始的整数
                double ss = (double)originalnumber; //original decimal小数



                double Kelvim = ss+273.15; //开尔文 Kelvim
                double Fahrenheit =ss*1.8+32;//华氏度 Fahrenheit

                INstring= TwoDecimalS(Fahrenheit);
                FTstring= TwoDecimalS(Kelvim);



                mytextview.setText( INstring);
                mytextview2.setText( FTstring);
                mytextview4.setText("Fahrengeit");
                mytextview5.setText("Kelvim");

                mytextview3.setText("");
                mytextview6.setText("");



            }

        }//按住button3发生的事情 the function of button3



        mybutton.setOnClickListener(new Mybuttonlistener1());
        mybutton2.setOnClickListener(new Mybuttonlistener2());
        mybutton3.setOnClickListener(new Mybuttonlistener3());






    }
}
