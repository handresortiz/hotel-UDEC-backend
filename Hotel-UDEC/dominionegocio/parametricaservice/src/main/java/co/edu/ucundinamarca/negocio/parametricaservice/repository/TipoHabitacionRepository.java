package co.edu.ucundinamarca.negocio.parametricaservice.repository;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer > {

    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN TRUE ELSE FALSE END FROM Habitaciones h " +
            "WHERE h.id_tipo_habitacion = ?1")

    Boolean existsByTipoHabitacion(Integer id_tipo_habitacion);
}
