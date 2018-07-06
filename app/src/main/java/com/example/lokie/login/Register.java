package com.example.lokie.login;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name, loc, age;
    RadioGroup gender;
    CheckBox terms;
    Button save;
    String s1, s2, s3, s4, s5;
    int id;

    database dataa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dataa = new database(this);
        name = findViewById(R.id.editText2);
        loc = findViewById(R.id.editText4);
        age = findViewById(R.id.editText6);
        gender = findViewById(R.id.gen);
        terms = findViewById(R.id.checkBox);
        save = findViewById(R.id.button2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valildation();
                s1=name.getText().toString();
                s2=loc.getText().toString();
                s3=age.getText().toString();
                id=gender.getCheckedRadioButtonId();
                if(id==R.id.radioButton)
                    s4="Male";
                else
                    s4="Female";
                s5=terms.isChecked()+"";
                switch (s5)
                {
                    case "true":

                        long a = dataa.saveappuser(s1,s2,s3,s4);
                        Toast.makeText(Register.this, "User Registered Succesfully"+a, Toast.LENGTH_SHORT).show();
                    case "false":
                        terms.setError("Agree to proceed");
                }
            }
        });
    }

    public void valildation() {

        s1=name.getText().toString();
        s2=loc.getText().toString();
        s3=age.getText().toString();
        id=gender.getCheckedRadioButtonId();
        if(id==R.id.radioButton)
            s4="Male";
        else
            s4="Female";
        AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
        alert.setTitle("Alert");
        alert.setMessage("Select Gender");
        alert.setPositiveButton("OK", null);
        if (TextUtils.isEmpty(s1)) {
            name.setError("Enter name");
        } else if (TextUtils.isEmpty(s2)) {
            loc.setError("Enter Location");
        } else if (TextUtils.isEmpty(s3)) {
            age.setError("Enter age");
        } else if (TextUtils.isEmpty(s4)) {
            alert.show();
        }
    }
}
