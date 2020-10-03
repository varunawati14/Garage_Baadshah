package com.example.garagebaadshah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView infotext;
    private TextView infodis;
    private Button cont1;
    private CheckBox punc1;
    private CheckBox er1;
    private CheckBox bcr1;
    private CheckBox hdr1;
    private CheckBox locs1;
    private String j;
    private String jj;
    private int price;
    private int tot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        cont1=(Button)findViewById(R.id.cont1);
        punc1=(CheckBox)findViewById(R.id.punc1);
        er1=(CheckBox)findViewById(R.id.er1);
        bcr1=(CheckBox)findViewById(R.id.bcr1);
        hdr1=(CheckBox)findViewById(R.id.hdr1);
        locs1=(CheckBox)findViewById(R.id.locs1);
        infotext=(TextView)findViewById(R.id.infotext);

        Bundle ext=getIntent().getExtras();

        if(ext!=null){
            j=ext.getString("Title");

        }
        infotext.setText(j);
        infodis.setText(jj);

        final Intent itt=new Intent(InfoActivity.this,BillActivity.class);
        itt.putExtra("title2",j);
        tot=0;




        cont1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tot=0;

                StringBuilder stringbuilder=new StringBuilder();
                if(punc1.isChecked()){
                    price=50;
                    tot=tot+price;

                }
                if (er1.isChecked()){
                    price=200;
                    tot=tot+price;
                }
                if(bcr1.isChecked()){
                    price=150;
                    tot=tot+price;

                }
                if (hdr1.isChecked()){
                    price=200;
                    tot=tot+price;
                }
                if (locs1.isChecked()){
                    price=50;
                    tot=tot+price;
                }

                itt.putExtra("Total",((Integer) tot));
                startActivity(itt);





            }


        });






    }
}