/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiViandas.Viandas.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
public class Ingrediente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    String nombre;
   private boolean contieneGluten;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "vianda_id")
   @JsonIgnore
   private Vianda vianda;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, boolean contieneGluten) {
        this.nombre = nombre;
        this.contieneGluten = contieneGluten;

    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isContieneGluten() {
        return contieneGluten;
    }

    public void setContieneGluten(boolean contieneGluten) {
        this.contieneGluten = contieneGluten;
    }

    public Vianda getVianda() {
        return vianda;
    }

    public void setVianda(Vianda vianda) {
        this.vianda = vianda;
    }
}
