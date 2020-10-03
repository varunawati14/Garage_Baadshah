package com.example.garagebaadshah.LoginPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.garagebaadshah.Maps.MapsActivity;
import com.example.garagebaadshah.R;

public class HomeActivity extends AppCompatActivity {

    private Button btt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btt=(Button) findViewById(R.id.cotbutton);

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it4=new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(it4);
            }
        });
    }
}