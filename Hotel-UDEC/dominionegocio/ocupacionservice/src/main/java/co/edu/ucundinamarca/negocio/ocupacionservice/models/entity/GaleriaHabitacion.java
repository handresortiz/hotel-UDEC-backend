package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table( name = "galeria_habitacion" )
public class GaleriaHabitacion {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	private String url_imagen;

	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name="id_tipo_habitacion" )
	private TipoHabitacion tipo_habitacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}


}
