package co.edu.ucundinamarca.negocio.reservaservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "cuenta" )
public class Cuenta {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_cuenta;

    private Integer id_reservacion;
    private Integer id_huesped;
    private Date fec_cambio;
    private Long id_usuario_cambio;

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Integer getId_reservacion() {
        return id_reservacion;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }

    public void setId_reservacion(Integer id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public Integer getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Integer id_huesped) {
        this.id_huesped = id_huesped;
    }
}
