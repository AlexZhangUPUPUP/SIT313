package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class List3viewActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3view);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        editText  = findViewById(R.id.editText);
        button    = findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {



                String returnmessage= editText.getText().toString();//get the string of editview

                textView2 .setText(returnmessage);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("returnmessage",returnmessage);  //把returnmessage 返回 make returnIntent back
                setResult(RESULT_OK,returnIntent);   //把returnIntent 返回  make returnintent back


                //Toast.makeText(List3viewActivity.this,"send ok  ",Toast.LENGTH_SHORT).show();

                finish();

            }
        });
    }
}
