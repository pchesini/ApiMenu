/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiViandas.Viandas.Service;

import com.ApiViandas.Viandas.Modelo.Ingrediente;
import com.ApiViandas.Viandas.Modelo.Vianda;
import com.ApiViandas.Viandas.Repository.ViandaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViandaService implements Ivianda {

    @Autowired
    private ViandaRepository viandaR;

    @Override
    public List<Vianda> viandasAll() {
        return viandaR.findAll();
        
   

}
//itera en la lista de ingredientes, si al menos hay uno con gluten retorna false
public boolean  esAptoCeliaco(Vianda vianda){
        for(Ingrediente ingrediente : vianda.getListaIngredientes()){
            if(ingrediente.isContieneGluten()){
                return false;
            }
        }
        return true;
    }

@Override
public List<Vianda> verListaCeliacos() {
    List<Vianda> viandasTotales = viandasAll();
    List<Vianda> viandasAptasCeliacos = new ArrayList<>();

    for (Vianda vianda : viandasTotales) {
        if (esAptoCeliaco(vianda)) {
            viandasAptasCeliacos.add(vianda);
        }
    }

    return viandasAptasCeliacos;
}

    @Override
    public List<Vianda> verListaMenuComun() {
         List<Vianda> viandasTotales = viandasAll();
         List<Vianda> viandasComunes = new ArrayList<>();
         for (Vianda vianda : viandasTotales){
             if (!esAptoCeliaco(vianda)){
                 viandasComunes.add(vianda);
             }
         }
         return viandasComunes;
    }

    @Override
    public void altaVianda(Vianda nuevaVianda) {
        for ( Ingrediente ingrediente : nuevaVianda.getListaIngredientes()){
            ingrediente.setVianda(nuevaVianda);
        }
        viandaR.save(nuevaVianda);

    }

}
