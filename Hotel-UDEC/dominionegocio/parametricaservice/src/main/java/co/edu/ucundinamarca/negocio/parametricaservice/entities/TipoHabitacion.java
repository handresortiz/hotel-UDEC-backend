package co.edu.ucundinamarca.negocio.parametricaservice.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "tipo_habitacion" )
public class TipoHabitacion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_tipo_habitacion;

    @NotNull( message = "El tipo de habitación debe tener un nombre" )
    @Size(min = 3, max = 50, message = "El nombre del tipo de habitacion debe tener entre 3 y 50 carácteres")
    private String nom_tipo_habitacion;

    private String desc_tipo_habitacion;

    @NotNull( message = "El tipo de habitación debe tener un precio por día")
    @Min( value = 1, message = "El precio de la habitación debe ser mayor a 1" )
    private Long precio_habitacion;

    @NotNull( message = "El tipo de habitación debe tener un número de adultos")
    @Min( value = 1, message = "El número de adultos debe ser mayor o igual a 1" )
    private Integer num_adultos;

    @Min( value = 0, message = "El número de niños debe ser mayor o igual a 0" )
    private Integer num_ninos;

    private Date fec_cambio;
    private Long id_usuario_cambio;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name="id_tipo_habitacion" )
    private List<GaleriaHabitacion> galeria;

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

    public List<GaleriaHabitacion> getGaleria() {
        return galeria;
    }

    public void setGaleria(List<GaleriaHabitacion> galeria) {
        this.galeria = galeria;
    }

    public void setFec_cambio() {
        this.fec_cambio = new Date();
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }
}
