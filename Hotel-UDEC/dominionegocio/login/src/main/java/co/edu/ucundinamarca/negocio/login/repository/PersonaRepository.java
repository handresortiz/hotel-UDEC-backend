package co.edu.ucundinamarca.negocio.login.repository;

import co.edu.ucundinamarca.negocio.login.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {


    Optional<Persona> findByIdentificacion(Integer identificacion);

    boolean existsByIdentificacion(Long identificacion);

    @Query(value = "SELECT * FROM personas WHERE id_persona = (SELECT id_persona FROM personas ORDER BY id_persona DESC LIMIT 1)", nativeQuery = true)
    Persona lastPerson();


}
