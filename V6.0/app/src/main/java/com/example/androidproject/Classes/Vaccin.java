package com.example.androidproject.Classes;

public class Vaccin {
    private  int id;
    private String ref;
    private  String nom;
    private int qte;


    public Vaccin() {
    }

    public Vaccin(int id, String ref, String nom, int qte) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }


}
