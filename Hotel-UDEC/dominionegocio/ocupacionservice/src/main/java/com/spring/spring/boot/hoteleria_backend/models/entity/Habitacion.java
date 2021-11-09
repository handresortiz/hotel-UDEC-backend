package com.spring.spring.boot.hoteleria_backend.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {

	@Id
	private Long id;

	@Column(name = "numero_camas")
	private Long numeroCamas;

	@Column(name = "piso")
	private Long piso;

	@Column(name = "observacion")
	private String observacion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado")
	//Ignoramos propiedades con del json , obtenemos datos de la entidad estado
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo")
	//Ignoramos propiedades con del json , obtenemos datos de la entidad estado
	@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
	private Tipo tipo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_habitacion")
	private List<Reserva> items;
	
	public Habitacion() {
		items = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(Long numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public Long getPiso() {
		return piso;
	}

	public void setPiso(Long piso) {
		this.piso = piso;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Reserva> getItems() {
		return items;
	}

	public void setItems(List<Reserva> items) {
		this.items = items;
	}

	private static final long serialVersionUID = 1L;
}
