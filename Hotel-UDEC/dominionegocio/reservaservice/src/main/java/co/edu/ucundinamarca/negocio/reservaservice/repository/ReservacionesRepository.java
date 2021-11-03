package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Reservaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface ReservacionesRepository extends JpaRepository<Reservaciones, Integer> {

    @Query( "SELECT r FROM Reservaciones r WHERE r.habitacion.id_habitacion = ?1" )
    Optional<Reservaciones[]> findByHabitacion( Integer id );

    @Query( "SELECT CASE WHEN count(r) = 0 THEN TRUE ELSE FALSE END FROM Reservaciones r " +
            "WHERE r.habitacion.id_habitacion = ?1 AND (r.fec_inicio >= ?2 AND r.fec_fin <= ?3 )" )
    Boolean esHabitacionDisponible(Integer id_habitacion, Date fec_inicio, Date fec_fin );
}
