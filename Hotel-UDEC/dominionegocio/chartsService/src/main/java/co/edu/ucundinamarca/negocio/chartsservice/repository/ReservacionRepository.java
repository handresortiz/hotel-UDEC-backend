package co.edu.ucundinamarca.negocio.chartsservice.repository;

import co.edu.ucundinamarca.negocio.chartsservice.entities.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {

    @Query(value = "SELECT extract(month from fec_inicio ) FROM reservaciones ORDER BY extract(month from fec_inicio ) ASC", nativeQuery = true)
    List<Integer> findMonthInReservations();



}
