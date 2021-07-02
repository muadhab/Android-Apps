package com.example.androidproject.Classes;

public class Status {
    private int id;
    private String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }


    public Status() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
