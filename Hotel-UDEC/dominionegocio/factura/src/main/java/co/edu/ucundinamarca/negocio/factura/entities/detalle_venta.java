/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.factura.entities;

import java.util.Date;
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
@Table(name = "detalle_venta")
public class detalle_venta {
    
     @Id
    private Integer id_detalle_venta;
    private Integer id_venta;
    private String nomb_producto;
    private String desc_producto;
    private Date fec_cambio;
    private Long id_usuario_cambio;
    private Double precio_producto;
    private Long unidades_existentes;
    
}
