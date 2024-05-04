package com.edu.senaisp.Pastel.model;

public class Pastel {

    private Integer id;
    private String sabor;

    public Pastel(Integer id, String sabor) {
        this.sabor = sabor;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
