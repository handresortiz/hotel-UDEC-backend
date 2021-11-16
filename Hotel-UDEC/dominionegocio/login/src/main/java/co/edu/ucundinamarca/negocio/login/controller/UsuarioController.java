package co.edu.ucundinamarca.negocio.login.controller;

import co.edu.ucundinamarca.negocio.login.model.Mensaje;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.service.UsurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsurioService usuarioService;

    @PostMapping("/validar")
    public ResponseEntity<Usuario> validar(@RequestBody Usuario usuario) {
        if (usuarioService.existsByLogin(usuario.getLogin()) && usuarioService.existsByClave(usuario.getClave())) {
            return new ResponseEntity(new Mensaje("ingreso correcto"), HttpStatus.OK);



        }
            return new ResponseEntity(new Mensaje("clave o usuario incorrecto"), HttpStatus.UNAUTHORIZED);



    }


    }
