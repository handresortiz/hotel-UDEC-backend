package co.edu.ucundinamarca.negocio.parametricaservice.controller;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.Perfil;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.UsuariosForm;
import co.edu.ucundinamarca.negocio.parametricaservice.services.UsuariosService;
import co.edu.ucundinamarca.negocio.parametricaservice.services.PersonasService;
import co.edu.ucundinamarca.negocio.parametricaservice.services.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;
    private final PersonasService personasService;
    private final PerfilesService perfilesService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService, PersonasService personasService, PerfilesService perfilesService) {
        this.usuariosService = usuariosService;
        this.personasService = personasService;
        this.perfilesService = perfilesService;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuariosList = usuariosService.findAllUsuarios();
        return new ResponseEntity<>( usuariosList, HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public Usuarios getUsuarios( @PathVariable("id") Integer id ){
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Usuarios> addUsuario(@Valid @RequestBody UsuariosForm usuario){
        Personas persona = usuario.getPersona();
        persona = personasService.addPersona(persona);
        Usuarios newUsuario = usuariosService.addUsuario(
                usuario.getId_perfil(),
                persona.getPri_nombre(),
                persona.getPri_apellido(),
                persona.getIdentificacion(),
                persona);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable("id") Integer id,@Valid @RequestBody UsuariosForm usuario){
        Usuarios newUsuario = usuariosService.updateUsario(id, usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public Usuarios deleteUsuario( @PathVariable("id") Integer id ){
        return usuariosService.deleteUsuarioById(id);
    }
}

