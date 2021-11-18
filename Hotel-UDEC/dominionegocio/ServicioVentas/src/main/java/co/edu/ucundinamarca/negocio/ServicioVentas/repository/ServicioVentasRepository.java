/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioVentas.repository;

import co.edu.ucundinamarca.negocio.ServicioVentas.entities.Ventas;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ServicioVentasRepository extends CrudRepository<Ventas, Long> {
    
}
