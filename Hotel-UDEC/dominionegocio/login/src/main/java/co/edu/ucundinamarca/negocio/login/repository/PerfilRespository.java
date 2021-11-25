package co.edu.ucundinamarca.negocio.login.repository;

import co.edu.ucundinamarca.negocio.login.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRespository extends JpaRepository<Perfil, Long> {
}
