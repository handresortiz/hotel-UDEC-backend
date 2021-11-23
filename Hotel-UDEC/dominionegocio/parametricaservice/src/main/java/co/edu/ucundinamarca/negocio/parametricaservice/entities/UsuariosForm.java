package co.edu.ucundinamarca.negocio.parametricaservice.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UsuariosForm {
    @NotNull
    @Valid
    private Personas persona;
    @NotNull(message = "el id del perfil no debe estar en null")
    private Integer id_perfil;
    //@NotNull(message = "El login del usuario no debe estar en null")
    private String login;
    //@NotNull(message = "La clave del usuario no debe estar en null")
    private String clave;


    //public Integer getId_persona() { return id_persona;}

    //public void setId_persona(Integer id_persona) {this.id_persona = id_persona;}
    public Personas getPersona() {
        return persona;
    }
    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public Integer getId_perfil() {  return id_perfil;}

    public void setId_perfil(Integer id_perfil) {  this.id_perfil = id_perfil;}

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

}
