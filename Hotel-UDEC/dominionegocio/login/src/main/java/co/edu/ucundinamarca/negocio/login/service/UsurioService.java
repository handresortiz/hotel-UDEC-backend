package co.edu.ucundinamarca.negocio.login.service;

import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
