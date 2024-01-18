/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiViandas.Viandas.Service;

import com.ApiViandas.Viandas.Modelo.Vianda;
import com.ApiViandas.Viandas.Repository.ViandaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public interface Ivianda {
   
    public List<Vianda> viandasAll();
    public boolean esAptoCeliaco(Vianda vianda);
    public List<Vianda> verListaCeliacos();
    public List <Vianda> verListaMenuComun();
     public void altaVianda(Vianda nuevaVianda);
}
