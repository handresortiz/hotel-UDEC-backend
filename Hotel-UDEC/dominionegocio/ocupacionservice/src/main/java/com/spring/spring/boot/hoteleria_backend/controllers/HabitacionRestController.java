package com.spring.spring.boot.hoteleria_backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.boot.hoteleria_backend.models.entity.Estado;
import com.spring.spring.boot.hoteleria_backend.models.entity.Habitacion;
import com.spring.spring.boot.hoteleria_backend.models.entity.LogCambioEstado;
import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;
import com.spring.spring.boot.hoteleria_backend.models.entity.Tipo;
import com.spring.spring.boot.hoteleria_backend.service.IHabitacionService;
import com.spring.spring.boot.hoteleria_backend.service.IReservaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class HabitacionRestController {
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/habitaciones")
	public List<Habitacion> index() {
		return habitacionService.findAll();
	}

	@GetMapping("/cantidadexestado")
	public Map<String, Long> quantityState() throws Exception {
		Map<String, Long> quantityStates = null;
		List<Habitacion> habitaciones = habitacionService.findAll();
		int cantidadReservada = 0;
		int cantidadMantenimiento = 0;
		int cantidadDisponible = 0;
		int cantidadOcupada = 0;
		try {
			quantityStates = new HashMap<String, Long>();
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getEstado().getNombre().equals("Reservado")) {
					cantidadReservada++;
				} else if (habitacion.getEstado().getNombre().equals("Mantenimiento")) {
					cantidadMantenimiento++;
				} else if (habitacion.getEstado().getNombre().equals("Disponible")) {
					cantidadDisponible++;
				} else if (habitacion.getEstado().getNombre().equals("Ocupado")) {
					cantidadOcupada++;
				}
			}
			quantityStates.put("Reservada", (long) cantidadReservada);
			quantityStates.put("Mantenimiento", (long) cantidadMantenimiento);
			quantityStates.put("Disponible", (long) cantidadDisponible);
			quantityStates.put("Ocupada", (long) cantidadOcupada);
			quantityStates.put("Habitaciones", (long) habitaciones.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return quantityStates;
	}
	
	@GetMapping("/reservas")
	public List<Reserva> getReservas() {
		return habitacionService.findAllReservas();
	}
	
	@GetMapping("/reservas/{idCliente}")
	public ResponseEntity<?> showReserva(@PathVariable long idCliente) {
		List<Reserva> reserva = null;
		Map<String, Object> response = new HashMap<>();
		try {
			reserva = habitacionService.findByIdClienteReserva(idCliente);
		} catch (DataAccessException ex) {
			response.put("mensaje", "Errro al realizar la consulta a la bd");
			response.put("error", ex.getCause() + " : " + ex.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (reserva.size() == 0) {
			response.put("mensaje", "No existe reservadas con la identificacion " + idCliente + " del cliente.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Reserva>>(reserva, HttpStatus.OK);
	}
	
	
	@GetMapping("/habitacion/{id}")
	public ResponseEntity<?> showHabitacion(@PathVariable long id) {
	Habitacion habitacion = null;
	Map<String, Object> response = new HashMap<>();
	try {
		habitacion = habitacionService.findById(id);
	}catch (DataAccessException ex) {
		response.put("mensaje", "Errro al realizar la consulta a la bd");
		response.put("error", ex.getCause() + " : " + ex.getMostSpecificCause());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	if(habitacion == null) {
		response.put("mensaje", "No existe un numero de habitacion con esa identificacion.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);	
	}
	return new ResponseEntity<Habitacion>(habitacion, HttpStatus.OK);
	}
	
	@PutMapping("/habitacion/{id}")
	public ResponseEntity<?> updateState(@RequestBody Habitacion habitacion, @PathVariable Long id){
		Habitacion habitacionActual = habitacionService.findById(id);
		Habitacion habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		Map<String,Object> response = new HashMap<>();

		if(habitacionActual == null) {
			response.put("mensaje", "Error:  no se pudo editar, el numero de habitacion ".concat(String.valueOf(id).concat(" No existe en la base de datos!")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			habitacionActual.setEstado(habitacion.getEstado());
			habitacionUpdated = habitacionService.save(habitacionActual);
			
		
			logCambio = new LogCambioEstado();
			logCambio.setHabitacion(habitacionUpdated);
			logCambio.setEstado(habitacionUpdated.getEstado().getNombre());
			logCambio.setObservacion("Se cambio el estado a "+habitacionUpdated.getEstado().getNombre()+" con exito.");
			habitacionService.save(logCambio);
			
			
		}catch(DataAccessException ex) {
			response.put("mensaje", "Errro al realizar el actualizar en la base de datos");
			response.put("error", ex.getCause()+" :"+ex.getMostSpecificCause());	
			ex.printStackTrace();
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la habitacion  se actualizado con exito!!");
		response.put("habitacion",habitacionUpdated);
		return new ResponseEntity<Map<String,Object>> (response,HttpStatus.OK);
	}
	
	@GetMapping("/tipos")
	public List<Tipo> findAllTipos() {
		return habitacionService.findAllTipos();
	}
	
	@GetMapping("/estados")
	public List<Estado> findAllEstados() {
		return habitacionService.findAllEstados();
	}
	
	@GetMapping("/logestados/{id}")
	public List<LogCambioEstado> findAllLogCambioEstado(@PathVariable Long id) {
		return habitacionService.findAllLogCambioEstado(id);
	}
	
	@PutMapping("/habitacion/occupied/{id}")
	public Habitacion updateStateToOccupied(@PathVariable Long id){
		Habitacion habitacionActual = habitacionService.findById(id);
		Habitacion habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		try {
			//Id 4 para ocupado
			Long idEstado =(long) 4;
			Estado estado = habitacionService.findByIdEstado(idEstado);
			habitacionActual.setEstado(estado);
			habitacionUpdated = habitacionService.save(habitacionActual);
		
			logCambio = new LogCambioEstado();
			logCambio.setHabitacion(habitacionUpdated);
			logCambio.setEstado(estado.getNombre());
			logCambio.setObservacion("Se cambio el estado a "+habitacionActual.getEstado().getNombre()+" con exito.");
			habitacionService.save(logCambio);
			System.out.println("Se realizo la actualizacion correctamente.");
			
		}catch(DataAccessException ex) {
			ex.printStackTrace();
		}
		return habitacionUpdated;
	}
	
	@PutMapping("/reserva/checkin/{id}")
	public Reserva checkInReserva(@PathVariable Long id) {
		Reserva reservaActual = reservaService.findById(id);
		Reserva reservaUpdated = null;
		try {
			reservaActual.setEstado(true);
			reservaUpdated = reservaService.save(reservaActual);
		}catch(DataAccessException ex) {
			ex.printStackTrace();
		}
		return reservaUpdated;
	}
	
}
