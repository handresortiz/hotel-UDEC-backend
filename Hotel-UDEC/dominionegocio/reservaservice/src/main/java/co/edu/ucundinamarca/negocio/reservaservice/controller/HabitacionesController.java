package co.edu.ucundinamarca.negocio.reservaservice.controller;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.reservaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.reservaservice.services.HabitacionesService;
import co.edu.ucundinamarca.negocio.reservaservice.validators.MinDateToday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@RestController
@Validated
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

    @GetMapping("/filtro")
    public List<TipoHabitacion> getHabitacionesFiltradas(@RequestParam(value = "id", required = false) Integer idTipo,
                                                         @RequestParam(value = "num_habitaciones", required = false) @Min(1) Integer num_habitaciones,
                                                         @RequestParam("num_adultos") @Min(1) Integer num_adultos,
                                                         @RequestParam(value = "num_ninos", required = false) @Min(0) Integer num_ninos,
                                                         @RequestParam("fec_inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") @MinDateToday Date fec_inicio,
                                                         @RequestParam("fec_fin") @DateTimeFormat(pattern = "yyyy-MM-dd") @MinDateToday Date fec_fin
    ){
        return habitacionesService.getHabitacionesFiltradas( idTipo, num_habitaciones, num_adultos, num_ninos,fec_inicio,fec_fin);
    }
}
