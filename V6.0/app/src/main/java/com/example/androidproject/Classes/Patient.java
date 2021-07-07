package com.example.androidproject.Classes;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String phone;
    private String birthday;
    private String password;
    private  int status;
    private int nbr_vaccin;
    private int id_vaccin;
    private int id_centre;



    public Patient() {
    }

    public Patient(int id, String nom, String prenom, String cin, String email, String phone, String birthday, String password, int status, int nbr_vaccin, int id_vaccin, int id_centre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.password = password;
        this.status = status;
        this.nbr_vaccin = nbr_vaccin;
        this.id_vaccin = id_vaccin;
        this.id_centre = id_centre;
        this.cin=cin;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNbr_vaccin() {
        return nbr_vaccin;
    }

    public void setNbr_vaccin(int nbr_vaccin) {
        this.nbr_vaccin = nbr_vaccin;
    }

    public int getId_vaccin() {
        return id_vaccin;
    }

    public void setId_vaccin(int id_vaccin) {
        this.id_vaccin = id_vaccin;
    }

    public int getId_centre() {
        return id_centre;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", nbr_vaccin=" + nbr_vaccin +
                ", id_vaccin=" + id_vaccin +
                ", id_centre=" + id_centre +
                '}';
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

}
