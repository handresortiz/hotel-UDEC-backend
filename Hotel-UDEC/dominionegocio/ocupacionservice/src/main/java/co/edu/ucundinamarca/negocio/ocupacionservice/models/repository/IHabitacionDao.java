package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitaciones;


public interface IHabitacionDao extends JpaRepository<Habitaciones,Integer>{

	@Query("from Reservaciones")
	public List<Reservaciones> findAllReservas();

	@Query("from TipoHabitacion")
	public List<TipoHabitacion> findAllTipos();

	@Query("select h from Habitaciones h order by h.id_habitacion asc")
	public List<Habitaciones> findAllHabitaciones();


}
