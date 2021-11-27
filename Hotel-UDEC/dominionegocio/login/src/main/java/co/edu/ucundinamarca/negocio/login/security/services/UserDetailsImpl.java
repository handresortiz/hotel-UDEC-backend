package co.edu.ucundinamarca.negocio.login.security.services;

import co.edu.ucundinamarca.negocio.login.model.Perfil;
import co.edu.ucundinamarca.negocio.login.model.Persona;
import co.edu.ucundinamarca.negocio.login.model.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String login;

    private String clave;

    private Boolean verificado_correo;

    private Persona persona;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String login, String clave, Boolean verificado_correo, Persona persona,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.clave = clave;
        this.verificado_correo = verificado_correo;
        this.persona = persona;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Usuario user) {
        List<GrantedAuthority> authority = user.getRoles().stream()
                .map( role ->  new SimpleGrantedAuthority(role.getNomRol()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId_usuario(),
                user.getLogin(),
                user.getClave(),
                user.getVerificado_correo(),
                user.getIdpersona(),
                authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.clave;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    public Boolean getVerificado_correo() {
        return verificado_correo;
    }

    public Persona getPersona() {
        return persona;
    }


//    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
