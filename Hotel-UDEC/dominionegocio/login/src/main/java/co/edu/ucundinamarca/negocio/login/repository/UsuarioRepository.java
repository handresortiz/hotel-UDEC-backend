package co.edu.ucundinamarca.negocio.login.repository;

import co.edu.ucundinamarca.negocio.login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);

    Optional<Usuario> findByClave(String clave);
    boolean existsByClave(String  clave);
}
