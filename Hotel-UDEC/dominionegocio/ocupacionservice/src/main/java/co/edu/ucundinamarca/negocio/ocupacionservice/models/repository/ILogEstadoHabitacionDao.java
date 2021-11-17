package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;

public interface ILogEstadoHabitacionDao extends JpaRepository<LogCambioEstado,Integer>{
	@Query("select l from LogCambioEstado  l where l.habitacion.id = ?1 order by l.fecha asc")
	public List<LogCambioEstado> findAllById(Integer id);
}
