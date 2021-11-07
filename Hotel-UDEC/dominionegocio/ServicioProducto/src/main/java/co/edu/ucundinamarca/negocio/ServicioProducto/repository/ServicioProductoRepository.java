/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioProducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ucundinamarca.negocio.ServicioProducto.entities.Producto;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ServicioProductoRepository extends JpaRepository<Producto, Long> {
   
    
    
}
