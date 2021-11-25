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

    public Persona() {
    }

    public Persona(Long id_persona, String pri_nombre, String seg_nombre, String pri_apellido, String seg_apellido, String razon_social, String telefono, String direccion, String correo, Long identificacion, Character genero) {
        this.id_persona = id_persona;
        this.pri_nombre = pri_nombre;
        this.seg_nombre = seg_nombre;
        this.pri_apellido = pri_apellido;
        this.seg_apellido = seg_apellido;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public Persona(String pri_nombre, String seg_nombre, String pri_apellido, String seg_apellido, String razon_social, String telefono, String direccion, String correo, Long identificacion, Character genero) {
        this.id_persona = id_persona;
        this.pri_nombre = pri_nombre;
        this.seg_nombre = seg_nombre;
        this.pri_apellido = pri_apellido;
        this.seg_apellido = seg_apellido;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.identificacion = identificacion;
        this.genero = genero;
    }
}
