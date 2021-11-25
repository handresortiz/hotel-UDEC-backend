package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionesRepository extends JpaRepository<Habitaciones, Integer> {
}
