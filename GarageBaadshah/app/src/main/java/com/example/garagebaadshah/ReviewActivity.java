package com.example.garagebaadshah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.garagebaadshah.LoginPages.MainActivity;

public class ReviewActivity extends AppCompatActivity {

    private RatingBar rtb;
    private Button btp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        rtb=(RatingBar)findViewById(R.id.ratingBar);
        btp=(Button)findViewById(R.id.btp);

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itr=new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(itr);
            }
        });

    }
}