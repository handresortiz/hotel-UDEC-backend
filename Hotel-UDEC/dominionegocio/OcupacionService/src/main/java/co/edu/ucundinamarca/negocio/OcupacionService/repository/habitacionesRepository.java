/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.OcupacionService.repository;

import co.edu.ucundinamarca.negocio.OcupacionService.entities.habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Ducuara
 */
public interface habitacionesRepository extends JpaRepository<habitaciones, Integer> {
    
}
