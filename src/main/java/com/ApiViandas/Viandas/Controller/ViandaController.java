
package com.ApiViandas.Viandas.Controller;

import com.ApiViandas.Viandas.Modelo.Vianda;
import com.ApiViandas.Viandas.Service.ViandaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vianda")
public class ViandaController {
    
    @Autowired
    private ViandaService viandaS;
    
    @GetMapping("/lista-completa")
    public List<Vianda> getMenu(){
        return viandaS.viandasAll();
    }
    
    @GetMapping("/lista-celiacos")
    public List<Vianda> getMenuCeliacos(){
        return viandaS.verListaCeliacos();
    }
    @GetMapping("/lista-comun")
    public List<Vianda> getMenuComun(){
        return viandaS.verListaMenuComun();
    }
    
    @PostMapping("/alta")
    public String altaVianda(@RequestBody Vianda v ){
        viandaS.altaVianda(v);
        return "Vianda Cargada correctamente";
    }
}
