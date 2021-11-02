/*
PerfilRest
se genera la parte de rest, donde se agrega el mapeo de la rutas y los metodos
 ya creados en la clase PersonaService.

 se implementa los metodos donde con una condicion se verifica si existe o no el correo, la identidad y telefo
 en caso tal que exista envia un mensaje de que ese dato ya existe.

28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.rest;
import co.edu.ucundinamarca.negocio.registro.model.Persona;
import co.edu.ucundinamarca.negocio.registro.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel/persona")
public class PersonaRest {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/agregar")
    public ResponseEntity<Persona> crear(@RequestBody Persona persona){
        if(personaService.existsByCorreo(persona.getCorreo()))
            return new ResponseEntity(new Mensaje("el correo ingresado ya existe"), HttpStatus.BAD_REQUEST);

        if(personaService.existsByIdentificacion(persona.getIdentificacion()))
            return new ResponseEntity(new Mensaje("la identificacion ingresada ya se encuentra registrada"), HttpStatus.BAD_REQUEST);


        if(personaService.existsByTelefono(persona.getTelefono()))
            return new ResponseEntity(new Mensaje("el telefono ya se encuentra registrado"), HttpStatus.BAD_REQUEST);

        personaService.guardar(persona);

        return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);
    }


}


