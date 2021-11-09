package com.spring.spring.boot.hoteleria_backend.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.spring.boot.hoteleria_backend.models.entity.Estado;
import com.spring.spring.boot.hoteleria_backend.models.entity.Habitacion;
import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;
import com.spring.spring.boot.hoteleria_backend.models.entity.Tipo;


public interface IHabitacionDao extends JpaRepository<Habitacion,Long>{
	
	@Query("from Reserva")
	public List<Reserva> findAllReservas();
	
	@Query("select r from Reserva r where r.cliente.id = ?1")
	public List<Reserva> findByIdClienteReserva(Long idCliente);
	
	@Query("from Tipo")
	public List<Tipo> findAllTipos();
	
	@Query("from Estado")
	public List<Estado> findAllEstados();
	
	@Query("select e from Estado e where e.id = ?1")
	public Estado findByIdEstado(Long id);
	
}
