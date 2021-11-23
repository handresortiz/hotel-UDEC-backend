package co.edu.ucundinamarca.negocio.chartsservice.repository;

import co.edu.ucundinamarca.negocio.chartsservice.entities.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VentasRepository extends JpaRepository<Ventas, Long> {

    @Query( value = "SELECT extract(month FROM fec_venta) FROM ventas ORDER BY extract(month FROM fec_venta)" , nativeQuery = true)
    List<Integer> findMonthInBuy();
}
