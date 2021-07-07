package com.example.androidproject.Validations;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Database.DatabaseHelper;
import com.example.androidproject.R;

import java.io.Serializable;
import java.util.List;

public class MedecinAdapter extends RecyclerView.Adapter<MedecinAdapter.ViewHolder> {
    private Context context;
    private List<Patient> patients;


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView cin;
        TextView nom;
        TextView prenom;
        Patient patient;
        ImageButton confirm,update;


        public ViewHolder(View itemView)
        {
            super(itemView);

            cin = (TextView) itemView.findViewById(R.id.cin);
            nom = (TextView) itemView.findViewById(R.id.patient_name);
            prenom = (TextView) itemView.findViewById(R.id.patient_prenom);
            confirm = (ImageButton) itemView.findViewById(R.id.btn_confirm);
            update = (ImageButton) itemView.findViewById(R.id.btn_update);
        }
    }



    public MedecinAdapter(Context c, List<Patient> patientList)
    {
        this.context=c;
        patients = patientList;

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.medecin_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MedecinAdapter.ViewHolder holder, int position) {
        Patient p = patients.get(position);
        holder.cin.setText(p.getCin());
        holder.nom.setText(p.getNom());
        holder.prenom.setText(p.getPrenom());
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentX = new Intent(v.getContext(), UpdateRDV.class);
                intentX.putExtra("cin", p.getCin());
                context.startActivity(intentX);
            }
        });
        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Reading: ", p.toString());
                DatabaseHelper db=new DatabaseHelper(context);
                p.setStatus(3);
                db.updatePATIENT(p);
                Toast.makeText(context, "Ce patient peut poursuivre son parcours vers l'infermier ", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return patients.size();
    }





}

