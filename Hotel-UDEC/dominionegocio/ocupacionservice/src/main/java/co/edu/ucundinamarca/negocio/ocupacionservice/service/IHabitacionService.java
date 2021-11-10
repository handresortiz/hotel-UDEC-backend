package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Tipo;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Estado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitacion;


public interface IHabitacionService {
	
	public List<Habitacion> findAll();
	
	public List<Reserva> findAllReservas();

	public List<Reserva> findByIdClienteReserva(Long id);
	
	public Habitacion save(Habitacion habitacion);
	
	public List<LogCambioEstado> findLogAll();
	
	public Habitacion inactivar(Long id);
	
	public Habitacion entregaHabitacion(Long id);
	
	public Habitacion findById(Long id);
	
	public List<Tipo> findAllTipos();
	
	public List<Estado> findAllEstados();
	
	public void save(LogCambioEstado logCambioEstado);
	
	public List<LogCambioEstado> findAllLogCambioEstado(Long id);
	
	public Estado findByIdEstado(Long id);
	

	
}
