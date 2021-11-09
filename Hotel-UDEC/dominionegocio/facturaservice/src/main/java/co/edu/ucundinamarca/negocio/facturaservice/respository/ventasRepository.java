package co.edu.ucundinamarca.negocio.facturaservice.respository;

import co.edu.ucundinamarca.negocio.facturaservice.entities.ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ventasRepository extends JpaRepository<ventas, Integer> {


}
