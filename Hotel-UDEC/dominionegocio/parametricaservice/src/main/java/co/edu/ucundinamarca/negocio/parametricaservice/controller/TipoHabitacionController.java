package co.edu.ucundinamarca.negocio.parametricaservice.controller;

import co.edu.ucundinamarca.negocio.parametricaservice.services.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
