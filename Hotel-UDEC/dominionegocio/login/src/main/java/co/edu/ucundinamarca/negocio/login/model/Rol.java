package co.edu.ucundinamarca.negocio.login.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", columnDefinition = "serial")
    private Long idRol;

//    @Enumerated(EnumType.STRING)
    @Column(name = "nom_rol",length = 19)
    private String nomRol;

    private String desc_rol;

    private Timestamp fec_Cambio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    public Rol() {
    }
}
