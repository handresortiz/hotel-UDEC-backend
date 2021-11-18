package co.edu.ucundinamarca.negocio.login.model.service;

import co.edu.ucundinamarca.negocio.login.model.Perfil;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Usuario> user =  usuarioRepository.findByLogin(login);

        if(user == null){
            logger.error("Error en el login: not found user "+ user + " in the system");
            throw new UsernameNotFoundException("username: "+user+" don't exists in the system");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        Perfil profile = null;

        profile = user.get().getIdperfil();

        logger.info("role : ".concat( profile.getNom_perfil() ));
        authorities.add( new SimpleGrantedAuthority( profile.getNom_perfil() ));

        if( authorities.isEmpty() ){
            logger.error("Error en el Login: Usuario " + user + " nop tiene roles asignados");
            throw new UsernameNotFoundException("Error en el Login: Usuario " + user + " nop tiene roles asignados");
        }

        return new User( user.get().getLogin() , user.get().getClave() , user.get().getVerificado_correo(), true, true, true, authorities);

    }
}
