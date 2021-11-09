package com.spring.spring.boot.hoteleria_backend.service;

import java.util.List;

import com.spring.spring.boot.hoteleria_backend.models.entity.Estado;
import com.spring.spring.boot.hoteleria_backend.models.entity.Habitacion;
import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;
import com.spring.spring.boot.hoteleria_backend.models.entity.Tipo;
import com.spring.spring.boot.hoteleria_backend.models.entity.LogCambioEstado;


public interface IHabitacionService {
	
	public List<Habitacion> findAll();
	
	public List<Reserva> findAllReservas();

	public List<Reserva> findByIdClienteReserva(Long id);
	
	public Habitacion save(Habitacion habitacion);
	
	public List<LogCambioEstado> findLogAll();
	
	public Habitacion inactivar(Long id);
	
	public Habitacion entregaHabitacion(Long id);
	
	public Habitacion findById(Long id);
	
	public List<Tipo> findAllTipos();
	
	public List<Estado> findAllEstados();
	
	public void save(LogCambioEstado logCambioEstado);
	
	public List<LogCambioEstado> findAllLogCambioEstado(Long id);
	
	public Estado findByIdEstado(Long id);
	

	
}
