package co.edu.ucundinamarca.negocio.login.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name="personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_persona;
    private  String pri_nombre;
    private String seg_nombre;
    private String pri_apellido;
    private String seg_apellido;
    private String razon_social;
    private String telefono;
    private String direccion;
    private String correo;
    private Long identificacion;
    private Character genero;
}
