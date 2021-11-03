package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import co.edu.ucundinamarca.negocio.reservaservice.entities.Reservaciones;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HuespedesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservasService {

    private final HuespedesRepository huespedesRepository;
    private final ReservacionesRepository reservacionesRepository;
    private final HabitacionesRepository habitacionesRepository;

    @Autowired
    public ReservasService(HuespedesRepository huespedesRepository, ReservacionesRepository reservacionesRepository, HabitacionesRepository habitacionesRepository) {
        this.huespedesRepository = huespedesRepository;
        this.reservacionesRepository = reservacionesRepository;
        this.habitacionesRepository = habitacionesRepository;
    }

    public Huespedes getHuespedById( Integer id ) {
        return huespedesRepository.findById( id ).get();
    }

    /**
     * Verifica la disponibilidad de las habitaciones dadas.
     * @param id_habitaciones Arreglo de ids de habitaciones
     * @param fec_inicio
     * @param fec_fin
     */
    public void verificarHabitaciones(Integer[] id_habitaciones, Date fec_inicio, Date fec_fin){
        Boolean disponible = true;      // Bandera para indicar disponibilidad de habitaciones
        List<Reservaciones> reservas = new ArrayList<>();  // Reservaciones a registrar

        /* Itera los id de las habitaciones para verificar una por un una su disponibilidad */
        for ( Integer id_habitacion : id_habitaciones) {

            /* Verifica si la habitacion existe */
            if(!habitacionesRepository.existsById( id_habitacion )){
                /* Lanza una excepción indicando que la habitacion no existe */
                throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
                        "Habitacion con el id " + id_habitacion + " no existe" );
            }

            disponible = reservacionesRepository.esHabitacionDisponible( id_habitacion, fec_inicio, fec_fin );

            if( !disponible ){
                /* Lanza una excepción indicando que la habitacion no está disponible */
                throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
                        "Habitacion con el id " + id_habitacion + " no está disponible" );
            }
        }
    }

    public List<Reservaciones> registrarReservas(Integer[] id_habitaciones, Date fec_inicio, Date fec_fin){

        List<Reservaciones> reservas = new ArrayList<>();  // Reservaciones a registrar

        verificarHabitaciones( id_habitaciones, fec_inicio, fec_fin );

        /* Itera los id de las habitaciones para registrar una reservacion por habitacion */
        for ( Integer id_habitacion : id_habitaciones) {
            /* Crea un objeto de reserva para encapsular los datos de la reserva*/
            Reservaciones reserva = new Reservaciones();
            /* Encuentra el objeto habitacion por su id */
            Habitaciones habitacion = habitacionesRepository.findById( id_habitacion ).get();

            /* Guarda el objeto habitacion encontrado dentro del objeto reserva */
            reserva.setHabitacion( habitacion );

            reserva.setFec_inicio( fec_inicio );
            reserva.setFec_fin( fec_fin );
            reserva.setFec_cambio();

            /* Registra la reserva en la lista */
            reservas.add( reserva );
        }

        /* Registra la lista de reservas en la BD, retornando la vista guardada */
        return reservacionesRepository.saveAll( reservas );
    }

}
