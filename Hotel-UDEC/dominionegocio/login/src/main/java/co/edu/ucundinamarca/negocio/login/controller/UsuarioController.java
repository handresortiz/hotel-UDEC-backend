package co.edu.ucundinamarca.negocio.login.controller;

import co.edu.ucundinamarca.negocio.login.model.Mensaje;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.service.UsurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsurioService usuarioService;

    @PostMapping("/validar")
    public ResponseEntity<Usuario> validar(@RequestBody Usuario usuario) {
        if (usuarioService.existsByLogin(usuario.getLogin()) && usuarioService.existsByClave(usuario.getClave())) {
            return new ResponseEntity(new Mensaje("ingreso correcto"), HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity(new Mensaje("clave o usuario incorrecto"), HttpStatus.BAD_REQUEST);



    }


    }
