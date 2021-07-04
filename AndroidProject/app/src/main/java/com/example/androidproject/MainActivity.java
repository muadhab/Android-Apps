package com.example.androidproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Btn_staff, Btn_Cntct, Btn_Patient;


        Btn_staff = (Button) findViewById(R.id.Btn_staff);
        Btn_Cntct = (Button) findViewById(R.id.Btn_contact);
        Btn_Patient = (Button) findViewById(R.id.Btn_patient);

        Btn_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Staff.class);
                startActivity(intent);

            }
        });

        Btn_Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent2);

            }
        });  Btn_Cntct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:80102021"));
                startActivity(intent3);

            }
        });

    }
}