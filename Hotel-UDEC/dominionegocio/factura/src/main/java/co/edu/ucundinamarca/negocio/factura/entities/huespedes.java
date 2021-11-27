/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
@Setter
@Getter
@Table(name = "huesped")

public class huespedes {
    
    @Id
    private Integer id_huesped;
    @Column(name = "id_persona")
    private Integer id;
    private Date fec_cambio;
    private Integer id_usuario;
    private Long id_usuario_cambio;
    
    
}
