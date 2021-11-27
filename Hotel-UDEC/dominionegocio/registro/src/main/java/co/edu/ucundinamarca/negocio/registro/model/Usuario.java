/*
Usuario
se generaron los diferentes atributos que van a tener la clase usuario.

se implementa una relacion de persona y usuario de uno a muchos

se implementa una relacion de perfil y usuario de uno a muchos

la anotacion @generatedValue es para que el id_perfil se genere automaticamente
para que no halla conflictos ya que id_perfil es una llave primaria

los diferentes metodos estan agregados con las anotaciones @Getter y @Setter
28/10/2021
@jhoandrojas
 */


package co.edu.ucundinamarca.negocio.registro.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="usuarios")
@Getter
@Setter
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_usuario;
    private String clave;
    private String login;
    private Timestamp fec_cambio;
    private String id_usuario_cambio;
    private Boolean verificado_correo;
    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona idpersona;

    @ManyToOne
    @JoinColumn(name="id_perfil")
    private Perfil idperfil;



    public Usuario( String login) {
        this.login = login;

    }

    public Usuario() {

    }
}
