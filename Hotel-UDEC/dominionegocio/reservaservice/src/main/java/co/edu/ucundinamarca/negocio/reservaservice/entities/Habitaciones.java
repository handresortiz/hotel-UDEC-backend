package co.edu.ucundinamarca.negocio.reservaservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name="habitaciones" )
public class Habitaciones {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_habitacion;

    @JsonIgnoreProperties("habitaciones")
    @ManyToOne()
    @JoinColumn( name = "id_tipo_habitacion" )
    private TipoHabitacion tipo;

    private Long num_habitacion;

    private Date fec_cambio;

    private Long id_usuario_cambio;

    private Boolean limpieza;

    private Character estado;

    private Boolean mantenimiento;

    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public Long getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(Long num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }

    public Boolean getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(Boolean limpieza) {
        this.limpieza = limpieza;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Boolean getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

}
