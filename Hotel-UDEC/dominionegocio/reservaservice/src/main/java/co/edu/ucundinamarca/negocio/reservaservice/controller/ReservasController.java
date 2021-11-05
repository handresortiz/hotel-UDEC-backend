package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Personas;
import co.edu.ucundinamarca.negocio.reservaservice.entities.ReservaForm;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Reservaciones;
import co.edu.ucundinamarca.negocio.reservaservice.services.ReservasService;
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

    @Autowired
    public ReservasController(ReservasService reservasService) {
        this.reservasService = reservasService;
    }

    @GetMapping("/huesped/{id}")
    public Huespedes getHuesped( @PathVariable("id") Integer id ){
        return reservasService.getHuespedById( id );
    }

    @PostMapping
    public ResponseEntity<List<Reservaciones>> registrarReserva(@Valid @RequestBody ReservaForm form){
        List<Reservaciones> reservas = reservasService.registrarReservas( form.getId_habitaciones(), form.getFec_inicio(), form.getFec_fin() );
        return new ResponseEntity<>(reservas, HttpStatus.OK );
    }
}