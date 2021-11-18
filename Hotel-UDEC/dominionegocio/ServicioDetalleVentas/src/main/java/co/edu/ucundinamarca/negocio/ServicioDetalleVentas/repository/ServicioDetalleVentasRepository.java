/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioDetalleVentas.repository;

import co.edu.ucundinamarca.negocio.ServicioDetalleVentas.entities.DetalleVentas;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ServicioDetalleVentasRepository extends CrudRepository<DetalleVentas, Long> {
    
}
