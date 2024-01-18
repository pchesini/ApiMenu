/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiViandas.Viandas.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Vianda {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    String nombre;
    String dia;
    
    @OneToMany(mappedBy = "vianda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore // Evita la serialización de la relación ingrediente al serializar vianda
    private List<Ingrediente> listaIngredientes;

    public Vianda() {
    }

    public Vianda(String nombre, String dia, List<Ingrediente> listaIngredientes) {
        this.nombre = nombre;
        this.dia = dia;
        this.listaIngredientes = listaIngredientes;
    }
    
    
   

}

