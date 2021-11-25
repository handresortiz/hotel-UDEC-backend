package co.edu.ucundinamarca.negocio.login.repository;


import co.edu.ucundinamarca.negocio.login.model.EnumRol;
import co.edu.ucundinamarca.negocio.login.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolRespository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNomRol(String rol);


}
