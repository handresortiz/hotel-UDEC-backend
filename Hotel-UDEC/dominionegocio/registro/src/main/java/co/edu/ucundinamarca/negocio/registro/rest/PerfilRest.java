/*
PerfilRest
se genera la parte de rest, donde se agrega el mapeo de la rutas y los metodos
ya creados en la clase PerfilService

28/10/2021
@jhoandrojas
 */
package co.edu.ucundinamarca.negocio.registro.rest;
import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import co.edu.ucundinamarca.negocio.registro.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel/perfil")
public class PerfilRest {

    @Autowired
    private PerfilService perfilService;

    @PostMapping("/agregar")
   public ResponseEntity <Perfil> create(@RequestBody Perfil perfil){
        Perfil profileAux = perfilService.endId();
        perfil.setId_perfil( profileAux.getId_perfil() + 1 );
        perfilService.guardar(perfil);
        return new ResponseEntity(new Mensaje("perfil creado"), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Perfil findId() {
        return perfilService.endId();
    }



}
