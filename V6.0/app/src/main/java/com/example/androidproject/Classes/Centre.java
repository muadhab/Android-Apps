package com.example.androidproject.Classes;


public class Centre {
    private int id;
    private String nom;
    private String emplacement;

    public Centre() {
    }

    public Centre(int id, String nom, String emplacement) {
        this.id = id;
        this.nom = nom;
        this.emplacement = emplacement;
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

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
}
