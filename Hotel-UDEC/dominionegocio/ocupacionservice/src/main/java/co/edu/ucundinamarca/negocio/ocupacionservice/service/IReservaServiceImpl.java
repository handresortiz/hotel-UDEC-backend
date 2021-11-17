package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.repository.IReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IReservaServiceImpl implements IReservaService {
	@Autowired
	private IReservaDao reservaDao;
	
	@Override
	public Reserva findById(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	public Reserva save(Reserva reserva) {
		return reservaDao.save(reserva);
	}

}
