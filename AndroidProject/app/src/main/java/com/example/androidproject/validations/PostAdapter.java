package com.example.androidproject.Validations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Classes.Patient;
import com.example.androidproject.R;

import java.util.List;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView cin;
        TextView nom;
        TextView prenom;
        Button confirm;

        public ViewHolder(View itemView)
        {
            super(itemView);

            cin = (TextView) itemView.findViewById(R.id.cin);
            nom = (TextView) itemView.findViewById(R.id.patient_name);
            prenom = (TextView) itemView.findViewById(R.id.patient_prenom);
            confirm = (Button) itemView.findViewById(R.id.btn_confirm);

        }
    }

    private Context context;
    private List<Patient> patients;

    public  PostAdapter(Context c, List<Patient> patientList)
    {
        this.context=c;
        patients = patientList;

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( PostAdapter.ViewHolder holder, int position) {
        Patient p = patients.get(position);
        holder.cin.setText(p.getCin());
        holder.nom.setText(p.getNom());
        holder.prenom.setText(p.getPrenom());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }





}

