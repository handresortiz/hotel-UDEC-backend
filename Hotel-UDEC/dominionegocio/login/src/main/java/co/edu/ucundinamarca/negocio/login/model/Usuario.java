package co.edu.ucundinamarca.negocio.login.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuario{


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

    @ManyToOne
    @JoinColumn(name="id_perfil")
    private Perfil idperfil;

    public Usuario() {

    }

    public Usuario(Long id_usuario, String login, String clave) {
        this.login = login;
        this.clave = clave;
        this.id_usuario=id_usuario;
    }



}
