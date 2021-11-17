package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.IReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IReservaServiceImpl implements IReservaService {
	@Autowired
	private IReservaDao reservaDao;

	@Override
	public Reservaciones findById(Integer id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	public Reservaciones save(Reservaciones reserva) {
		return reservaDao.save(reserva);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservaciones> findAllByCedula(Integer cedula) {
		return (List<Reservaciones>) reservaDao.findAllByCedula(cedula);
	}
}
