/*
se utiliza una clase de tipo interfaz y se extiende como jpaRepository esto para que nos
permita trabajar todos los metodos desde el package service

se agregaron los diferentes metodos para filtar por correo, tekefono y identificacion

28/10/2021
@jhoandrojas
 */



package co.edu.ucundinamarca.negocio.registro.repository;
import co.edu.ucundinamarca.negocio.registro.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByCorreo(String correo);
    boolean existsByCorreo(String correo);

    Optional<Persona> findByIdentificacion(Long identificacion);
    boolean existsByIdentificacion(Long identificacion);

    Optional<Persona> findByTelefono(String telefono);
    boolean existsByTelefono(String telefono);


}
