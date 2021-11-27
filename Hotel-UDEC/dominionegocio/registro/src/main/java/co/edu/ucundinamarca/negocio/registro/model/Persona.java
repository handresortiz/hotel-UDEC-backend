/*
Persona
se generaron los diferentes atributos que van a tener la clase persona.

la anotacion @generatedValue es para que el id_perfil se genere automaticamente
para que no halla conflictos ya que id_perfil es una llave primaria

los diferentes metodos estan agregados con las anotaciones @Getter y @Setter

se agregaron los diferentes metodo sy constructores que se van a utilizar
28/10/2021
@jhoandrojas
 */

package co.edu.ucundinamarca.negocio.registro.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.sql.Timestamp;
@Setter
@Getter
@ToString
@Entity
@Table(name="personas")
public class Persona {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(columnDefinition = "serial")
     private Long id_persona;
     private  String pri_nombre;
     private String seg_nombre;
     private String pri_apellido;
     private String seg_apellido;
     private String razon_social;
     private String telefono;
     private String direccion;
     private String correo;
     private Long identificacion;
     private Character genero;

     public Persona() {

     }



     public Persona(String correo, Long identificacion, String telefono) {
          this.correo = correo;
          this.identificacion = identificacion;
          this.telefono = telefono;

     }



}
