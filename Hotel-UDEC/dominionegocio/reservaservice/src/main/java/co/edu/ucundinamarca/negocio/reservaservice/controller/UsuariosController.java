package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.reservaservice.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/{id}")
    public Usuarios getUsuarios( @PathVariable("id") Integer id ){
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Usuarios> addHuesped(@RequestBody Usuarios usuario){
        Usuarios newUsuario = usuariosService.addUsuario(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuarios> updateHuesped(@PathVariable("id") Integer id, @RequestBody Usuarios usuario){
        Usuarios newUsuario = usuariosService.updateUsario(id, usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public Usuarios deleteHuesped( @PathVariable("id") Integer id ){
        return usuariosService.deleteUsuarioById(id);
    }
}
