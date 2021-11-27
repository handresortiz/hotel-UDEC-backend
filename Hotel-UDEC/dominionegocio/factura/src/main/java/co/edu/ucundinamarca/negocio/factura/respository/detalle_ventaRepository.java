/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.respository;

import co.edu.ucundinamarca.negocio.factura.entities.detalle_venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Ducuara
 */
public interface detalle_ventaRepository extends JpaRepository<detalle_venta, Integer> {
 //   public Object findByCuenta(Integer id_cuenta); 
}
