package co.edu.ucundinamarca.negocio.registro.rest;

import co.edu.ucundinamarca.negocio.registro.model.Rol;
import co.edu.ucundinamarca.negocio.registro.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel/rol")
public class RolRest {

    @Autowired
    private RolService rolService;

    @PostMapping("/agregar")
    public ResponseEntity<Rol> create(@RequestBody Rol rol){
        String rolp="huesped";
        rol.setNom_rol(rolp);
        rolService.guardar(rol);
        return new ResponseEntity(new Mensaje("rol creado"), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public Rol findId() {
        return rolService.endId();
    }


}
