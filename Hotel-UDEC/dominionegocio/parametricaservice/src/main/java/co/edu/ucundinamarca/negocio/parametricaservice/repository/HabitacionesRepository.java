package co.edu.ucundinamarca.negocio.parametricaservice.repository;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionesRepository extends JpaRepository<Habitaciones, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Habitaciones p " +
            "WHERE p.num_habitacion = ?1")
    Boolean existsByNum_habitacion(Long num_habitacion);

    @Query(value="SELECT * FROM habitaciones h WHERE CAST( h.num_habitacion AS VARCHAR)  LIKE %?1%", nativeQuery = true)
    List<Habitaciones> filterByNum(String num);

    @Query("SELECT h FROM Habitaciones h WHERE h.id_tipo_habitacion = ?1")
    List<Habitaciones> filterByTipo(Integer id);

    @Query(value="SELECT * FROM habitaciones h WHERE h.id_tipo_habitacion = ?2 AND CAST( h.num_habitacion AS VARCHAR) LIKE %?1%", nativeQuery = true)
    List<Habitaciones> filter(String num, Integer tipo);
}
