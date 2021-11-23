package co.edu.ucundinamarca.negocio.parametricaservice.repository;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Reservaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservacionesRepository extends JpaRepository<Reservaciones, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM Reservaciones r " +
            "WHERE r.habitacion.id_habitacion = ?1")
    Boolean existsByHabitacion(Integer habitacion);

}
