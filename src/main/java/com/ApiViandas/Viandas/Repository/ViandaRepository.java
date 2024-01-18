
package com.ApiViandas.Viandas.Repository;

import com.ApiViandas.Viandas.Modelo.Vianda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViandaRepository extends JpaRepository<Vianda, Long> {
    
}
