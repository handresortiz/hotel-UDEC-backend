package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Perfil;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.UsuariosForm;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.PerfilesRepository;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final PerfilesRepository perfilesRepository;
    private final PersonasService personasService;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository, PerfilesRepository perfilesRepository, PersonasService personasService) {
        this.usuariosRepository = usuariosRepository;
        this.perfilesRepository = perfilesRepository;
        this.personasService = personasService;
    }

    public List<Usuarios> findAllUsuarios() { return usuariosRepository.findAll();}
    public Usuarios getUsuarioById(Integer id ) {
        return usuariosRepository.findById( id ).get();
    }
    public Usuarios addUsuario(Integer id_perfil,String nombre, String apellido, Long clave, Personas persona){
        String login = nombre + "." + apellido + persona.getId_persona().toString();
        Perfil perfil = perfilesRepository.findById(id_perfil).get();
        Usuarios usuario= new Usuarios();
        usuario.setPersona(persona);
        usuario.setPerfil(perfil);
        usuario.setLogin(login.toLowerCase());
        usuario.setClave(clave.toString());
        return usuariosRepository.save(usuario);
    }
    /*public Usuarios addUsuarioFromHuespedes(Integer id_persona, String nombre, String apellido, Long clave){
        Perfil perfilCliente = perfilRepository.findByNombre( "cliente" );
        String login = nombre+"."+apellido;
        Usuarios usuario = new Usuarios();
        usuario.setId_persona(id_persona);
        usuario.setId_perfil(perfilCliente.getId_perfil());
        usuario.setLogin(login.toLowerCase());
        usuario.setClave(clave.toString());

        return usuariosRepository.save(usuario);
    }*/
    @Transactional
    public Usuarios updateUsario(Integer id, UsuariosForm usuario){
        Usuarios usuarioUp = usuariosRepository.findById(id).get();
        Personas persona = usuario.getPersona();
        Personas personaUp = personasService.updatePersona(usuarioUp.getPersona().getId_persona(),persona);
        usuario.setPersona(personaUp);
        if(usuario.getId_perfil() !=null){
            Perfil perfil = perfilesRepository.findById(usuario.getId_perfil()).get();
            usuarioUp.setPerfil(perfil);
        }
        if(usuario.getLogin() != null){
            usuarioUp.setLogin(usuario.getLogin().toLowerCase());
        }
        if(personaUp.getIdentificacion().toString().equals(usuario.getClave())){
            usuarioUp.setClave(usuario.getClave());
        }else if(!personaUp.getIdentificacion().toString().equals(usuario.getClave())){
            usuarioUp.setClave(personaUp.getIdentificacion().toString());
        }
        //return usuariosRepository.save(usuarioUp);
        return usuarioUp;
    }
    public Usuarios deleteUsuarioById( Integer id ){
        usuariosRepository.deleteById(id);
        return null;
    }
}

