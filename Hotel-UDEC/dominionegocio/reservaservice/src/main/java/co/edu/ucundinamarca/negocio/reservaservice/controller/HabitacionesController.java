package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.reservaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.TipoHabitacionRepository;
import co.edu.ucundinamarca.negocio.reservaservice.services.HabitacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/habitaciones")
public class HabitacionesController {

    private final HabitacionesService habitacionesService;

    @Autowired
    public HabitacionesController(HabitacionesService habitacionesService) {
        this.habitacionesService = habitacionesService;
    }

    @GetMapping
    public List<Habitaciones> getHabitaciones(){
        return habitacionesService.getHabitaciones();
    }

    @GetMapping("/tipo/{id}")
    public TipoHabitacion getTipoHabitacion( @PathVariable("id") Integer id ){
        return habitacionesService.getTipoHabitacionById( id );
    }
}
