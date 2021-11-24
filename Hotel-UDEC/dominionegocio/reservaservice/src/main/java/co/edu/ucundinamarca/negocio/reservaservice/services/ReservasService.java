package co.edu.ucundinamarca.negocio.reservaservice.services;

import co.edu.ucundinamarca.negocio.reservaservice.entities.*;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HabitacionesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.HuespedesRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.PersonasRepository;
import co.edu.ucundinamarca.negocio.reservaservice.repository.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservasService {

    private final HuespedesRepository huespedesRepository;
    private final ReservacionesRepository reservacionesRepository;
    private final HabitacionesRepository habitacionesRepository;
    private final HabitacionesService habitacionesService;

    @Autowired
    public ReservasService(HuespedesRepository huespedesRepository,
                           PersonasRepository personasRepository,
                           ReservacionesRepository reservacionesRepository,
                           HabitacionesRepository habitacionesRepository,
                           HabitacionesService habitacionesService) {
        this.huespedesRepository = huespedesRepository;
        this.reservacionesRepository = reservacionesRepository;
        this.habitacionesRepository = habitacionesRepository;
        this.habitacionesService = habitacionesService;
    }

    public Huespedes getHuespedById( Integer id ) {
        return huespedesRepository.findById( id ).get();
    }
    public Huespedes addHuespedPar(Huespedes huesped){
        return huespedesRepository.save(huesped);
    }
    public Huespedes addHuesped(Personas persona,Integer id_usuario){
        Huespedes huesped = new Huespedes();
        huesped.setPersona(persona);
        huesped.setId_usuario(id_usuario);
        return huespedesRepository.save(huesped);
    }
    public Huespedes updateHuesped(Integer id, Huespedes huesped){
        return huespedesRepository.save(huesped);
    }
    public Huespedes deleteHuespedById( Integer id ){
        huespedesRepository.deleteById(id);
        return null;
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

    private long getDiferenciaFechas(Date fec_inicio, Date fec_fin){
        TimeUnit time = TimeUnit.DAYS;
        long diff = fec_fin.getTime() - fec_inicio.getTime();
        diff = time.convert( diff, TimeUnit.MILLISECONDS );
        return ( diff == 0 ? 1 : diff);
    }

    public List<Reservaciones> getListReservas(Integer[] id_habitaciones, Date fec_inicio, Date fec_fin){

        List<Reservaciones> reservas = new ArrayList<>();  // Reservaciones a registrar

        verificarHabitaciones( id_habitaciones, fec_inicio, fec_fin );

        /* Itera los id de las habitaciones para registrar una reservacion por habitacion */
        for ( Integer id_habitacion : id_habitaciones) {
            /* Crea un objeto de reserva para encapsular los datos de la reserva*/
            Reservaciones reserva = new Reservaciones();

            /* Encuentra el objeto habitacion por su id */
            Habitaciones habitacion = habitacionesRepository.findById( id_habitacion ).get();

            /* Calcula el valor de la reserva del precio de la habitacion por la cantidad de dias */
            Long valor = habitacion.getTipo().getPrecio_habitacion();
            valor *= getDiferenciaFechas( fec_inicio, fec_fin );

            /* Guarda el objeto habitacion encontrado dentro del objeto reserva */
            reserva.setHabitacion( habitacion );

            reserva.setValor( valor );
            reserva.setFec_inicio( fec_inicio );
            reserva.setFec_fin( fec_fin );
            reserva.setFec_cambio();

            /* Registra la reserva en la lista */
            reservas.add( reserva );
        }

        return reservas;
    }

    public List<Reservaciones> registrarReservas( List<Reservaciones> reservas, Cuenta cuenta ){
        reservas.forEach( r -> {
            habitacionesService.actualizarEstadoHab( r.getHabitacion().getId_habitacion(), 'R' );
            r.setCuenta( cuenta );
        } );
        return reservacionesRepository.saveAll( reservas );
    }
}
