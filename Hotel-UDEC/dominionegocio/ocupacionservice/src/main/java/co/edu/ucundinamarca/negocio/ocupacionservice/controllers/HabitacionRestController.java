package co.edu.ucundinamarca.negocio.ocupacionservice.controllers;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Habitaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.LogCambioEstado;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.TipoHabitacion;
import co.edu.ucundinamarca.negocio.ocupacionservice.service.IHabitacionService;
import co.edu.ucundinamarca.negocio.ocupacionservice.service.IReservaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class HabitacionRestController {

	@Autowired
	private IHabitacionService habitacionService;

	@Autowired
	private IReservaService reservaService;

	@GetMapping("/habitaciones")
	public List<Habitaciones> index() {
		return habitacionService.findAll();
	}

	@GetMapping("/cantidadexestado")
	public Map<String, Long> quantityState() throws Exception {
		Map<String, Long> quantityStates = null;
		List<Habitaciones> habitaciones = habitacionService.findAll();
		int cantidadReservada = 0;
		int cantidadMantenimiento = 0;
		int cantidadDisponible = 0;
		int cantidadOcupada = 0;
		int cantidadLimpieza = 0;
		try {
			quantityStates = new HashMap<String, Long>();
			for (Habitaciones habitacion : habitaciones) {
				if (habitacion.getEstado().equals('R')) {
					cantidadReservada++;
				} else if (habitacion.getEstado().equals('M')) {
					cantidadMantenimiento++;
				} else if (habitacion.getEstado().equals('D')) {
					cantidadDisponible++;
				} else if (habitacion.getEstado().equals('O')) {
					cantidadOcupada++;
				} else if (habitacion.getEstado().equals('L')) {
					cantidadLimpieza++;
				}
			}
			quantityStates.put("Reservada (R) ", (long) cantidadReservada);
			quantityStates.put("Mantenimiento (M) ", (long) cantidadMantenimiento);
			quantityStates.put("Disponible (D)", (long) cantidadDisponible);
			quantityStates.put("Ocupada (O)", (long) cantidadOcupada);
			quantityStates.put("Limpieza (L)", (long) cantidadLimpieza);
			quantityStates.put("Total de Habitaciones ", (long) habitaciones.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return quantityStates;
	}

	@GetMapping("/reservas")
	public List<Reservaciones> getReservas() {
		return habitacionService.findAllReservas();
	}

	@GetMapping("/habitacion/{id}")
	public ResponseEntity<?> showHabitacion(@PathVariable Integer id) {
		Habitaciones habitacion = null;
		Map<String, Object> response = new HashMap<>();
		try {
			habitacion = habitacionService.findById(id);
		} catch (DataAccessException ex) {
			response.put("mensaje", "Errro al realizar la consulta a la bd");
			response.put("error", ex.getCause() + " : " + ex.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (habitacion == null) {
			response.put("mensaje", "No existe un numero de habitacion con esa identificacion.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Habitaciones>(habitacion, HttpStatus.OK);
	}

	@GetMapping("/tipos")
	public List<TipoHabitacion> findAllTipos() {
		return habitacionService.findAllTipos();
	}

	@GetMapping("/reserva/persona/{cedula}")
	public List<Reservaciones> findAllByCedula(@PathVariable Integer cedula) {
		return reservaService.findAllByCedula(cedula);
	}

	@PutMapping("/habitacion/updatestateoccupied/{idhabitacion}")
	public Habitaciones updateStateToOccupied(@PathVariable Integer idhabitacion) {
		Habitaciones habitacionActual = null;
		Habitaciones habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		try {
			habitacionActual = habitacionService.findById(idhabitacion);
			if (habitacionActual != null) {
				Character estado = 'O';
				habitacionActual.setEstado(estado);
				habitacionActual.setFec_cambio(new Date());
				habitacionUpdated = habitacionService.save(habitacionActual);

				logCambio = new LogCambioEstado();
				logCambio.setHabitacion(habitacionUpdated);
				logCambio.setEstado(habitacionUpdated.getEstado());
				logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
				habitacionService.save(logCambio);
			} else {
				habitacionActual = null;
				System.err.println("No existe una habitacion con ese ID");
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return habitacionUpdated;
	}

	@PutMapping("/habitacion/updatestate/{idhabitacion}/estado/{estado}")
	public Habitaciones updateState(@PathVariable Integer idhabitacion, @PathVariable String estado) {
		Habitaciones habitacionActual = null;
		Habitaciones habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		try {
			habitacionActual = habitacionService.findById(idhabitacion);
			if (habitacionActual != null) {
				if (estado.charAt(0) == 'D' || estado.charAt(0) == 'O' || estado.charAt(0) == 'R'
						|| estado.charAt(0) == 'L' || estado.charAt(0) == 'M') {
					habitacionActual.setEstado(estado.charAt(0));
					habitacionActual.setFec_cambio(new Date());
					habitacionUpdated = habitacionService.save(habitacionActual);

					logCambio = new LogCambioEstado();
					logCambio.setHabitacion(habitacionUpdated);
					logCambio.setEstado(habitacionUpdated.getEstado());
					logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
					habitacionService.save(logCambio);
				} else {
					habitacionUpdated = null;
					System.out.println("No existe un estado con ese caracter");
				}
			} else {
				habitacionActual = null;
				System.err.println("No existe una habitacion con ese ID");
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return habitacionUpdated;
	}

	@PutMapping("/habitacion/cambiarestadomantenimiento/{idhabitacion}/estado/{estado}")
	public Habitaciones cambiarEstadoMantenimiento(@PathVariable Integer idhabitacion, @PathVariable Boolean estado) {
		Habitaciones habitacionActual = null;
		Habitaciones habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		try {
			habitacionActual = habitacionService.findById(idhabitacion);
			if (habitacionActual != null) {

				if (estado) {
					habitacionActual.setFec_cambio(new Date());
					habitacionActual.setMantenimiento(true);
					habitacionActual.setEstado('M');
					habitacionUpdated = habitacionService.save(habitacionActual);
					logCambio = new LogCambioEstado();
					logCambio.setHabitacion(habitacionUpdated);
					logCambio.setEstado(habitacionUpdated.getEstado());
					logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
					habitacionService.save(logCambio);
				} else {
					habitacionActual.setFec_cambio(new Date());
					habitacionActual.setMantenimiento(false);
					habitacionActual.setEstado('D');
					habitacionUpdated = habitacionService.save(habitacionActual);
					logCambio = new LogCambioEstado();
					logCambio.setHabitacion(habitacionUpdated);
					logCambio.setEstado(habitacionUpdated.getEstado());
					logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
					habitacionService.save(logCambio);
				}
			} else {
				habitacionActual = null;
				System.err.println("No existe una habitacion con ese ID");
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return habitacionUpdated;
	}

	@PutMapping("/habitacion/cambiarestadolimpieza/{idhabitacion}/estado/{estado}")
	public Habitaciones cambiarEstadoLimpieza(@PathVariable Integer idhabitacion, @PathVariable Boolean estado) {
		Habitaciones habitacionActual = null;
		Habitaciones habitacionUpdated = null;
		LogCambioEstado logCambio = null;
		try {
			habitacionActual = habitacionService.findById(idhabitacion);
			if (habitacionActual != null) {
				if (estado) {
					habitacionActual.setFec_cambio(new Date());
					habitacionActual.setLimpieza(true);
					habitacionActual.setEstado('L');
					habitacionUpdated = habitacionService.save(habitacionActual);
					logCambio = new LogCambioEstado();
					logCambio.setHabitacion(habitacionUpdated);
					logCambio.setEstado(habitacionUpdated.getEstado());
					logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
					habitacionService.save(logCambio);
				} else {
					habitacionActual.setFec_cambio(new Date());
					habitacionActual.setLimpieza(false);
					habitacionActual.setEstado('D');
					habitacionUpdated = habitacionService.save(habitacionActual);
					logCambio = new LogCambioEstado();
					logCambio.setHabitacion(habitacionUpdated);
					logCambio.setEstado(habitacionUpdated.getEstado());
					logCambio.setObservacion("Se cambio el estado a " + habitacionUpdated.getEstado() + " con exito.");
					habitacionService.save(logCambio);
				}
			} else {
				habitacionActual = null;
				System.err.println("No existe una habitacion con ese ID");
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return habitacionUpdated;
	}

	@GetMapping("/logestados/{id}")
	public List<LogCambioEstado> findAllLogCambioEstado(@PathVariable Integer id) {
		return habitacionService.findAllLogCambioEstado(id);
	}
}

