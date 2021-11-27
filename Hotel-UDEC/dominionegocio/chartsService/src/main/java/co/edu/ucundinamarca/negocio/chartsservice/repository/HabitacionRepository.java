package co.edu.ucundinamarca.negocio.chartsservice.repository;

import co.edu.ucundinamarca.negocio.chartsservice.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query(value = "SELECT COUNT(*) FROM habitaciones WHERE estado LIKE 'O'",nativeQuery = true)
    public Integer allOcupation();

    @Query(value = "SELECT COUNT(*) FROM habitaciones WHERE estado LIKE 'D'", nativeQuery = true)
    public Integer allDisponible();

    @Query(value = "SELECT COUNT(*) FROM habitaciones WHERE estado LIKE 'L'", nativeQuery = true)
    public Integer allClean();

    @Query(value = "SELECT COUNT(*) FROM habitaciones WHERE estado LIKE 'M'", nativeQuery = true)
    public Integer allMantenaince();

}
