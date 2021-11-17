/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioCategoria.repository;

import co.edu.ucundinamarca.negocio.ServicioCategoria.entities.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ServicioCategoriaRepository extends CrudRepository<Categoria, Long> {
    
}
