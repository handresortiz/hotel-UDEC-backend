package co.edu.ucundinamarca.negocio.ocupacionservice.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "usuarios" )
public class Usuarios {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private Integer id_persona;
    private Integer id_perfil;
    private String login;
    private String clave;
    private Boolean verificado_correo;
    private Date fec_cambio;
    private String id_usuario_cambio;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getVerificado_correo() {
        return verificado_correo;
    }

    public void setVerificado_correo(Boolean verificado_correo) {
        this.verificado_correo = verificado_correo;
    }

    public void setFec_cambio(Date fec_cambio) {
        this.fec_cambio = fec_cambio;
    }

    public void setId_usuario_cambio(String id_usuario_cambio) {
        this.id_usuario_cambio = id_usuario_cambio;
    }

    public Date getFec_cambio() {
        return fec_cambio;
    }

    public String getId_usuario_cambio() {
        return id_usuario_cambio;
    }

}

