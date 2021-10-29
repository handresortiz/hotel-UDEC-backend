package co.edu.ucundinamarca.negocio.reservaservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "reservaciones" )
public class Reservaciones {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_reservacion;

    private Integer id_habitacion;
    private Date fec_inicio;
    private Date fec_fin;
    private Date fec_cambio;
    private Long id_usuario_cambio;

    public Integer getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(Integer id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public Integer getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
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

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }
}
