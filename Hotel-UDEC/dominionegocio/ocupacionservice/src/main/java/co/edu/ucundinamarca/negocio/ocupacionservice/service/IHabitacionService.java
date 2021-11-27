package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.GaleriaHabitacion;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.TipoHabitacion;


public interface IHabitacionService {

	public List<Habitaciones> findAll();

	public List<Reservaciones> findAllReservas();

	public Habitaciones save(Habitaciones habitacion);

	public Habitaciones entregaHabitacion(Habitaciones habitacion);

	public Habitaciones findById(Integer id);

	public List<TipoHabitacion> findAllTipos();

	public void save(LogCambioEstado logCambioEstado);

	public List<LogCambioEstado> findAllLogCambioEstado(Integer id);

}
