package com.example.lokie.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Userdetails extends AppCompatActivity {
    TextView name,loc,age,gender;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        name=findViewById(R.id.textView3);
        loc=findViewById(R.id.textView2);
        age=findViewById(R.id.textView5);
        gender=findViewById(R.id.textView6);

        s1=getIntent().getStringExtra("name");
        s2=getIntent().getStringExtra("location");
        s3=getIntent().getStringExtra("age");
        s4=getIntent().getStringExtra("gender");

        name.setText("Name : "+s1);
        loc.setText("Location : "+s2);
        age.setText("Age : "+s3);
        gender.setText("Gender : "+s4);
    }
}
