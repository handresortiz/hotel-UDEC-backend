package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerfilRepository extends JpaRepository<Perfil, Long > {

    @Query("SELECT p FROM Perfil p WHERE UPPER(p.nom_perfil) = UPPER(?1)")
    Perfil findByNombre( String nombre );
}
