package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;


import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Database.DatabaseHelper;
import com.example.androidproject.Validations.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class IndexMedecin extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private SearchView searchView;
    private ArrayList<Patient> patients;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQueryHint("Search View");
        recyclerView = (RecyclerView) findViewById(R.id.RV_Patient);
        Log.d("Reading: ", "Reading all contacts..");
        List<Patient> patientList = db.getAllPATIENT();

        postAdapter = new PostAdapter(this,patientList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(postAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }


    }





