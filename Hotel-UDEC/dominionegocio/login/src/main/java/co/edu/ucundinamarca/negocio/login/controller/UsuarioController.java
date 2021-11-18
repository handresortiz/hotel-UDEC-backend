package co.edu.ucundinamarca.negocio.login.controller;

import co.edu.ucundinamarca.negocio.login.model.Mensaje;
import co.edu.ucundinamarca.negocio.login.model.Usuario;
import co.edu.ucundinamarca.negocio.login.service.UsurioService;
import co.edu.ucundinamarca.negocio.login.utils.JWTUtil;
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
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("/validar/{login}/{clave}")
    public ResponseEntity<Usuario> validar(@PathVariable String login, @PathVariable String clave) {
        Usuario usuarioLogin=usuarioService.login(login, clave);
        if(usuarioLogin==null){
            return new ResponseEntity(new Mensaje("el usuario no esta registrado"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(usuarioLogin);







    }


    }
