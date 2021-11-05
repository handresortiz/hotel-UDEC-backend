package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

    @Query("SELECT t FROM TipoHabitacion t WHERE t.num_adultos >= ?1 AND t.num_ninos >= ?2 ORDER BY t.num_adultos, t.num_ninos")
    List<TipoHabitacion> findByPersonas(Integer num_adultos, Integer num_ninos );

}


