package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Perfil;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.reservaservice.repository.PerfilRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.UsuariosRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final PerfilRepository perfilRepository;


    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository, PerfilRepository perfilRepository) {
        this.usuariosRepository = usuariosRepository;
        this.perfilRepository = perfilRepository;
    }

    public Usuarios getUsuarioById(Integer id ) {
        return usuariosRepository.findById( id ).get();
    }
    public Usuarios addUsuario(Usuarios usuario){
        return usuariosRepository.save(usuario);
    }
    public Usuarios addUsuarioFromHuespedes(Integer id_persona, String nombre, String apellido, Long clave){
        Perfil perfilCliente = perfilRepository.findByNombre( "cliente" );
        String login = nombre+"."+apellido + id_persona.toString();
        Usuarios usuario = new Usuarios();
        usuario.setId_persona(id_persona);
        usuario.setId_perfil(perfilCliente.getId_perfil());
        usuario.setLogin(login.toLowerCase());
        usuario.setClave(clave.toString());

        return usuariosRepository.save(usuario);
    }
    public Usuarios updateUsario(Integer id, Usuarios usuario){
        return usuariosRepository.save(usuario);
    }
    public Usuarios deleteUsuarioById( Integer id ){
        usuariosRepository.deleteById(id);
        return null;
    }
}

