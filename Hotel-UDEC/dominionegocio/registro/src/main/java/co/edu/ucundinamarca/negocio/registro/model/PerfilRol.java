package co.edu.ucundinamarca.negocio.registro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="perfiles_roles")
@Getter
@Setter
@ToString

public class PerfilRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_perfil_rol;

    @ManyToOne
    @JoinColumn(name="id_perfil")
    private Perfil idperfil;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol idrol;


}
