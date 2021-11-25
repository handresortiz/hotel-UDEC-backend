package co.edu.ucundinamarca.negocio.login.security.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String pri_nombre;

    @Null
    @Size(min = 3, max = 20)
    private String seg_nombre;

    @NotBlank
    @Size(min = 3, max = 20)
    private String pri_apellido;

    @Null
    @Size(min = 3, max = 20)
    private String seg_apellido;

    @NotBlank
    @Size(max = 10)
    private Long identificacion;

    @NotBlank
    @Size(max = 12)
    private String telefono;

    @NotBlank
    @Size(min = 1, max = 150)
    private String razon_social;

    @NotBlank
    @Size(min = 10, max = 50)
    private String direccion;

    @NotBlank
    @Size(max = 10)
    private Character genero;

    @NotBlank
    @Size(max = 50)
    @Email
    private String login;

    private List<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String clave;

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

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
