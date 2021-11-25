package co.edu.ucundinamarca.negocio.login.security.payload.response;

import java.util.List;

public class JwtResponse {

    private String token;

    private String type = "Bearer";

    private Long id;

    private String login;

    private String pri_nombew;

    private String seg_nombre;

    private List<String> roles;

    public JwtResponse(String token, Long id, String login, String pri_nombew, String seg_nombre, List<String> roles) {
        this.token = token;
        this.id = id;
        this.login = login;
        this.pri_nombew = pri_nombew;
        this.seg_nombre = seg_nombre;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPri_nombew() {
        return pri_nombew;
    }

    public void setPri_nombew(String pri_nombew) {
        this.pri_nombew = pri_nombew;
    }

    public String getSeg_nombre() {
        return seg_nombre;
    }

    public void setSeg_nombre(String seg_nombre) {
        this.seg_nombre = seg_nombre;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
