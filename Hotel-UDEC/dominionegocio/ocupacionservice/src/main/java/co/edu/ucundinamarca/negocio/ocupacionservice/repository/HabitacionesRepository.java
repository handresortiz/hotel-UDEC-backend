/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.ocupacionservice.repository;

import co.edu.ucundinamarca.negocio.ocupacionservice.Entities.Habitaciones;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yessyca
 */
@Repository
public interface HabitacionesRepository extends JpaRepository<Habitaciones,String> {
    
}
