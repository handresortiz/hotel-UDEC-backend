package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva,Long>{

}
