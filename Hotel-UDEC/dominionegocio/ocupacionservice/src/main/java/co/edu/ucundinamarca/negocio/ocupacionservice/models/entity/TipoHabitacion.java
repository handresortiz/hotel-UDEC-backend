package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name="tipo_habitacion" )
public class TipoHabitacion{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id_tipo_habitacion;

	private String nom_tipo_habitacion;

	private String desc_tipo_habitacion;

	private Date fec_cambio;

	private Long id_usuario_cambio;

	private Long precio_habitacion;

	private Integer num_adultos;

	private Integer num_ninos;

	@JsonIgnore
	@OneToMany( mappedBy = "tipo")
	private List<Habitaciones> habitaciones;

	@JsonIgnore
	@OneToMany( mappedBy = "tipo_habitacion")
	private List<GaleriaHabitacion> galeria;

	public List<Habitaciones> getHabitaciones() {
		return habitaciones;
	}

	public List<GaleriaHabitacion> getGaleria() {
		return galeria;
	}

	public Integer getId_tipo_habitacion() {
		return id_tipo_habitacion;
	}

	public void setId_tipo_habitacion(Integer id_tipo_habitacion) {
		this.id_tipo_habitacion = id_tipo_habitacion;
	}

	public String getNom_tipo_habitacion() {
		return nom_tipo_habitacion;
	}

	public void setNom_tipo_habitacion(String nom_tipo_habitacion) {
		this.nom_tipo_habitacion = nom_tipo_habitacion;
	}

	public String getDesc_tipo_habitacion() {
		return desc_tipo_habitacion;
	}

	public void setDesc_tipo_habitacion(String desc_tipo_habitacion) {
		this.desc_tipo_habitacion = desc_tipo_habitacion;
	}


	public Date getFec_cambio() {
		return fec_cambio;
	}

	public Long getId_usuario_cambio() {
		return id_usuario_cambio;
	}

	public void setFec_cambio(Date fec_cambio) {
		this.fec_cambio = fec_cambio;
	}

	public void setId_usuario_cambio(Long id_usuario_cambio) {
		this.id_usuario_cambio = id_usuario_cambio;
	}

	public Long getPrecio_habitacion() {
		return precio_habitacion;
	}

	public void setPrecio_habitacion(Long precio_habitacion) {
		this.precio_habitacion = precio_habitacion;
	}

	public Integer getNum_adultos() {
		return num_adultos;
	}

	public void setNum_adultos(Integer num_adultos) {
		this.num_adultos = num_adultos;
	}

	public Integer getNum_ninos() {
		return num_ninos;
	}

	public void setNum_ninos(Integer num_ninos) {
		this.num_ninos = num_ninos;
	}

}

