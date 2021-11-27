package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
@Entity
@Table( name = "cuenta" )
public class Cuenta {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id_cuenta;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_huesped")
	private Huespedes huesped;

	private Long total;

	private Date fec_creada;

	private Date fec_cambio;
	private Long id_usuario_cambio;

	@OneToMany( mappedBy = "cuenta" )
	@JsonIgnore
	private List<Reservaciones> reservas;

	public Integer getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}


	public void setFec_cambio() {
		this.fec_cambio = new Date();
	}

	public void setId_usuario_cambio(Long id_usuario_cambio) {
		this.id_usuario_cambio = id_usuario_cambio;
	}

	public Huespedes getHuesped() {
		return huesped;
	}

	public void setHuesped(Huespedes huesped) {
		this.huesped = huesped;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Date getFec_creada() {
		return fec_creada;
	}

	public void setFec_creada() {
		this.fec_creada = new Date();
	}

	public List<Reservaciones> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservaciones> reservas) {
		this.reservas = reservas;
	}

	public Date getFec_cambio() {
		return fec_cambio;
	}

	public void setFec_cambio(Date fec_cambio) {
		this.fec_cambio = fec_cambio;
	}

	public Long getId_usuario_cambio() {
		return id_usuario_cambio;
	}

	public void setFec_creada(Date fec_creada) {
		this.fec_creada = fec_creada;
	}

}