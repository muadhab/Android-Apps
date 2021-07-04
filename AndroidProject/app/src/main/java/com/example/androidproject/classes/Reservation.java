package com.example.androidproject.Classes;

public class Reservation {
    private int id;
    private String date;
    private int id_patient;
    private int id_medecin;
    private int id_infermier;
    private int id_centre;


    public Reservation() {
    }

    public Reservation(int id, String date, int id_patient, int id_medecin, int id_infermier,int id_centre) {
        this.id = id;
        this.date = date;
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.id_infermier = id_infermier;
        this.id_centre=id_centre;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public int getId_infermier() {
        return id_infermier;
    }

    public void setId_infermier(int id_infermier) {
        this.id_infermier = id_infermier;
    }
}
