/*
se utiliza una clase de tipo interfaz y se extiende como jpaRepository esto para que nos
permita trabajar todos los metodos desde el package service

28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.repository;
import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

     @Query(value = "SELECT * FROM perfiles ORDER BY id_perfil DESC LIMIT 1", nativeQuery = true)

     Perfil findAllOrderById_perfil();




}
