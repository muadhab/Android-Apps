package com.example.androidproject.Validations;

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
import com.example.androidproject.R;

public class UpdatePatient extends AppCompatActivity {
    Patient P;
    EditText cin,nom,prenom,date_naiss,email,phone,password;
    DatabaseHelper db = new DatabaseHelper(this);
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_patient);
        cin = (EditText)findViewById(R.id.TxtCinP);
        nom = (EditText)findViewById(R.id.TxtVnom);
        prenom = (EditText)findViewById(R.id.TxtVPrenom);
        date_naiss = (EditText)findViewById(R.id.editTextDate);
        email = (EditText)findViewById(R.id.editTxtVemail);
        phone = (EditText)findViewById(R.id.edittxtVphone);
        password = (EditText)findViewById(R.id.edittxtVpasswd);

        btn = (Button) findViewById(R.id.btn_confirmUp);

        Intent intent = getIntent();
        String dataTransmited=intent.getStringExtra("cin");
        Log.d("test",dataTransmited);
        Context context = getApplicationContext();
        Patient pa = db.getPatientByID(dataTransmited);
        cin.setHint(pa.getCin());
        nom.setHint(pa.getNom());
        prenom.setHint(pa.getPrenom());
        date_naiss.setHint(pa.getBirthday());
        email.setHint(pa.getEmail());
        phone.setHint(pa.getPhone());
        password.setHint(pa.getPassword());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P = db.getPatientByID(pa.getCin());
                P.setCin(cin.getText().toString());
                P.setNom(nom.getText().toString());
                P.setPrenom(prenom.getText().toString());
                P.setBirthday(date_naiss.getText().toString());
                P.setEmail(email.getText().toString());
                P.setPhone(phone.getText().toString());
                P.setPassword(password.getText().toString());

                Log.d("test",P.toString());
                db.updatePATIENT(P);
            }
        });
    }
}