package co.edu.ucundinamarca.negocio.parametricaservice.controller;

import co.edu.ucundinamarca.negocio.parametricaservice.services.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tipohabitacion")
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @DeleteMapping("/{id}")
    public boolean verificarTipoHabitacion(@PathVariable("id") Integer id_tipo_habitacion){
        tipoHabitacionService.verificarTipoHabitaciones(id_tipo_habitacion);
        return true;
    }

}
