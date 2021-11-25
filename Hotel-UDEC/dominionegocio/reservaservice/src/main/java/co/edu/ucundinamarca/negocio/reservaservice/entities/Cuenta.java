package co.edu.ucundinamarca.negocio.reservaservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "cuenta" )
public class Cuenta {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_cuenta;

    @NotNull
    private Integer id_huesped;

    @NotNull
    private Long total;

    @NotNull
    private Date fec_creada;

    private Date fec_cambio;
    private Long id_usuario_cambio;

    @OneToMany( mappedBy = "cuenta" )
    private List<Reservaciones> reservas;

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }


    public void setFec_cambio() {
        this.fec_cambio = new Date();
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }


    public Integer getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Integer id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getFec_creada() {
        return fec_creada;
    }

    public void setFec_creada() {
        this.fec_creada = new Date();
    }

    public List<Reservaciones> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservaciones> reservas) {
        this.reservas = reservas;
    }
}
