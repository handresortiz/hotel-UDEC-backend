package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.reservaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.ReservacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.TipoHabitacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Service
public class HabitacionesService {

    private final HabitacionesRepository habitacionesRepository;
    private final TipoHabitacionRepository tipoHabitacionRepository;
    private final ReservacionesRepository reservacionesRepository;

    @Autowired
    public HabitacionesService(HabitacionesRepository habitacionesRepository,
                               TipoHabitacionRepository tipoHabitacionRepository,
                               ReservacionesRepository reservacionesRepository) {
        this.habitacionesRepository = habitacionesRepository;
        this.tipoHabitacionRepository = tipoHabitacionRepository;
        this.reservacionesRepository = reservacionesRepository;
    }

    public List<Habitaciones> getHabitaciones() {
        return habitacionesRepository.findAll();
    }

    public TipoHabitacion getTipoHabitacionById(Integer id) {
        return tipoHabitacionRepository.findById(id).get();
    }

    public List<TipoHabitacion> getHabitacionesFiltradas(Integer idTipo,
                                                         Integer num_habitaciones,
                                                         Integer num_adultos,
                                                         Integer num_ninos,
                                                         Date fec_inicio,
                                                         Date fec_fin) {

        List<TipoHabitacion> tiposHabitacion = new ArrayList<>();

        if (idTipo == null) {
            if( num_ninos == null ){
                num_ninos = 0;
            }

            tiposHabitacion = tipoHabitacionRepository.findByPersonas(num_adultos, num_ninos);
        } else {
            tiposHabitacion.add(tipoHabitacionRepository.findById(idTipo).get());

        }

        tiposHabitacion.forEach(t ->
                t.getHabitaciones().removeIf(h -> {
                    Boolean disponible = reservacionesRepository.esHabitacionDisponible(h.getId_habitacion(),
                                                                                fec_inicio,
                                                                                fec_fin);
                    return !disponible;
                })
        );

        tiposHabitacion.removeIf(t -> t.getHabitaciones().size() == 0
                                        || (num_habitaciones != null ? t.getHabitaciones().size() < num_habitaciones
                                                                    : false) );

        return tiposHabitacion;
    }

    @Transactional
    public void actualizarEstadoHab( Integer id, Character estado ){
        Habitaciones habitacion = habitacionesRepository.findById( id ).get();
        habitacion.setEstado( estado );
    }
}