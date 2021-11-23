package co.edu.ucundinamarca.negocio.chartsservice.repository;

import co.edu.ucundinamarca.negocio.chartsservice.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    @Query(value = "SELECT extract(MONTH FROM fec_creada) FROM cuenta ORDER BY extract(MONTH FROM fec_creada)", nativeQuery = true)
    List<Integer> allCounts();
}
