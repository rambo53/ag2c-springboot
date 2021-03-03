package com.mycompany.ag2c.entity;

public class Materiaux {

    private String nom;
    private Float prix;
    private Integer stock;
    private Integer id;

    public Materiaux() {

    }

    public Materiaux(int id,String nom, float prix, int stock) {
        this.id=id;
        this.nom=nom;
        this.prix=prix;
        this.stock=stock;
    }

    public Materiaux(String nom,float prix, int stock) {
        this.nom=nom;
        this.prix=prix;
        this.stock=stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
