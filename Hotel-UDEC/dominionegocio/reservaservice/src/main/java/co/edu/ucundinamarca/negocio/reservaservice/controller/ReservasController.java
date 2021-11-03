package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.reservaservice.services.ReservasService;
import co.edu.ucundinamarca.negocio.reservaservice.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservas")
public class ReservasController {

    private final ReservasService reservasService;
    private final PersonasService personasService;

    @Autowired
    public ReservasController(ReservasService reservasService, PersonasService personasService) {
        this.reservasService = reservasService;
        this.personasService = personasService;
    }

    @GetMapping("/huesped/{id}")
    public Huespedes getHuesped( @PathVariable("id") Integer id ){
        return reservasService.getHuespedById( id );
    }

    @PostMapping("/huesped/par")
    public ResponseEntity<Huespedes> addHuespedPar(@RequestBody Huespedes huesped){
        Huespedes newHuesped = reservasService.addHuesped( huesped );
        return new ResponseEntity<>(newHuesped, HttpStatus.CREATED);
    }
    @PostMapping("/huesped")
    public ResponseEntity<Huespedes> addHuesped(@RequestBody Huespedes huesped){
        Personas persona = huesped.getPersona();
        Personas newPersona = personasService.addPersona(persona);
        Huespedes newHuesped = reservasService.addHuesped( huesped );
        return new ResponseEntity<>(newHuesped, HttpStatus.CREATED);
    }
    @PutMapping("/huesped/{id}")
    public ResponseEntity<Huespedes> updateHuesped(@PathVariable("id") Integer id, @RequestBody Huespedes huesped){
        Huespedes newHuesped = reservasService.updateHuesped( id, huesped );
        return new ResponseEntity<>(newHuesped, HttpStatus.OK);
    }
    @DeleteMapping("/huesped/{id}")
    public Huespedes deleteHuesped( @PathVariable("id") Integer id ){
        return reservasService.deleteHuespedById( id );
    }
}
