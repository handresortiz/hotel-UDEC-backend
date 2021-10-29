package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Huespedes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuespedesRepository extends JpaRepository<Huespedes, Integer > {
}
