/*

 */



package co.edu.ucundinamarca.negocio.login.model;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@Table(name="usuarios")

public class Usuario {

    public Usuario() {

    }

    @Id
    private Long id_usuario;

    private String login;
    private String clave;

    public Usuario(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }


}
