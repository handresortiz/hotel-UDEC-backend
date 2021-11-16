package co.edu.ucundinamarca.negocio.registro.rest;

import co.edu.ucundinamarca.negocio.registro.model.Perfil;
import co.edu.ucundinamarca.negocio.registro.model.PerfilRol;
import co.edu.ucundinamarca.negocio.registro.model.Rol;
import co.edu.ucundinamarca.negocio.registro.model.Usuario;
import co.edu.ucundinamarca.negocio.registro.service.PerfilRolService;
import co.edu.ucundinamarca.negocio.registro.service.PerfilService;
import co.edu.ucundinamarca.negocio.registro.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel/perfilrol")
public class PerfilRolRest {

    @Autowired
    private PerfilRolService perfilRolService;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private RolService rolService;
    @PostMapping("/agregar")
    public ResponseEntity<PerfilRol> crear(@RequestBody PerfilRol perfilRol){

        perfilRol.setIdrol(rolService.endId());
        perfilRol.setIdperfil(perfilService.endId());
        perfilRolService.guardar(perfilRol);
        return new ResponseEntity(new Mensaje("rol creado"), HttpStatus.OK);

    }
    @GetMapping("/listar")
    public PerfilRol findId() {
        return perfilRolService.endId();
    }

}
