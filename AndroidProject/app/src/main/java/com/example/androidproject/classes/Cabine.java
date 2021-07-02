package com.example.androidproject.Classes;

public class Cabine {
    private  int id;
    private String nom;
    private int id_centre;


    public Cabine() {
    }

    public Cabine(int id, String nom, int id_centre) {
        this.id = id;
        this.nom = nom;
        this.id_centre = id_centre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }
}
