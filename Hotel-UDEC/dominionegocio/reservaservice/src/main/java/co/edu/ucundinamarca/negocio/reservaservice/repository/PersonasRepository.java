package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Personas p " +
            "WHERE p.correo = ?1")
    Boolean existsByCorreo(String correo);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Personas p " +
            "WHERE p.identificacion = ?1")
    Boolean existsByIdentificacion(Long identificacion);
}

