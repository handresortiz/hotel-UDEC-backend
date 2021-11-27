package co.edu.ucundinamarca.negocio.registro.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table(name="roles")
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_rol;
    private String nom_rol;

}
