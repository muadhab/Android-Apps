package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Database.DatabaseHelper;
import com.example.androidproject.Validations.UpdatePatient;

public class index_patient extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    private Button button_reserv,btn;
    Patient P;
    EditText cin,nom,prenom,date_naiss,email,phone,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_patient);
        button_reserv = (Button) findViewById(R.id.button_reserv);
        button_reserv.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(index_patient.this, index_reservation.class);
                                               startActivity(intent);
                                           }
                                       }

        );
        btn = (Button) findViewById(R.id.button_edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(index_patient.this, UpdatePatient.class);
                startActivity(intent);
            }
        });


    }
}