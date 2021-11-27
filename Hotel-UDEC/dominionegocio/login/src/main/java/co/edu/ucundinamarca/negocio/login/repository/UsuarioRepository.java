package co.edu.ucundinamarca.negocio.login.repository;

import co.edu.ucundinamarca.negocio.login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);

    Optional<Usuario> findByClave(String clave);
    boolean existsByClave(String  clave);



    @Query("select u from Usuario u where u.login=?1 and u.clave=?2")
    Optional<Usuario>login(String login, String contraseña);




}
