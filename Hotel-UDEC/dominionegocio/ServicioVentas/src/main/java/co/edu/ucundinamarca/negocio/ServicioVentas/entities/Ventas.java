/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioVentas.entities;

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
@Table(name="ventas")
public class Ventas {
    @Column(columnDefinition="serial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private Date fec_venta;
    private Long total_venta;
    private Date fec_cambio;
    private Long id_usuario_cambio;
    
}
