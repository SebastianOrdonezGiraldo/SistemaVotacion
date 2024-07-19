package com.example.sistemavotacion.Model;

public class Voter {
    private int id;
    private String name;
    private String identification;



    public Voter() {}

    public Voter(int id, String name, String identification) {
        this.id = id;
        this.name = name;
        this.identification = identification;
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

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}

