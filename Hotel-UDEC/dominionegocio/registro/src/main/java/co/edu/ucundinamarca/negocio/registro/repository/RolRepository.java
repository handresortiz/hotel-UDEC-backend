package co.edu.ucundinamarca.negocio.registro.repository;

import co.edu.ucundinamarca.negocio.registro.model.Persona;
import co.edu.ucundinamarca.negocio.registro.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query( value = "SELECT * FROM roles ORDER BY id_rol DESC LIMIT 1", nativeQuery = true)
    Rol findAllById_rol();


}
