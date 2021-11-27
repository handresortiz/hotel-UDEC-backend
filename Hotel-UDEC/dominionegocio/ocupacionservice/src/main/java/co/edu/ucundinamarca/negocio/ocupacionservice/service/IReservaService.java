package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;

import java.util.List;

public interface IReservaService {

	public Reservaciones findById(Integer id);

	public Reservaciones save(Reservaciones reserva);

	public List<Reservaciones> findAllByCedula(Integer cedula);
}

