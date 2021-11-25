package co.edu.ucundinamarca.negocio.login.security.services;

import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByLogin(email)
                .orElseThrow( () -> new UsernameNotFoundException((" El nombre de usuario: ".concat(email).concat(" no existe"))));

        return UserDetailsImpl.build(user);
    }
}
