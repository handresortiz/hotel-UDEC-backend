package co.edu.ucundinamarca.negocio.reservaservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table( name = "galeria_habitacion" )
public class GaleriaHabitacion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    private String url_imagen;

    @JsonIgnore
    @ManyToOne
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
