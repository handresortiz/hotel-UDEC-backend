package co.edu.ucundinamarca.negocio.parametricaservice.entities;

import javax.persistence.*;

@Entity
@Table( name = "galeria_habitacion" )
public class GaleriaHabitacion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url_imagen;
    private Integer id_tipo_habitacion;

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

    public void setId_tipo_habitacion(Integer id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }
}
