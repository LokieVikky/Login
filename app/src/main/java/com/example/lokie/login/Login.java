package com.example.lokie.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
EditText un,pw;
TextView nwusr;
Button login;
database db;
String usr,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        un=findViewById(R.id.editText);
        pw=findViewById(R.id.editText3);
        nwusr=findViewById(R.id.textView);
        login=findViewById(R.id.button);
        db = new database(this);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        usr="";
        pwd="";
        usr=un.getText().toString();
        if(TextUtils.isEmpty(usr))
            un.setError("Enter Username");
        pwd=pw.getText().toString();
        if(TextUtils.isEmpty(pwd))
            pw.setError("Enter Password");

        String ar[]= db.getuser(usr,pwd);
        String s0="",s1="",s2="",s3="",s4="";
        s0=ar[0];
        AlertDialog.Builder alert= new AlertDialog.Builder(Login.this);
        alert.setTitle("Alert");
        alert.setMessage("User details does not exists");
        alert.setPositiveButton("OK",null);
        alert.setNeutralButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent register = new Intent(Login.this,Register.class);
                startActivity(register);
            }
        });

        switch (s0){
            case "empty":
                alert.show();
                break;
            case "hasData":
                s1=ar[1];
                s2=ar[2];
                s3=ar[3];
                s4=ar[4];
                Intent show = new Intent(Login.this,Userdetails.class);
                show.putExtra("name",s1);
                show.putExtra("location",s2);
                show.putExtra("age",s3);
                show.putExtra("gender",s4);
                startActivity(show);
                break;
        }
    }
});


    }

    public void navi(View view) {
        Intent register = new Intent(Login.this,Register.class);
        startActivity(register);
    }
}
