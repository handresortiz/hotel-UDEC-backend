package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;

public interface ILogEstadoHabitacionDao extends JpaRepository<LogCambioEstado,Long>{

	@Query("select l from LogCambioEstado  l where l.habitacion.id = ?1")
	public List<LogCambioEstado> findAllById(Long id);
}
