/*
Perfil
se generaron los diferentes atributos que van a tener la clase perfil.

la anotacion @generatedValue es para que el id_perfil se genere automaticamente
para que no halla conflictos ya que id_perfil es una llave primaria

los diferentes metodos estan agregados con las anotaciones @Getter y @Setter
28/10/2021
@jhoandrojas
 */
package co.edu.ucundinamarca.negocio.registro.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="perfiles")
@Getter
@Setter
@ToString
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long  id_perfil;
    private String nom_perfil;
    private String desc_perfil;
    private Timestamp fec_cambio;
    private Long id_usuario_cambio;



}
