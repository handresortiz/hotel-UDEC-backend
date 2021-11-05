package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Usuarios;
import co.edu.ucundinamarca.negocio.reservaservice.entities.ReservaForm;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Reservaciones;
import co.edu.ucundinamarca.negocio.reservaservice.services.ReservasService;
import co.edu.ucundinamarca.negocio.reservaservice.services.PersonasService;
import co.edu.ucundinamarca.negocio.reservaservice.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservas")
public class ReservasController {

    private final ReservasService reservasService;
    private final PersonasService personasService;
    private final UsuariosService usuariosService;

    @Autowired
    public ReservasController(ReservasService reservasService, PersonasService personasService, UsuariosService usuariosService) {
        this.reservasService = reservasService;
        this.personasService = personasService;
        this.usuariosService = usuariosService;
    }

    @GetMapping("/huesped/{id}")
    public Huespedes getHuesped( @PathVariable("id") Integer id ){
        return reservasService.getHuespedById( id );
    }

    @PostMapping("/huesped/par")
    public ResponseEntity<Huespedes> addHuespedPar(@RequestBody Huespedes huesped){
        Huespedes newHuesped = reservasService.addHuespedPar( huesped );
        return new ResponseEntity<>(newHuesped, HttpStatus.CREATED);
    }
    @PostMapping("/huesped")
    public ResponseEntity<Huespedes> addHuesped(@Valid @RequestBody Huespedes huesped){
            Personas persona = huesped.getPersona();
            persona = personasService.addPersona(persona);
            Usuarios usuario = usuariosService.addUsuarioFromHuespedes(
                    persona.getId_persona(),
                    persona.getPri_nombre(),
                    persona.getPri_apellido(),
                    persona.getIdentificacion() );
            Huespedes newHuesped = reservasService.addHuesped( persona,usuario.getId_usuario());
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

    @PostMapping
    public ResponseEntity<List<Reservaciones>> registrarReserva(@Valid @RequestBody ReservaForm form){
        List<Reservaciones> reservas = reservasService.registrarReservas( form.getId_habitaciones(), form.getFec_inicio(), form.getFec_fin() );
        return new ResponseEntity<>(reservas, HttpStatus.OK );
    }
}