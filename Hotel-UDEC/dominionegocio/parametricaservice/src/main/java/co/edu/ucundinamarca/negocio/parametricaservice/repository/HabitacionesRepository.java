package co.edu.ucundinamarca.negocio.parametricaservice.repository;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionesRepository extends JpaRepository<Habitaciones, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Habitaciones p " +
            "WHERE p.num_habitacion = ?1")
    Boolean existsByNum_habitacion(Long num_habitacion);
}
