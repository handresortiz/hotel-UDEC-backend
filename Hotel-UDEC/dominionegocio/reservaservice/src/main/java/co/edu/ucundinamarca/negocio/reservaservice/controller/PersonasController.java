package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.reservaservice.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class PersonasController {

    private final PersonasService personasService;

    @Autowired
    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping("/{id}")
    public Personas getPersonas(@PathVariable("id") Integer id) {
        return personasService.getPersonaById(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Personas> addHuesped(@RequestBody Personas persona) {
        Personas newPersona = personasService.addPersona(persona);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Personas> updateHuesped(@PathVariable("id") Integer id, @RequestBody Personas persona) {
        Personas newPersona = personasService.updatePersona(id, persona);
        return new ResponseEntity<>(newPersona, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public Personas deleteHuesped(@PathVariable("id") Integer id) {
        return personasService.deletePersonaById(id);
    }
}