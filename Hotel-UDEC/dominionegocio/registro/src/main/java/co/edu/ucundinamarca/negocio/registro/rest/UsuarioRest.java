/*
PerfilRest
se genera la parte de rest, donde se agrega el mapeo de la rutas
y los metodos ya creados en la clase UsuarioService

28/10/2021
@jhoandrojas
 */
package co.edu.ucundinamarca.negocio.registro.rest;
import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import co.edu.ucundinamarca.negocio.registro.model.Persona;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;
import co.edu.ucundinamarca.negocio.registro.service.PerfilService;
import co.edu.ucundinamarca.negocio.registro.service.PersonaService;
import co.edu.ucundinamarca.negocio.registro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PersonaService personaService;

    @PostMapping ("/agregar")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        if(usuarioService.existsByLogin(usuario.getLogin())) {
            return new ResponseEntity(new Mensaje("el usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
            usuario.setIdperfil( perfilService.endId() );
            usuario.setIdpersona( personaService.endId() );
            usuarioService.guardar(usuario);
            return new ResponseEntity(new Mensaje("usuario creado"), HttpStatus.OK);

    }


}
