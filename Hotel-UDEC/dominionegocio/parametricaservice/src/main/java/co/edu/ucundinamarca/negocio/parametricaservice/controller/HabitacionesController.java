package co.edu.ucundinamarca.negocio.parametricaservice.controller;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.parametricaservice.services.HabitacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/habitacion")
public class HabitacionesController {

    private final HabitacionesService habitacionesService;

    @Autowired
    public HabitacionesController(HabitacionesService reservasService, HabitacionesService habitacionesService) {
        this.habitacionesService = habitacionesService;
    }

    @DeleteMapping("/{id}")
    public boolean deleteHabitacion(@PathVariable("id") Integer id_habitacion){
        habitacionesService.deleteHabitaciones(id_habitacion);
        return true;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitaciones> updateHuesped(@PathVariable("id") Integer id_habitacion, @Valid @RequestBody Habitaciones habitacion) {
        Habitaciones newHabitacion = habitacionesService.updateHabitaciones( id_habitacion, habitacion );
        return new ResponseEntity<>( newHabitacion, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Habitaciones> addHabitacion(@RequestBody Habitaciones habitacion) {
        Habitaciones newHabitacion = habitacionesService.addHabitacion(habitacion);
        return new ResponseEntity<>(newHabitacion, HttpStatus.CREATED);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Habitaciones>> filtrarHabitaciones(
            @RequestParam(value = "num", required = false) String num,
            @RequestParam(value = "tipo", required = false) Integer tipo
    ){
        List<Habitaciones> habitaciones = habitacionesService.obtenerHabPorFiltro( num, tipo );
        return new ResponseEntity<>( habitaciones, HttpStatus.OK );
    }

}