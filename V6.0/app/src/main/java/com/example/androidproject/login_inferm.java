package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidproject.Classes.Centre;
import com.example.androidproject.Classes.Infermier;
import com.example.androidproject.Classes.Medecin;
import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Classes.Status;
import com.example.androidproject.Classes.Vaccin;
import com.example.androidproject.Database.DatabaseHelper;
import com.example.androidproject.R;

import java.util.List;


public class login_inferm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_inferm);
        DatabaseHelper db = new  DatabaseHelper(this);
        Centre c = new Centre(1,"houmetna","fi houmetna");
        Vaccin vaccin = new Vaccin(1,"FFR00221","PFaizer",30);
        Status s1=new Status(1,"NEW");
        db.addVaccin(vaccin);
        db.addCentre(c);
        db.addStatus(s1);
        Medecin m = new  Medecin(1,3310,"072040","test","test","test@test.tn","222222","04/03/33","gen","test",1);
        Patient p = new  Patient(1, "sabri", "Fetoui","072040", "hello@test.com", "22222222", "22/02/33", "Hello", 2, 0, 1, 1);
        Patient p2 = new  Patient(2, "Mouadh", "Aboud","030303", "test@test.com", "22222222", "22/02/33", "Test", 2, 0, 1, 1);
        Infermier i = new  Infermier(1,222222,"test","test","test","02/02/02","test","2333333","2233",1);
        db.addINFERMIER(i);
        db.addMedecin(m);
        db.addPATIENT(p);
        db.addPATIENT(p2);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        //db.addContact(new Contact("Tommy", "9522222222"));
        //db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List< Patient> personneList = db.getAllPATIENT();

        for ( Patient cn : personneList) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getNom() + " ,Phone: " +
                    cn.getPhone();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        Button btnLogin;
        EditText edtUsername;
        EditText edtPassword;


        btnLogin = (Button) findViewById(R.id.Btn_LoginInfer);
        edtUsername = (EditText) findViewById(R.id.TxtUsernameInfer);
        edtPassword = (EditText) findViewById(R.id.TxtPasswordInfer);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = db.checkMedecin(edtUsername.getText().toString(), edtPassword.getText().toString());
                Log.d("Reading: ", "Reading all contacts..");
                List< Medecin> MedList = db.getAllmedecin();

                for ( Medecin cn : MedList) {
                    String log = "Id: " + cn.getId() + " ,Name: " + cn.getNom() + " ,Prenom: " +
                            cn.getPrenom();
                    // Writing Contacts to log
                }
                if (isExist) {
                    Context context = getApplicationContext();
                    CharSequence text = "Login succeffuly";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(login_inferm.this, IndexMedecin.class);
                    intent.putExtra("nom", edtUsername.getText().toString());
                    startActivity(intent);
                } else {

                    edtPassword.setText(null);
                    Toast.makeText(login_inferm.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}