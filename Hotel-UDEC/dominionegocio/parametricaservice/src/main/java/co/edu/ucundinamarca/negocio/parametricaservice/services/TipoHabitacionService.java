package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TipoHabitacionService {

    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    //delete Habitaciones Sin Asociacion Registro
    public void verificarTipoHabitaciones(Integer id_tipo_habitacion){
        boolean registro = tipoHabitacionRepository.existsByTipoHabitacion(id_tipo_habitacion);
        if(registro){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
                    "Hay Habitaciones asignadas con la id de tipo habitacion numero " + id_tipo_habitacion);
        }
    }
    public TipoHabitacion createTipoHabitacion(TipoHabitacion tipo) {
        return this.tipoHabitacionRepository.save(tipo);
    }
}
