package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.*;
import co.edu.ucundinamarca.negocio.reservaservice.services.CuentaService;
import co.edu.ucundinamarca.negocio.reservaservice.services.ReservasService;
import co.edu.ucundinamarca.negocio.reservaservice.services.PersonasService;
import co.edu.ucundinamarca.negocio.reservaservice.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/reservas")
public class ReservasController {

    private final ReservasService reservasService;
    private final PersonasService personasService;
    private final UsuariosService usuariosService;
    private final CuentaService cuentaService;

    @Autowired
    public ReservasController(ReservasService reservasService, PersonasService personasService, UsuariosService usuariosService, CuentaService cuentaService) {
        this.reservasService = reservasService;
        this.personasService = personasService;
        this.usuariosService = usuariosService;
        this.cuentaService = cuentaService;
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
    public ResponseEntity<Cuenta> registrarReservas(@Valid @RequestBody ReservaForm form){
        Personas persona;
        Usuarios usuario;
        Huespedes huesped;
        List<Reservaciones> reservas;
        Cuenta cuenta;

        /* Extrae la info de la persona del body */
        persona = form.getCliente();
        /* Agrega la persona en su entidad */
        persona = personasService.addPersona(persona);

        /* Agrega un usuario de la persona registrada */
        usuario = usuariosService.addUsuarioFromHuespedes(
                persona.getId_persona(),
                persona.getPri_nombre(),
                persona.getPri_apellido(),
                persona.getIdentificacion() );

        /* Registra un nuevo huesped teniendo el id persona y id usuario */
        huesped = reservasService.addHuesped( persona,usuario.getId_usuario());

        /* Obtiene un listado de reservas donde se incluye el valor de cada reservacion */
        reservas = reservasService.getListReservas( form.getId_habitaciones(), form.getFec_inicio(), form.getFec_fin() );

        /* Registra una nueva cuenta del huesped para asociarle las reservaciones */
        cuenta = cuentaService.registrarCuenta( huesped.getId_huesped(), reservas );

        /* Registra reservas */
        reservas = reservasService.registrarReservas( reservas, cuenta );
        cuenta.setReservas( reservas );

        return new ResponseEntity<>(cuenta, HttpStatus.OK );
    }
}