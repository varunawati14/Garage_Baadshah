package com.example.garagebaadshah.LoginPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.garagebaadshah.Data.DatabaseHandler;
import com.example.garagebaadshah.R;

public class Register extends AppCompatActivity {

    private EditText emailid1;
    private EditText pwd1,pwdcnf;
    private Button bt2;
    private TextView tvt2;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHandler(this);

        emailid1=findViewById(R.id.edito);
        pwd1=findViewById(R.id.pwdo);
        pwdcnf=findViewById(R.id.pwdcnf);
        bt2=findViewById(R.id.buttono);
        tvt2=findViewById(R.id.tvo);

        tvt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(Register.this,MainActivity.class);
                startActivity(it2);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=emailid1.getText().toString().trim();
                String pwds2=pwd1.getText().toString().trim();
                String cnf_pwd=pwdcnf.getText().toString().trim();

                if (pwds2.equals(cnf_pwd)){
                    long val= db.addUser(user,pwds2);
                    if (val>0){
                        Toast.makeText(Register.this, "You have Registerd", Toast.LENGTH_SHORT).show();
                        Intent itm = new Intent(Register.this,MainActivity.class);
                        startActivity(itm);
                    }
                    else {
                        Toast.makeText(Register.this, "Registration Error", Toast.LENGTH_SHORT).show();

                    }


                }
                else {
                    Toast.makeText(Register.this, "Password is not Matching", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}