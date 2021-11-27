package co.edu.ucundinamarca.negocio.ocupacionservice.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.IHabitacionDao;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.ILogEstadoHabitacionDao;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.TipoHabitacion;
@Service
public class HabitacionServiceImpl implements IHabitacionService{

	@Autowired
	private IHabitacionDao habitacionDao;

	@Autowired
	private ILogEstadoHabitacionDao logEstadoHabitacionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Habitaciones> findAll() {
		return (List<Habitaciones>) habitacionDao.findAllHabitaciones();
	}

	@Override
	@Transactional
	public Habitaciones save(Habitaciones habitacion) {
		return habitacionDao.save(habitacion);
	}

	@Override
	public Habitaciones entregaHabitacion(Habitaciones habitacion) {
		return habitacionDao.save(habitacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservaciones> findAllReservas() {
		return (List<Reservaciones>) habitacionDao.findAllReservas();
	}

	@Override
	@Transactional(readOnly = true)
	public Habitaciones findById(Integer id) {
		return habitacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoHabitacion> findAllTipos() {
		return habitacionDao.findAllTipos();
	}

	@Override
	@Transactional
	public void save(LogCambioEstado logCambioEstado) {
		logEstadoHabitacionDao.save(logCambioEstado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LogCambioEstado> findAllLogCambioEstado(Integer id) {
		return logEstadoHabitacionDao.findAllById(id);
	}


}
