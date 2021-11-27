package co.edu.ucundinamarca.negocio.registro.repository;

import co.edu.ucundinamarca.negocio.registro.model.PerfilRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRolRepository extends JpaRepository<PerfilRol, Long> {
    @Query(value = "SELECT * FROM perfiles_roles ORDER BY id_perfil_rol DESC LIMIT 1", nativeQuery = true)
    PerfilRol findAllById_perfil_rol();





}
