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
@Table(name = "cuenta")

public class cuenta {
    
     @Id
    private Integer id_cuenta;
    private Integer id_reservacion;
    private Date fec_cambio;
    @Column(name = "id_huesped")
    private Integer id;
    private Long id_usuario_cambio;
    
    
}
