package co.edu.ucundinamarca.negocio.login.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_usuario;
    private String clave;
    private String login;
    private Boolean verificado_correo;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona idpersona;

    @OneToMany
    @JoinColumn(name="id_rol")
    private List<Rol> roles;

    public Usuario() {

    }

    public Usuario( String clave, String login, Persona idpersona) {
        this.clave = clave;
        this.login = login;
        this.idpersona = idpersona;
    }

    public Usuario(String clave, String login){
        this.login = login;
        this.clave = clave;
    }

    public Usuario(Long id_usuario, String login, String clave) {
        this.login = login;
        this.clave = clave;
        this.id_usuario=id_usuario;
    }





}
