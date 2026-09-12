package br.unitins.tp1.model;

import jakarta.persistence.Entity;

@Entity
public class Mouse extends DefaultEntity {
    
    private String marca;
    private String modelo;

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }  
  
}
