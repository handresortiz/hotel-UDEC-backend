package co.edu.ucundinamarca.negocio.reservaservice.repository;

import co.edu.ucundinamarca.negocio.reservaservice.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
}
