package co.edu.ucundinamarca.negocio.login.service;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsurioService implements IUsuarioService {

@Autowired
 private UsuarioRepository usuarioRepository;

    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }

    public boolean existsByClave(String clave) {
        return usuarioRepository.existsByClave(clave);
    }


    @Override
    public Usuario login(String login, String clave) {
        return usuarioRepository.login(login, clave).orElse(null);
    }
}
