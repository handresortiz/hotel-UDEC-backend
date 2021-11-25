package co.edu.ucundinamarca.negocio.login.security.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String login;

    @NotBlank
    private String clave;

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
