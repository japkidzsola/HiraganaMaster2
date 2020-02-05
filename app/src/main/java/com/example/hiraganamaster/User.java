package com.example.hiraganamaster;

public class User {
    private String felhasznalonev;
    private String jelszo;

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getJelszo() {
        return jelszo;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }
}
