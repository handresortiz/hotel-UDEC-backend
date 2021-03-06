package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name="personas" )
public class Personas {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_persona;

    private String pri_nombre;

    private String seg_nombre;

    private String pri_apellido;

    private String seg_apellido;

    private String razon_social;

    private String direccion;
    private String telefono;

    @Column( unique = true )
    private String correo;

    @Column( unique = true )
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

    public Date getFec_cambio() {
        return fec_cambio;
    }

    public Long getId_usuario_cambio() {
        return id_usuario_cambio;
    }
}