package com.example.androidproject.Classes;

public class Infermier {
    private int id;
    private int cin;
    private String nom;
    private String prenom;
    private String email;
    private String date_naissance;
    private String password;
    private String telephone;
    private String matricule;
    private int id_centre;


    public Infermier() {
    }

    public Infermier(int id, int cin, String nom, String prenom, String email, String date_naissance, String password, String telephone, String matricule, int id_centre) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naissance = date_naissance;
        this.password = password;
        this.telephone = telephone;
        this.matricule = matricule;
        this.id_centre = id_centre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    @Override
    public String toString() {
        return "Infermier{" +
                "id=" + id +
                ", cin=" + cin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", date_naissance='" + date_naissance + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", matricule='" + matricule + '\'' +
                ", id_centre=" + id_centre +
                '}';
    }
}
