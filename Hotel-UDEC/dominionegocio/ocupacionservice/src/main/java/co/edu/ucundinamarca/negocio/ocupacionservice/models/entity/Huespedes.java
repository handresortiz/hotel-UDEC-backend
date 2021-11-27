package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


@Entity
@Table( name = "huespedes" )
public class Huespedes {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_huesped;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuarios usuario;

    private Date fec_cambio;

    private Long id_usuario_cambio;

    @OneToOne
    @JoinColumn( name = "id_persona")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Personas persona;

    public Integer getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Integer id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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
    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public Date getFec_cambio() {
        return fec_cambio;
    }

    public Long getId_usuario_cambio() {
        return id_usuario_cambio;
    }

}