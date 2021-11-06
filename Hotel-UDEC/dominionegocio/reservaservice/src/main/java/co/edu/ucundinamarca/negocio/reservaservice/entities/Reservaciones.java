package co.edu.ucundinamarca.negocio.reservaservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "reservaciones" )
public class Reservaciones {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_reservacion;

    @NotNull
    private Long valor;

    @NotNull
    private Date fec_inicio;

    @NotNull
    private Date fec_fin;

    private Date fec_cambio;

    private Long id_usuario_cambio;

    @OneToOne()
    @JoinColumn(name = "id_habitacion")
    private Habitaciones habitacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn( name="id_cuenta" )
    private Cuenta cuenta;

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(Integer id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public Date getFec_inicio() {
        return fec_inicio;
    }

    public void setFec_inicio(Date fec_inicio) {
        this.fec_inicio = fec_inicio;
    }

    public Date getFec_fin() {
        return fec_fin;
    }

    public void setFec_fin(Date fec_fin) {
        this.fec_fin = fec_fin;
    }

    public void setFec_cambio() {
        this.fec_cambio = new Date();
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
