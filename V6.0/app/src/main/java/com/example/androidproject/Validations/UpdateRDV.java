package com.example.androidproject.Validations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Classes.Reservation;
import com.example.androidproject.Database.DatabaseHelper;
import com.example.androidproject.R;

import java.util.List;

public class UpdateRDV extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    EditText cin,nom,prenom,date;
    Reservation r;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rdv);
        cin = (EditText)findViewById(R.id.TxtCinP);
        nom = (EditText)findViewById(R.id.TxtVnom);
        prenom = (EditText)findViewById(R.id.TxtVPrenom);
        date = (EditText)findViewById(R.id.editTextDate);
        btn = (Button) findViewById(R.id.btn_confirmUp);

        Intent intent = getIntent();
        String dataTransmited=intent.getStringExtra("cin");
        Log.d("test",dataTransmited);
        Context context = getApplicationContext();
        //TextView txt = findViewById(R.id.txtView);
        Patient p = db.getPatientByID(dataTransmited);
        cin.setHint(p.getCin());
        nom.setHint(p.getNom());
        prenom.setHint(p.getPrenom());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r = db.getReservation(p.getCin());
                r.setDate(date.getText().toString());
               Log.d("test",r.toString());
               db.updateRDVDate(r);
            }
        });



    }
}