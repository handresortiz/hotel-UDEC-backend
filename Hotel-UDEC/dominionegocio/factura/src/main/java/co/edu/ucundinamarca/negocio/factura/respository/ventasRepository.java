package co.edu.ucundinamarca.negocio.factura.respository;

import co.edu.ucundinamarca.negocio.factura.entities.ventas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ventasRepository extends JpaRepository<ventas, Integer> {


}
