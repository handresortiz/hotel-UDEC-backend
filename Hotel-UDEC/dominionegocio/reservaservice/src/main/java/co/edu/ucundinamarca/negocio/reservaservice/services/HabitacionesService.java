package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.reservaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionesService {

    private final HabitacionesRepository habitacionesRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public HabitacionesService(HabitacionesRepository habitacionesRepository, TipoHabitacionRepository tipoHabitacionRepository) {
        this.habitacionesRepository = habitacionesRepository;
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    public List<Habitaciones> getHabitaciones(){
        return habitacionesRepository.findAll();
    }

    public TipoHabitacion getTipoHabitacionById( Integer id ){
        return tipoHabitacionRepository.findById( id ).get();
    }
}
