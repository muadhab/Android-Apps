package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Staff extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        Button Btn_admin, Btn_Mdcn, Btn_Infr;


        Btn_admin = (Button) findViewById(R.id.Btn_admin);
        Btn_Mdcn = (Button) findViewById(R.id.Btn_medecin);
        Btn_Infr = (Button) findViewById(R.id.Btn_Infermier);

        Btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Staff.this, index_admin.class);
                startActivity(intent);

            }
        });

        Btn_Mdcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Staff.this, login_medecin.class);
                startActivity(intent2);

            }
        });  Btn_Infr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Staff.this,login_inferm.class);
                startActivity(intent3);

            }
        });

    }


}