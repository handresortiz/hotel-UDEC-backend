package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Estado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitacion;


public interface IHabitacionDao extends JpaRepository<Habitacion,Long>{
	
	@Query("from Reserva")
	public List<Reserva> findAllReservas();
	
	@Query("select r from Reserva r where r.cliente.id = ?1")
	public List<Reserva> findByIdClienteReserva(Long idCliente);
	
	@Query("from Tipo")
	public List<Tipo> findAllTipos();
	
	@Query("from Estado")
	public List<Estado> findAllEstados();
	
	@Query("select e from Estado e where e.id = ?1")
	public Estado findByIdEstado(Long id);
	
}
