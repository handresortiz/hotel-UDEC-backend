package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Tipo;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.IHabitacionDao;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.ILogEstadoHabitacionDao;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.IReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Estado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService{

	@Autowired
	private IHabitacionDao habitacionDao;
	
	@Autowired
	private ILogEstadoHabitacionDao logEstadoHabitacionDao;
	
	@Autowired
	private IReservaDao reservaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Habitacion> findAll() {
		return (List<Habitacion>) habitacionDao.findAll();
	}

	@Override
	@Transactional
	public Habitacion save(Habitacion habitacion) {
		return habitacionDao.save(habitacion);
	}

	@Override
	public List<LogCambioEstado> findLogAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitacion inactivar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitacion entregaHabitacion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAllReservas() {
		return (List<Reserva>) habitacionDao.findAllReservas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findByIdClienteReserva(Long idCliente) {
		return (List<Reserva>) habitacionDao.findByIdClienteReserva(idCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Habitacion findById(Long id) {
		return habitacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipo> findAllTipos() {
		return habitacionDao.findAllTipos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Estado> findAllEstados() {
		return habitacionDao.findAllEstados();
	}

	@Override
	public void save(LogCambioEstado logCambioEstado) {
		logEstadoHabitacionDao.save(logCambioEstado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LogCambioEstado> findAllLogCambioEstado(Long id) {
		return logEstadoHabitacionDao.findAllById(id);
	}

	@Override
	public Estado findByIdEstado(Long id) {
		return habitacionDao.findByIdEstado(id);
	}

}
