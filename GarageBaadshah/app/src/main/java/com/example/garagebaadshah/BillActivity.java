package com.example.garagebaadshah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BillActivity extends AppCompatActivity {

    private TextView text112;
    private int j;
    private String kk;
    private AlertDialog.Builder alert;
    private Button bt2;
    private Button btq;
    private TextView billgname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        text112=(TextView)findViewById(R.id.result);
        btq=(Button)findViewById(R.id.btq);



        Bundle res=getIntent().getExtras();

        if(res!=null){
            j=res.getInt("Total");
            kk=res.getString("title2");
        }

        billgname=(TextView)findViewById(R.id.billgname);

        billgname.setText(kk);

        text112.setText(String.valueOf(j));
        bt2=(Button)findViewById(R.id.bt2);

        bt2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alert=new AlertDialog.Builder(BillActivity.this);

                        alert.setTitle(getResources().getString(R.string.alerttitle));
                        alert.setMessage(getResources().getString(R.string.alertmsg));
                        alert.setCancelable(false);
                        alert.setPositiveButton(getResources().getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //send it to next page
                                        Intent itm=new Intent(BillActivity.this,ReviewActivity.class);
                                        startActivity(itm);
                                    }
                                });

                        alert.setNegativeButton(getResources().getString(R.string.no),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();

                                    }
                                });

                        AlertDialog dialog=alert.create();
                        alert.show();

                    }
                });

        btq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BillActivity.this,"The Omline Payment Platforms will be available soon......Please choose Pay by cash option",Toast.LENGTH_SHORT).show();
            }
        });
    }
}