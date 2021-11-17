package co.edu.ucundinamarca.negocio.ocupacionservice.service;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;

public interface IReservaService {

	public Reserva findById(Long id);

	public Reserva save(Reserva reserva);

}
