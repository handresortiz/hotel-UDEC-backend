package co.edu.ucundinamarca.negocio.parametricaservice.repository;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.GaleriaHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaleriaHabitacionRepository extends JpaRepository<GaleriaHabitacion, Integer> {

    @Query("SELECT g FROM GaleriaHabitacion g WHERE g.id_tipo_habitacion = ?1")
    List<GaleriaHabitacion> findAllByTipo( Integer id_tipo_habitacion );

}
