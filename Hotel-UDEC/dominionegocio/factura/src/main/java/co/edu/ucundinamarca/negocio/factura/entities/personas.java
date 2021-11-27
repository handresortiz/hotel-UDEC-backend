/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@Table(name = "personas")

public class personas {
    
     @Id
     @Column(name = "id_persona")
    private Integer id;
    private String pri_nombre;
    private String seg_nombre;
    private String pri_apellido;
    private String seg_apellido;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String correo;
    private Integer identificacion;
    private String genero;
    private Date fec_cambio;
    private Long id_usuario_cambio;
    

    
}
