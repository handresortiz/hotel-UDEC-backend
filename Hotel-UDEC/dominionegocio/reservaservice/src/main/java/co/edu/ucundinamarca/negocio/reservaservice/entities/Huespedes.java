package co.edu.ucundinamarca.negocio.reservaservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "huespedes" )
public class Huespedes {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_huesped;
    private Integer id_usuario;
    private Date fec_cambio;
    private Long id_usuario_cambio;

    @OneToOne
    @JoinColumn( name = "id_persona" )
    private Personas persona;

    public Integer getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Integer id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }

    public Personas getPersona() {
        return persona;
    }
}
