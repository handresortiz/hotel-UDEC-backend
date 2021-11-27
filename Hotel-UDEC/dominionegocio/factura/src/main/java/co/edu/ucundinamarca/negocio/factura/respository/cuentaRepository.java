/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.respository;

import co.edu.ucundinamarca.negocio.factura.entities.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Ducuara
 */
public interface cuentaRepository extends JpaRepository<cuenta, Integer> {
     public cuenta findByid(Integer id);
}
