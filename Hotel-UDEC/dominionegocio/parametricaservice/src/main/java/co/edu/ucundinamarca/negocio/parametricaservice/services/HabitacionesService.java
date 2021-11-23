package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.ReservacionesRepository;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class HabitacionesService {

    private final ReservacionesRepository reservacionesRepository;
    private final HabitacionesRepository HabitacionesRepository;


    @Autowired
    public HabitacionesService(ReservacionesRepository reservacionesRepository, co.edu.ucundinamarca.negocio.parametricaservice.repository.HabitacionesRepository habitacionesRepository) {
        this.reservacionesRepository = reservacionesRepository;
        HabitacionesRepository = habitacionesRepository;
    }
    //verificacion Resgistros Asociados Habitaciones
    public Boolean verificacionHabitaciones(Integer id_habitacion) {
        return reservacionesRepository.existsByHabitacion(id_habitacion);
    }
    //delete Habitaciones Sin Asociacion Registro
    public void deleteHabitaciones(Integer id_habitacion){
        if(!verificacionHabitaciones( id_habitacion)){
            HabitacionesRepository.deleteById(id_habitacion);
        }else{
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
                    "Hay reservas asignadas con la id de habitacion numero " + id_habitacion);
        }

    }

    @Transactional
    public Habitaciones updateHabitaciones(Integer id_habitacion, Habitaciones hab) {
        Habitaciones habitacion = HabitacionesRepository.findById(id_habitacion)
                                                        .orElseThrow(() -> new ResponseStatusException( HttpStatus.BAD_REQUEST,
                                                                             "La habitacion numero " + id_habitacion + " No existe"));
        if (hab.getNum_habitacion() != null) {
            habitacion.setNum_habitacion(hab.getNum_habitacion());
        }
        if (hab.getLimpieza() != null) {
            habitacion.setLimpieza(hab.getLimpieza());
        }
        if (hab.getEstado() != null) {
            habitacion.setEstado(hab.getEstado());
        }
        if (hab.getMantenimiento() != null) {
            habitacion.setMantenimiento(hab.getMantenimiento());
        }
        return habitacion;
    }

    public boolean existsHabitacion( Habitaciones habitacion ){
        String error = "";

        if(habitacion.getNum_habitacion() != null
                && HabitacionesRepository.existsByNum_habitacion( habitacion.getNum_habitacion() )){
            error= "El numero de la habitacion " + habitacion.getNum_habitacion() + " ya esta en uso";
        }

        if(!error.isEmpty()){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, error );
        }
        return false;
    }

    public Habitaciones addHabitacion(Habitaciones habitacion){
        if(habitacion.getLimpieza() == null){
            habitacion.setLimpieza(false);
        }
        if(habitacion.getMantenimiento() == null){
            habitacion.setMantenimiento(false);
        }
        if(habitacion.getEstado() == null){
            habitacion.setEstado('D');
        }
        existsHabitacion( habitacion );
        return HabitacionesRepository.save(habitacion);
    }

}
