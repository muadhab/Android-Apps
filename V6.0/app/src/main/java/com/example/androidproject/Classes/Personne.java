package com.example.androidproject.Classes;


public class Personne {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String password;
    private String role;
    private  String status;

    public Personne() {
    }

    public Personne(int id, String name, String email, String phone, String birthday, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.password = password;
        this.role = role;
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

    public void setDateBirthday(String  birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }


}