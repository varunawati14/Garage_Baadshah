package com.example.garagebaadshah.LoginPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.garagebaadshah.Data.DatabaseHandler;
import com.example.garagebaadshah.R;

public class MainActivity extends AppCompatActivity {

    private EditText emailID;
    private EditText pwd;
    private Button buto;
    private TextView txt1;
    private DatabaseHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db=new DatabaseHandler(this);

        emailID=(EditText)findViewById(R.id.emailid);
        pwd=(EditText)findViewById(R.id.pwd);
        buto=(Button) findViewById(R.id.buttonlogin);
        txt1=(TextView) findViewById(R.id.tvt1);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(MainActivity.this,Register.class);
                startActivity(it1);
            }
        });

        buto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = emailID.getText().toString();
                String wordpass = pwd.getText().toString();
                Boolean res = db.checkUser( user , wordpass );
                if (res == true){
                    Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent it10=new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(it10);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();

                }
            }
        });






    }
}
