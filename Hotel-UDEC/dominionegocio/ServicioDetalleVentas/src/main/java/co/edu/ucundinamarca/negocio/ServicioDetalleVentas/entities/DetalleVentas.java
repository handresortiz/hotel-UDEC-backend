/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioDetalleVentas.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */

@Entity
@ToString
@Getter
@Setter
@Table(name="detalle_venta")
public class DetalleVentas {
    @Column(columnDefinition="serial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_venta;
    private Long id_venta;
    private Long id_producto;
    private Date fec_cambio;
    private Long id_cuenta;
    private Long id_usuario_cambio;
    private Long val_venta;
    private Date fec_venta;
}
