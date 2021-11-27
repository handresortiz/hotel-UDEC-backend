/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.respository;

import co.edu.ucundinamarca.negocio.factura.entities.huespedes;
import co.edu.ucundinamarca.negocio.factura.entities.personas;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Ducuara
 */
public interface huespedesRepository extends JpaRepository<huespedes, Integer> {
    
     public huespedes findByid(Integer id);
     

}
