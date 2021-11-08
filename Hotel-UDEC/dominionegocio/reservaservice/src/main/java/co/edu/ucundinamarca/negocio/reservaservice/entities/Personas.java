package co.edu.ucundinamarca.negocio.reservaservice.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table( name="personas" )
public class Personas {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_persona;

    @NotNull(message = "El primer nombre no debe estar en null")
    @Size(max = 10,min = 3,message = "El primer nombre no puede ser mayor a 10 caracteres o menor a 3")
    private String pri_nombre;
    private String seg_nombre;
    @NotNull(message = "El primer apellido no debe estar en null")
    @Size(max = 10,min = 3,message = "El primer apellido no puede ser mayor a 10 caracteres o menor a 3")
    private String pri_apellido;
    private String seg_apellido;
    private String razon_social;
    private String direccion;
    @NotNull(message = "El telefono no debe estar en null")
    @Size(max = 15,min = 6,message = "El telefono debe contener entre 6 y 15 cifras")
    private String telefono;

    @Column( unique = true )
    @NotNull(message = "El correo no debe estar en null")
    @Email(message = "No es un correo valido")
    private String correo;

    @Column( unique = true )
    @NotNull(message = "La identificación no debe estar en null")
    @DecimalMax(value = "10000000000",message = "La identificación no puede pasar de 10 cifras")
    @DecimalMin(value = "1000000",message = "La identificación no puede ser menor a 7 cifras")
    private Long identificacion;

    private Character genero;
    private Date fec_cambio;
    private Long id_usuario_cambio;

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getPri_nombre() {
        return pri_nombre;
    }

    public void setPri_nombre(String pri_nombre) {
        this.pri_nombre = pri_nombre;
    }

    public String getSeg_nombre() {
        return seg_nombre;
    }

    public void setSeg_nombre(String seg_nombre) {
        this.seg_nombre = seg_nombre;
    }

    public String getPri_apellido() {
        return pri_apellido;
    }

    public void setPri_apellido(String pri_apellido) {
        this.pri_apellido = pri_apellido;
    }

    public String getSeg_apellido() {
        return seg_apellido;
    }

    public void setSeg_apellido(String seg_apellido) {
        this.seg_apellido = seg_apellido;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(Long id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }
}
