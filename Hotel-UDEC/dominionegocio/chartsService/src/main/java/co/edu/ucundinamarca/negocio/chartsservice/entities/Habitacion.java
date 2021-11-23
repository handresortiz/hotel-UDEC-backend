package co.edu.ucundinamarca.negocio.chartsservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table( name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habitacion;

    @ManyToOne()
    @JoinColumn( name = "id_tipo_habitacion" )
    private TipoHabitacion id_tipo_habitacion;

    @NotEmpty
    private String num_habitacion;

    @Temporal(TemporalType.DATE)
    private Date fec_cambio;

    private Integer id_usuario_cambio;

    private Boolean limpieza;

    private Character estado;

    private Boolean mantenimiento;

    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public TipoHabitacion getId_tipo_habitacion() {
        return id_tipo_habitacion;
    }

    public void setId_tipo_habitacion(TipoHabitacion id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }

    public String getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(String num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public Date getFec_cambio() {
        return fec_cambio;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public Integer getId_usuario_cambio() {
        return id_usuario_cambio;
    }

    public void setId_usuario_cambio(Integer id_usuario_cambio) {
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
