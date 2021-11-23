package co.edu.ucundinamarca.negocio.parametricaservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table( name="habitaciones" )
public class Habitaciones {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_habitacion;

    @NotNull(message = "El Tipo de Hbaitacion no debe ser null")
    private Integer id_tipo_habitacion;

    @Max(value = 9999,message = "El numero de la Habitacion no puede superar las 4 cifras")
    @Min(value = 1,message = "El numero de la Habitacion debe ser mayor a 1")
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

    public void setId_tipo_habitacion(Integer id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }

    public Integer getId_tipo_habitacion() {
        return id_tipo_habitacion;
    }

}
